package de.thoughtsOnIt.unitTestTalk.infrastructure;

import de.thoughtsOnIt.unitTestTalk.application.AccountRepository;
import de.thoughtsOnIt.unitTestTalk.application.AccountService;
import de.thoughtsOnIt.unitTestTalk.application.DebtCollectionService;
import de.thoughtsOnIt.unitTestTalk.model.Account;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AccountServiceImplTestWithMockito {


    @Test
    void whenMoneyIsWithdrawn_AndTheWithdrawLimitIsExceeded_DebtCollectorsAreSend() {

        var accountRepository = mock(AccountRepository.class);
        var debtCollectionService = mock(DebtCollectionService.class);
        var accountService = new AccountServiceImpl(accountRepository, debtCollectionService);
        var account = new Account(1, 0.0);

        try {
            accountService.withdraw(account, Double.MAX_VALUE);
        } catch(Exception e){}

        verify(debtCollectionService).sendDebtCollectors(eq(account));
    }
}
