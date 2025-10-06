package org.ceo.states;

import org.ceo.apis.BackendAPI;
import org.ceo.apis.NodeBackendAPI;
import org.ceo.enums.ATMState;
import org.ceo.models.ATM;

public class ReadyForTransactionState extends ATMStateMachine {
    private final ATM atm;
    private final BackendAPI backendAPI;
    public ReadyForTransactionState(ATM atm) {
        this.atm = atm;
        this.backendAPI = new NodeBackendAPI();
    }

    @Override
    public int initTransaction() {
        int transactionId = this.backendAPI.createTransaction();

        if(transactionId == 0) {
            throw new RuntimeException("Transaction could not be created");
        }

        this.atm.changeState(new ReadCardAndPinDetailsState(this.atm));
        return transactionId;
    }

    @Override
    public ATMState getState() {
        return ATMState.READY_FOR_TRANSACTION;
    }
}
