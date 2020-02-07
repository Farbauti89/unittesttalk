package de.thoughtsOnIt.unitTestTalk.model;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import de.thoughtsOnIt.unitTestTalk.infrastructure.DateTimeProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StubbedTimebasedAccountTest {

    @Test
    public void whenMoneyIsTransferred_AndItsPastTheOpeningHour_ABankIsClosedExceptionisThrown()
            throws AccountIsFrozenException, BankIsClosedException, WithdrawLimitExceededException {
        var sendingAccount = new Account(1, 500.0);
        var receivingAccount = new Account(1, 1_000.0);
        DateTimeProvider.setStubLocalDateTime(LocalDateTime.of(2020, 1, 1, 19, 0, 0));

        assertThrows(BankIsClosedException.class, () ->
                sendingAccount.transfer(500.0, receivingAccount)
        );

        DateTimeProvider.resetStubLocalDateTime();
    }

    @Test
    public void whenMoneyIsTransferred_AndItsPastTheOpeningHour_ABankIsClosedExceptionisThrown2()
            throws AccountIsFrozenException, BankIsClosedException, WithdrawLimitExceededException {
        var sendingAccount = new Account(1, 500.0);
        var receivingAccount = new Account(1, 1_000.0);
        Clock stubbedClock = Clock.fixed(Instant.parse("2020-01-01T18:00:00.00Z"), ZoneId.of("Europe/Paris"));

        assertThrows(BankIsClosedException.class, () ->
                sendingAccount.transfer(500.0, receivingAccount, stubbedClock)
        );

        DateTimeProvider.resetStubLocalDateTime();
    }

}
