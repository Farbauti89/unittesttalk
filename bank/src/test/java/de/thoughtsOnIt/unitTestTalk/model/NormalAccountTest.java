package de.thoughtsOnIt.unitTestTalk.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NormalAccountTest {

    @Test
    public void whenMoneyIsDeposited_TheAmountIsAddedToTheCurrentBalance() throws AccountIsFrozenException {

        Double startBalance = 0.0;
        Double depositedAmount = 100.0;
        var account = new Account(1, startBalance);

        account.deposit(depositedAmount);

        assertEquals(depositedAmount, account.getBalance());
    }

    @Test
    public void whenMoneyIsWithdrawn_TheAmountIsRemovedFromTheCurrentBalance() throws WithdrawLimitExceededException, AccountIsFrozenException {

        Double startBalance = 500.0;
        Double withdrawnAmount = 100.0;
        var account = new Account(1, startBalance);

        account.withdraw(withdrawnAmount);

        assertEquals(400.0, account.getBalance());
    }

    @Test
    public void whenMoneyIsWithdrawn_AndTheWithdrawLimitIsExceeded_AWithdrawLimitExceededExceptionIsThrown(){
        var account = new Account(1, 0.0);
        assertThrows(WithdrawLimitExceededException.class,
                     () -> account.withdraw(Double.MAX_VALUE)
        );
    }

    @Test
    public void whenMoneyIsTransferred_TheAmountIsRemovedFromTheSendersCurrentBalance()
            throws AccountIsFrozenException, WithdrawLimitExceededException, BankIsClosedException {
        var sendingAccount = new Account(1, 500.0);
        var receivingAccount = new Account(1, 1_000.0);

        sendingAccount.transfer(500.0, receivingAccount);

        assertEquals(0.0, sendingAccount.getBalance());
    }

    @Test
    public void whenMoneyIsTransferred_TheAmountIsAddedToTheReceiversCurrentBalance()
            throws AccountIsFrozenException, WithdrawLimitExceededException, BankIsClosedException {
        var sendingAccount = new Account(1, 500.0);
        var receivingAccount = new Account(1, 1_000.0);

        sendingAccount.transfer(500.0, receivingAccount);

        assertEquals(1_500.0, receivingAccount.getBalance());
    }
}
