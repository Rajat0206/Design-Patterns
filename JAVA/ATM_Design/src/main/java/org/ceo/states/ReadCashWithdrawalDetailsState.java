package org.ceo.states;

import org.ceo.Enums.ATMState;
import org.ceo.models.ATM;

public class ReadCashWithdrawalDetailsState implements ATMStateMachine {

    private final ATM atm;

    public ReadCashWithdrawalDetailsState(ATM atm) {
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
        try {
            this.atm.changeState(new EjectingCardState(this.atm));
            return true;
        } catch (Exception e) {
            throw new IllegalStateException("Cannot Eject Card");
        }
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Cannot Eject Card");
    }

    @Override
    public boolean readCashWithdrawDetails() {
        // logic to validate

        boolean isWithdrawValid = true;
        if(isWithdrawValid) {
            this.atm.changeState(new DispensingCashState(this.atm));
        } else {
            this.atm.changeState(new EjectingCardState(this.atm));
        }

        return isWithdrawValid;
    }

    @Override
    public int dispenseCash() {
        throw new IllegalStateException("Cannot Dispense Cash");
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_CASH_WITHDRAW_DETAILS;
    }
}
