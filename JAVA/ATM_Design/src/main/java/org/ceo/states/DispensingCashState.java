package org.ceo.states;

import org.ceo.enums.ATMState;
import org.ceo.factories.CardManagerFactory;
import org.ceo.factories.StateFactory;
import org.ceo.models.ATM;
import org.ceo.models.Card;
import org.ceo.services.CardManagerService;
import org.ceo.services.CashDispenserService;
import org.ceo.services.CashDispenserServiceImpl;

public class DispensingCashState extends ATMStateMachine {
    private final ATM atm;
    private final CashDispenserService cashDispenserService;

    public DispensingCashState(ATM atm) {
        this.atm = atm;
        this.cashDispenserService = new CashDispenserServiceImpl();
    }

    @Override
    public int dispenseCash(Card card, double amount, int transactionId) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManager(card.getNetworkType(), card.getCardType());
        boolean isTxnSuccessful = cardManagerService.doTransaction(card, amount, transactionId);
        if(isTxnSuccessful) {
            this.cashDispenserService.dispenseCash(this.atm, transactionId, amount);
            System.out.println("Trx Successful");
        } else {
            System.out.println("Something went Wrong");
        }

        this.atm.changeState(StateFactory.getState(ATMState.EJECTING_CARD, this.atm));
        return 0;
    }

    @Override
    public ATMState getState() {
        return ATMState.DISPENSING_CASH;
    }
}
