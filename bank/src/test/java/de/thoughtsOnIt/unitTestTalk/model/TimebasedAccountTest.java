package de.thoughtsOnIt.unitTestTalk.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimebasedAccountTest {

    @Test
    public void whenMoneyIsTransferred_AndItsPastTheOpeningHour_ABankIsClosedExceptionisThrown()
            throws AccountIsFrozenException, BankIsClosedException, WithdrawLimitExceededException {
        var sendingAccount = new Account(1, 500.0);
        var receivingAccount = new Account(1, 1_000.0);

        assertThrows(BankIsClosedException.class, () ->
                sendingAccount.transfer(500.0, receivingAccount)
        );
    }

}
