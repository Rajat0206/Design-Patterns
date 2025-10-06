package org.ceo.apis;

import org.ceo.models.Card;

public interface CardBackendApi {
    public boolean validateCard(Card card, String pin);
    public boolean checkWithdrawalLimit(int transactionId, double amount);
    public boolean processPayment(Card card, double amount, int transactionId);
}
