package org.ceo.models;

import org.ceo.Enums.ATMState;
import org.ceo.states.ATMStateMachine;
import org.ceo.states.ReadyForTransactionState;

public class ATM {
    private final String atmId;
    private ATMStateMachine atmStateMachine;

    public ATM(String atmId) {
        this.atmId = atmId;
        this.atmStateMachine = new ReadyForTransactionState(this);
    }

    public int initTransaction() {
        try {
            return atmStateMachine.initTransaction();
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean readCardDetailsAndPin() {
        try {
            return atmStateMachine.readCardDetailsAndPin();
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean readCashWithdrawDetails() {
        try {
            return atmStateMachine.readCashWithdrawDetails();
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean cancelTransaction() {
        try {
            return atmStateMachine.cancelTransaction();
        } catch (Exception e) {
            throw e;
        }
    }

    public void ejectCard() {
        try {
            atmStateMachine.ejectCard();
        } catch (Exception e) {
            throw e;
        }
    }

    public int dispenseCash() {
        try {
            return atmStateMachine.dispenseCash();
        } catch (Exception e) {
            throw e;
        }
    }

    public String getAtmId() {
        return atmId;
    }

    public void changeState(ATMStateMachine newState) {
        this.atmStateMachine = newState;
    }
}
