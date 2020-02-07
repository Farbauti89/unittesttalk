package de.thoughtsOnIt.unitTestTalk.infrastructure;

import de.thoughtsOnIt.unitTestTalk.application.DebtCollectionService;
import de.thoughtsOnIt.unitTestTalk.model.Account;

public class MockDebtCollectionService implements DebtCollectionService {

    private boolean sendDebtCollectorsWasCalled = false;

    @Override
    public void sendDebtCollectors(Account account) {
        sendDebtCollectorsWasCalled = true;
    }

    public boolean sendDebtCollectorsWasCalled() {
        return sendDebtCollectorsWasCalled;
    }
}
