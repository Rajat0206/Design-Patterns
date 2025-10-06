package org.ceo.states;

import org.ceo.enums.ATMState;
import org.ceo.factories.CardManagerFactory;
import org.ceo.models.ATM;
import org.ceo.models.Card;
import org.ceo.services.CardManagerService;

public class ReadCashWithdrawalDetailsState extends ATMStateMachine {

    private final ATM atm;

    public ReadCashWithdrawalDetailsState(ATM atm) {
        this.atm = atm;
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
    public boolean readCashWithdrawDetails(Card card, double amount, int transactionId) {
        CardManagerService manager = CardManagerFactory.getCardManager(card.getType());
        boolean isWithdrawValid = manager.validateWithdrawal(transactionId, amount);

        if(isWithdrawValid) {
            this.atm.changeState(new DispensingCashState(this.atm));
        } else {
            this.atm.changeState(new EjectingCardState(this.atm));
        }

        return isWithdrawValid;
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_CASH_WITHDRAW_DETAILS;
    }
}
