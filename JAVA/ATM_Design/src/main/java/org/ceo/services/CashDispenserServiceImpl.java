package org.ceo.services;

import org.ceo.apis.ATMBackendAPI;
import org.ceo.apis.NodeATMBackendAPI;
import org.ceo.models.ATM;

public class CashDispenserServiceImpl implements CashDispenserService {
    private final ATMBackendAPI ATMBackendAPI;

    public CashDispenserServiceImpl() {
        this.ATMBackendAPI = new NodeATMBackendAPI();
    }

    @Override
    public void dispenseCash(ATM atm, int transactionId, double amount) {
        double atmAmount = this.ATMBackendAPI.getATMAmount(atm.getAtmId());

        if(atmAmount < amount) {
            System.out.println("Insufficient Amount in ATM");
            throw new RuntimeException("Insufficient Amount in ATM");
        }

        System.out.println("Dispensing Cash: " + amount);
    }
}
