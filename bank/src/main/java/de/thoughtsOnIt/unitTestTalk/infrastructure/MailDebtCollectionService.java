package de.thoughtsOnIt.unitTestTalk.infrastructure;

import de.thoughtsOnIt.unitTestTalk.application.DebtCollectionService;
import de.thoughtsOnIt.unitTestTalk.model.Account;

public class MailDebtCollectionService implements DebtCollectionService {

    @Override
    public void sendDebtCollectors(Account account) {
        // send an email to a debt collector
    }
}
