package org.ceo.states;

import org.ceo.enums.ATMState;
import org.ceo.models.ATM;
import org.ceo.models.Card;

public class DispensingCashState extends ATMStateMachine {
    private final ATM atm;

    public DispensingCashState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int dispenseCash(Card card, int amount, int transactionId) {
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
