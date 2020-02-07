package de.thoughtsOnIt.unitTestTalk.model;

public class WithdrawLimitExceededException extends Exception {

    public WithdrawLimitExceededException(String accountId) {
        super(String.format("Account '%s' tried to withdraw money which would exceed the withdrawlimit.", accountId));
    }
}
