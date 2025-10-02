package org.ceo.models;

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

    public boolean readCardDetailsAndPin(Card card, String pin) {
        try {
            return atmStateMachine.readCardDetailsAndPin(card, pin);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean readCashWithdrawDetails(Card card, double amount, int transactionId) {
        try {
            return atmStateMachine.readCashWithdrawDetails(card, amount, transactionId);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean cancelTransaction(int transactionId) {
        try {
            return atmStateMachine.cancelTransaction(transactionId);
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

    public int dispenseCash(Card card, double amount, int transactionId) {
        try {
            return atmStateMachine.dispenseCash(card, amount, transactionId);
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
