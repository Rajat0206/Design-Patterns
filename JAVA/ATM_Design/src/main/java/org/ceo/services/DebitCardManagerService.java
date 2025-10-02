package org.ceo.services;

import org.ceo.models.Card;

public class DebitCardManagerService implements CardManagerService{
    @Override
    public boolean validateCard(Card card, String pin) {
        return false;
    }

    @Override
    public boolean validateWithdrawal(int transactionId, double amount) {
        return false;
    }

    @Override
    public boolean doTransaction(Card card, double amount, int transactionId) {
        return false;
    }
}
