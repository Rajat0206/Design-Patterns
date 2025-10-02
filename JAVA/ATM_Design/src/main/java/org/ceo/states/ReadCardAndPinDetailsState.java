package org.ceo.states;

import org.ceo.enums.ATMState;
import org.ceo.models.ATM;
import org.ceo.models.Card;

public class ReadCardAndPinDetailsState extends ATMStateMachine{
    private final ATM atm;

    ReadCardAndPinDetailsState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
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
    public boolean cancelTransaction(int transactionId) {
        try {
            this.atm.changeState(new EjectingCardState(this.atm));
            return true;
        } catch (Exception e) {
            throw new IllegalStateException("Cannot Eject Card");
        }
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_CARD_DETAILS_AND_PIN;
    }
}
