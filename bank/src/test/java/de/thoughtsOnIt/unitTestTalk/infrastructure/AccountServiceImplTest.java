package de.thoughtsOnIt.unitTestTalk.infrastructure;

import de.thoughtsOnIt.unitTestTalk.application.AccountService;
import de.thoughtsOnIt.unitTestTalk.model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {

    @Test
    void whenMoneyIsWithdrawn_AndTheWithdrawLimitIsExceeded_DebtCollectorsAreSend() {
        var accountRepository = new InMemoryAccountRepository();
        var debtCollectionService = new MockDebtCollectionService();
        var accountService = new AccountServiceImpl(accountRepository, debtCollectionService);
        var account = new Account(1, 0.0);

        try {
            accountService.withdraw(account, Double.MAX_VALUE);
        } catch(Exception e){}

        assertTrue(debtCollectionService.sendDebtCollectorsWasCalled());
    }
}
