package de.thoughtsOnIt.unitTestTalk.model;

public class AccountIsFrozenException extends Exception{

    public AccountIsFrozenException(String accountId) {
        super(String.format("Account '%s' is frozen and no interaction with it is possible.", accountId));
    }

}
