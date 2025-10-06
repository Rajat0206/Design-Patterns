package org.ceo.factories;

import org.ceo.enums.CardNetworkType;
import org.ceo.enums.CardType;
import org.ceo.services.CardManagerService;
import org.ceo.services.VisaCreditCardManagerService;
import org.ceo.services.VisaDebitCardManagerService;

public class CardManagerFactory {
    public static CardManagerService getCardManager(CardNetworkType networkType, CardType cardType) {
        if (networkType == CardNetworkType.VISA && cardType == CardType.DEBIT) {
            return new VisaDebitCardManagerService();
        } else if (networkType == CardNetworkType.VISA && cardType == CardType.CREDIT) {
            return new VisaCreditCardManagerService();
        }
//        else if (networkType == CardNetworkType.MASTERCARD && cardType == CardType.DEBIT) {
//            return new MasterCardDebitCardManagerService();
//        } else if (networkType == CardNetworkType.MASTERCARD && cardType == CardType.CREDIT) {
//            return new MasterCardCreditCardManagerService();
//        }
        throw new IllegalArgumentException("Unsupported card/network combination");
    }
}
