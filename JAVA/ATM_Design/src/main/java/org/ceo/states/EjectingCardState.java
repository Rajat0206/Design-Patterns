package org.ceo.states;

import org.ceo.Enums.ATMState;
import org.ceo.models.ATM;

public class EjectingCardState implements ATMStateMachine{
    private final ATM atm;

    public EjectingCardState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot Init Transaction");
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
        System.out.println("Ejected Card Successfully");
        this.atm.changeState(new ReadyForTransactionState(this.atm));
    }

    @Override
    public boolean readCashWithdrawDetails() {
        throw new IllegalStateException("Cannot Read Cash Withdraw Details");
    }

    @Override
    public int dispenseCash() {
        throw new IllegalStateException("Cannot Dispense Cash");
    }

    @Override
    public ATMState getState() {
        return ATMState.EJECTING_CARD;
    }
}
