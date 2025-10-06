package org.ceo.states;

import org.ceo.enums.ATMState;
import org.ceo.factories.CardManagerFactory;
import org.ceo.factories.StateFactory;
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
            this.atm.changeState(StateFactory.getState(ATMState.EJECTING_CARD, this.atm));
            return true;
        } catch (Exception e) {
            throw new IllegalStateException("Cannot Eject Card");
        }
    }

    @Override
    public boolean readCashWithdrawDetails(Card card, double amount, int transactionId) {
        CardManagerService manager = CardManagerFactory.getCardManager(card.getNetworkType(), card.getCardType());
        boolean isWithdrawValid = manager.validateWithdrawal(transactionId, amount);

        if(isWithdrawValid) {
            this.atm.changeState(StateFactory.getState(ATMState.DISPENSING_CASH, this.atm));
        } else {
            this.atm.changeState(StateFactory.getState(ATMState.EJECTING_CARD, this.atm));
        }

        return isWithdrawValid;
    }

    @Override
    public ATMState getState() {
        return ATMState.READ_CASH_WITHDRAW_DETAILS;
    }
}
