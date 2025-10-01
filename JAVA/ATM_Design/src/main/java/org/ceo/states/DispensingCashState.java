package org.ceo.states;

import org.ceo.Enums.ATMState;

public class DispensingCashState implements ATMStateMachine {
    @Override
    public int initTransaction() {
        return 0;
    }

    @Override
    public boolean readCardDetailsAndPin() {
        return false;
    }

    @Override
    public boolean cancelTransaction() {
        return false;
    }

    @Override
    public void ejectCard() {

    }

    @Override
    public int dispenseCash() {
        return 0;
    }

    @Override
    public ATMState getState() {
        return null;
    }
}
