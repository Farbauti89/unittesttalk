package de.thoughtsOnIt.unitTestTalk.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FrozenAccountTest {


    @Test
    public void whenMoneyIsDeposited_AndTheAccountIsFrozen_AAccountIsFrozenExceptionIsThrown(){
        var account = new Account(1, 0.0);
        account.freeze();

        assertThrows(AccountIsFrozenException.class,
                     () -> account.deposit(100.0)
        );
    }

    @Test
    public void whenMoneyIsWithdrawn_AndTheAccountIsFrozen_AAccountIsFrozenExceptionIsThrown(){
        var account = new Account(1, 0.0);
        account.freeze();

        assertThrows(AccountIsFrozenException.class,
                     () -> account.withdraw(100.0)
        );
    }

    @Test
    public void whenMoneyIsTransferred_AndTheSendingAccountIsFrozen_AAccountIsFrozenExceptionIsThrown(){
        var sender = new Account(1, 0.0);
        sender.freeze();

        var receiver = new Account(1, 0.0);

        assertThrows(AccountIsFrozenException.class,
                     () -> sender.transfer(100.0, receiver)
        );
    }

    @Test
    public void whenMoneyIsTransferred_AndTheReceivingAccountIsFrozen_AAccountIsFrozenExceptionIsThrown(){
        var sender = new Account(1, 0.0);
        var receiver = new Account(1, 0.0);
        receiver.freeze();

        assertThrows(AccountIsFrozenException.class,
                     () -> sender.transfer(100.0, receiver)
        );
    }
}
