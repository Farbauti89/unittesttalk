package de.thoughtsOnIt.unitTestTalk.application;

import de.thoughtsOnIt.unitTestTalk.model.Account;
import de.thoughtsOnIt.unitTestTalk.model.AccountIsFrozenException;
import de.thoughtsOnIt.unitTestTalk.model.BankIsClosedException;
import de.thoughtsOnIt.unitTestTalk.model.WithdrawLimitExceededException;

public interface AccountService {

    void withdraw(Account account, Double amount) throws WithdrawLimitExceededException, AccountIsFrozenException;
    void deposit(Account account, Double amount) throws AccountIsFrozenException;
    void transfer(Account sender, Account receiver, Double amount) throws WithdrawLimitExceededException, AccountIsFrozenException, BankIsClosedException;

}
