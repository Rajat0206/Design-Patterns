package org.ceo.states;

import org.ceo.Enums.ATMState;
import org.ceo.models.ATM;

public class ReadyForTransactionState implements ATMStateMachine {
    private ATM atm;

    public ATM getAtm(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTransaction() {

    }

    @Override
    public boolean readCardDetailsAndPin() {
        throw new IllegalStateException("Cannot Read Card");
    }

    @Override
    public boolean cancelTransaction() {
        throw new IllegalStateException("Cannot Cancel Transaction");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot Eject Card");
    }

    @Override
    public int dispenseCash() {
        throw new IllegalStateException("Cannot Dispense Cash");
    }

    @Override
    public ATMState getState() {
        return ATMState.READY_FOR_TRANSACTION;
    }
}
