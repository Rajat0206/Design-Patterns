package org.ceo.states;

import org.ceo.Enums.ATMState;
import org.ceo.models.ATM;

public class ReadCardAndPinDetailsState implements ATMStateMachine{
    private final ATM atm;

    ReadCardAndPinDetailsState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int initTransaction() {
        throw new IllegalStateException("Cannot Init Transaction");
    }

    @Override
    public boolean readCardDetailsAndPin() {
        // logic to check pin and card validation
        boolean isCardValid = true;

        if(isCardValid) {
            this.atm.changeState(new ReadCashWithdrawalDetailsState(this.atm));
        } else {
            this.atm.changeState(new EjectingCardState(this.atm));
        }

        return isCardValid;
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
        throw new IllegalStateException("Cannot Read Cash Withdraw Details");
    }

    @Override
    public int dispenseCash() {
        throw new IllegalStateException("Cannot Dispense Cash");
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_CARD_DETAILS_AND_PIN;
    }
}
