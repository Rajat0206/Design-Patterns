package org.ceo.states;

import org.ceo.apis.ATMBackendAPI;
import org.ceo.apis.NodeATMBackendAPI;
import org.ceo.enums.ATMState;
import org.ceo.factories.StateFactory;
import org.ceo.models.ATM;

public class ReadyForTransactionState extends ATMStateMachine {
    private final ATM atm;
    private final ATMBackendAPI ATMBackendAPI;
    public ReadyForTransactionState(ATM atm) {
        this.atm = atm;
        this.ATMBackendAPI = new NodeATMBackendAPI();
    }

    @Override
    public int initTransaction() {
        int transactionId = this.ATMBackendAPI.createTransaction();

        if(transactionId == 0) {
            throw new RuntimeException("Transaction could not be created");
        }

        this.atm.changeState(StateFactory.getState(ATMState.READ_CARD_DETAILS_AND_PIN, this.atm));
        return transactionId;
    }

    @Override
    public ATMState getState() {
        return ATMState.READY_FOR_TRANSACTION;
    }
}
