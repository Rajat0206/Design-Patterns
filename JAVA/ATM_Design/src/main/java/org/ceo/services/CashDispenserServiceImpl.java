package org.ceo.services;

import org.ceo.apis.BackendAPI;
import org.ceo.apis.NodeBackendAPI;
import org.ceo.models.ATM;

public class CashDispenserServiceImpl implements CashDispenserService {
    private final BackendAPI backendAPI;

    public CashDispenserServiceImpl() {
        this.backendAPI = new NodeBackendAPI();
    }

    @Override
    public void dispenseCash(ATM atm, int transactionId, double amount) {
        double atmAmount = this.backendAPI.getATMAmount(atm.getAtmId());

        if(atmAmount < amount) {
            System.out.println("Insufficient Amount in ATM");
            throw new RuntimeException("Insufficient Amount in ATM");
        }

        System.out.println("Dispensing Cash: " + amount);
    }
}
