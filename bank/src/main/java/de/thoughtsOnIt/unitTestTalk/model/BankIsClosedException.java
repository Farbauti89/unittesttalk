package de.thoughtsOnIt.unitTestTalk.model;

public class BankIsClosedException extends Exception {

    public BankIsClosedException() {
        super("The bank is closed. Please try again tomorrow!");
    }
}
