package org.ceo.states;

import org.ceo.enums.ATMState;
import org.ceo.models.ATM;

public class EjectingCardState extends ATMStateMachine{
    private final ATM atm;

    public EjectingCardState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void ejectCard() {
        System.out.println("Ejected Card Successfully");
        this.atm.changeState(new ReadyForTransactionState(this.atm));
    }

    @Override
    public ATMState getState() {
        return ATMState.EJECTING_CARD;
    }
}
