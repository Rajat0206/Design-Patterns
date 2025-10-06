package org.ceo.apis;

import org.ceo.models.Card;

public class VisaBackendAPI implements CardBackendApi {
    @Override
    public boolean validateCard(Card card, String pin) {
        //it should be an api call to validate card, here we have hard coded card object manually so skipping it
        return card.getPin().equals(pin);
    }

    @Override
    public boolean checkWithdrawalLimit(int transactionId, double amount) {
        return true;
    }

    @Override
    public boolean processPayment(Card card, double amount, int transactionId) {
        return true;
    }
}