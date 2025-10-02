package org.ceo.factories;

import org.ceo.enums.CardType;
import org.ceo.services.CardManagerService;
import org.ceo.services.CreditCardManagerService;
import org.ceo.services.DebitCardManagerService;

public class CardManagerFactory {
    public static CardManagerService getCardManager(CardType cardType) {
        CardManagerService cardManagerService = null;

        if(cardType.equals(CardType.DEBIT)) {
            cardManagerService = new DebitCardManagerService();
        } else if(cardType.equals(CardType.CREDIT)) {
            cardManagerService = new CreditCardManagerService();
        } else {
            throw new IllegalArgumentException("Invalid Card Type");
        }

        return cardManagerService;
    }
}
