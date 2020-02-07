package de.thoughtsOnIt.unitTestTalk.infrastructure;

import java.util.HashMap;
import java.util.Map;

import de.thoughtsOnIt.unitTestTalk.application.AccountRepository;
import de.thoughtsOnIt.unitTestTalk.model.Account;

public class InMemoryAccountRepository implements AccountRepository {

    private Map<String, Account> database = new HashMap<>();

    @Override
    public Account save(Account account) {
        return database.put(account.getAccountId(), account);
    }
}
