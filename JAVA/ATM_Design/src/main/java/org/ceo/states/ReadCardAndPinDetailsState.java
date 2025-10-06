package org.ceo.states;

import org.ceo.apis.BackendAPI;
import org.ceo.apis.NodeBackendAPI;
import org.ceo.enums.ATMState;
import org.ceo.factories.CardManagerFactory;
import org.ceo.models.ATM;
import org.ceo.models.Card;
import org.ceo.services.CardManagerService;

public class ReadCardAndPinDetailsState extends ATMStateMachine{
    private final ATM atm;
    private final BackendAPI backendAPI;

    ReadCardAndPinDetailsState(ATM atm) {
        this.atm = atm;
        this.backendAPI = new NodeBackendAPI();
    }

    @Override
    public boolean readCardDetailsAndPin(Card card, String pin) {
        CardManagerService cardManagerService = CardManagerFactory.getCardManager(card.getType());
        boolean isCardValid = cardManagerService.validateCard(card, pin);

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
