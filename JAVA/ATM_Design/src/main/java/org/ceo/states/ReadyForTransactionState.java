package org.ceo.states;

import org.ceo.enums.ATMState;
import org.ceo.models.ATM;

public class ReadyForTransactionState extends ATMStateMachine {
    private final ATM atm;

    public ReadyForTransactionState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        //logic to connect to backend and give transaction id

        int transactionId = 1234;
        this.atm.changeState(new ReadCardAndPinDetailsState(this.atm));
        return transactionId;
    }

    @Override
    public ATMState getState() {
        return ATMState.READY_FOR_TRANSACTION;
    }
}
