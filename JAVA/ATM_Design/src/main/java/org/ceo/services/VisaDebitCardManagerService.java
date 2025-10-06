package org.ceo.services;

import org.ceo.apis.CardBackendApi;
import org.ceo.apis.VisaBackendAPI;
import org.ceo.models.Card;

public class VisaDebitCardManagerService implements CardManagerService {
    private final CardBackendApi visaBackendAPI = new VisaBackendAPI();

    @Override
    public boolean validateCard(Card card, String pin) {
        // Visa validation logic (could be different)
        return visaBackendAPI.validateCard(card, pin);
    }

    @Override
    public boolean validateWithdrawal(int transactionId, double amount) {
        // Visa limits
        return visaBackendAPI.checkWithdrawalLimit(transactionId, amount);
    }

    @Override
    public boolean doTransaction(Card card, double amount, int transactionId) {
        // Visa payment logic
        return visaBackendAPI.processPayment(card, amount, transactionId);
    }
}
