package de.thoughtsOnIt.unitTestTalk.model;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

import de.thoughtsOnIt.unitTestTalk.infrastructure.DateTimeProvider;

public class Account {

    private String accountId;
    private long bankId;
    private Double balance;
    private Double withdrawLimit;
    private boolean frozen;

    public Account(long bankId, Double balance) {
        accountId = UUID.randomUUID().toString();
        this.bankId = bankId;
        this.balance = balance;
        withdrawLimit = -500.0;
    }

    public void withdraw(Double amount) throws WithdrawLimitExceededException, AccountIsFrozenException {

        if (isFrozen()) {
            throw new AccountIsFrozenException(accountId);
        }

        if (balance - amount < withdrawLimit) {
            throw new WithdrawLimitExceededException(accountId);
        }

        balance -= amount;
    }

    public void deposit(Double amount) throws AccountIsFrozenException {
        if (isFrozen()) {
            throw new AccountIsFrozenException(accountId);
        }

        balance += amount;
    }

    public void transfer(Double amount, Account receiver) throws WithdrawLimitExceededException, AccountIsFrozenException, BankIsClosedException {
        transfer(amount, receiver, Clock.systemDefaultZone());
    }

    public void transfer(Double amount, Account receiver, Clock clock) throws WithdrawLimitExceededException, AccountIsFrozenException, BankIsClosedException {
        if (isFrozen()) {
            throw new AccountIsFrozenException(accountId);
        }

        int currentHour = LocalDateTime.now(clock).getHour();
        //int currentHour = DateTimeProvider.now().getHour();
        if (currentHour >= 18 || currentHour < 9) {
            throw new BankIsClosedException();
        }

        withdraw(amount);
        receiver.deposit(amount);
    }

    public void freeze() {
        frozen = true;
    }

    public String getAccountId() {
        return accountId;
    }

    public long getBankId() {
        return bankId;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public boolean isFrozen() {
        return frozen;
    }

}
