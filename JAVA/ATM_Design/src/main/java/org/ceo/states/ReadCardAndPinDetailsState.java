package org.ceo.states;

import org.ceo.apis.ATMBackendAPI;
import org.ceo.apis.NodeATMBackendAPI;
import org.ceo.enums.ATMState;
import org.ceo.factories.CardManagerFactory;
import org.ceo.factories.StateFactory;
import org.ceo.models.ATM;
import org.ceo.models.Card;
import org.ceo.services.CardManagerService;

public class ReadCardAndPinDetailsState extends ATMStateMachine{
    private final ATM atm;
    private final ATMBackendAPI ATMBackendAPI;

    public ReadCardAndPinDetailsState(ATM atm) {
        this.atm = atm;
        this.ATMBackendAPI = new NodeATMBackendAPI();
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManager(card.getNetworkType(), card.getCardType());
        boolean isCardValid = cardManagerService.validateCard(card, pin);

        if(isCardValid) {
            this.atm.changeState(StateFactory.getState(ATMState.READ_CASH_WITHDRAW_DETAILS, this.atm));
        } else {
            this.atm.changeState(StateFactory.getState(ATMState.EJECTING_CARD, this.atm));
        }

        return isCardValid;
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
    public ATMState getState() {
        return ATMState.READ_CARD_DETAILS_AND_PIN;
    }
}
