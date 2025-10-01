package org.ceo.states;

import org.ceo.Enums.ATMState;
import org.ceo.models.ATM;

public class DispensingCashState implements ATMStateMachine {
    private final ATM atm;

    public DispensingCashState(ATM atm) {
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
        throw new IllegalStateException("Cannot Eject Card");
    }

    @Override
    public boolean readCashWithdrawDetails() {
        throw new IllegalStateException("Cannot Read Cash Withdraw Details");
    }

    @Override
    public int dispenseCash() {
        // logic to do transaction

        boolean isTxnSuccessful = true;
        if(isTxnSuccessful) {
            System.out.println("Trx Successful");
        } else {
            System.out.println("Something went Wrong");
        }

        this.atm.changeState(new EjectingCardState(this.atm));
        return 0;
    }

    @Override
    public ATMState getState() {
        return ATMState.DISPENSING_CASH;
    }
}
