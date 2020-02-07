package de.thoughtsOnIt.unitTestTalk.infrastructure;

import de.thoughtsOnIt.unitTestTalk.application.AccountRepository;
import de.thoughtsOnIt.unitTestTalk.application.AccountService;
import de.thoughtsOnIt.unitTestTalk.application.DebtCollectionService;
import de.thoughtsOnIt.unitTestTalk.model.Account;
import de.thoughtsOnIt.unitTestTalk.model.AccountIsFrozenException;
import de.thoughtsOnIt.unitTestTalk.model.BankIsClosedException;
import de.thoughtsOnIt.unitTestTalk.model.WithdrawLimitExceededException;

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private DebtCollectionService debtCollectionService;

    public AccountServiceImpl(AccountRepository accountRepository, DebtCollectionService debtCollectionService) {
        this.accountRepository = accountRepository;
        this.debtCollectionService = debtCollectionService;
    }

    @Override
    public void withdraw(Account account, Double amount) throws WithdrawLimitExceededException, AccountIsFrozenException {
        try {
            account.withdraw(amount);
            accountRepository.save(account);
        } catch (WithdrawLimitExceededException e) {
            debtCollectionService.sendDebtCollectors(account);
            throw e;
        }

    }

    @Override
    public void deposit(Account account, Double amount) throws AccountIsFrozenException {
        account.deposit(amount);
        accountRepository.save(account);
    }

    @Override
    public void transfer(Account sender, Account receiver, Double amount) throws WithdrawLimitExceededException, AccountIsFrozenException, BankIsClosedException {
        try {
            sender.transfer(amount, receiver);
            accountRepository.save(sender);
            accountRepository.save(receiver);
        } catch (WithdrawLimitExceededException e) {
            debtCollectionService.sendDebtCollectors(sender);
            throw e;
        }
    }
}
