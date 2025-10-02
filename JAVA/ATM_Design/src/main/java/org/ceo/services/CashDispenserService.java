package org.ceo.services;

import org.ceo.models.ATM;

public interface CashDispenserService {
    public void dispenseCash(ATM atm, int transactionId, double amount);
}
