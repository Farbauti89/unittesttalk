package de.thoughtsOnIt.unitTestTalk.infrastructure;

import de.thoughtsOnIt.unitTestTalk.application.AccountRepository;
import de.thoughtsOnIt.unitTestTalk.model.Account;

public class JpaAccountRepository implements AccountRepository {

    @Override
    public Account save(Account account) {
        //doing some persistence stuff

        return account;
    }
}
