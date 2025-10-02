package org.ceo.states;

import org.ceo.enums.ATMState;
import org.ceo.models.Card;

public abstract class ATMStateMachine {
    //returns transaction id
    public int initTransaction() {
        throw new IllegalStateException("Cannot Init Transaction");
    }
    public boolean readCardDetailsAndPin(Card card, String pin) {
        throw new IllegalStateException("Cannot Read Card");
    }
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot Cancel Transaction");
    }
    public void ejectCard() {
        throw new IllegalStateException("Cannot Eject Card");
    }
    public boolean readCashWithdrawDetails(Card card, double amount, int transactionId) {
        throw new IllegalStateException("Cannot Read Cash Withdraw Details");
    }
    public int dispenseCash(Card card, double amount, int transactionId) {
        throw new IllegalStateException("Cannot Dispense Cash");
    }

    abstract ATMState getState();
}
