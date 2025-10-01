package org.ceo.states;

import org.ceo.Enums.ATMState;
import org.ceo.models.ATM;

public class ReadyForTransactionState implements ATMStateMachine {
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
        throw new IllegalStateException("Cannot Dispense Cash");
    }

    @Override
    public ATMState getState() {
        return ATMState.READY_FOR_TRANSACTION;
    }
}
