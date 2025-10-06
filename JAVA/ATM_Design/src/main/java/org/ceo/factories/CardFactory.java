package org.ceo.factories;

import org.ceo.enums.CardNetworkType;
import org.ceo.enums.CardType;
import org.ceo.models.Card;
import org.ceo.models.VisaCreditCard;
import org.ceo.models.VisaDebitCard;

public class CardFactory  {
    public static Card createCard(CardNetworkType networkType, CardType cardType, long cardNumber, String pin, String name, String bankName) {
        switch (networkType) {
            case VISA:
                return cardType == CardType.DEBIT
                        ? new VisaDebitCard.Builder().cardNumber(cardNumber).pin(pin).name(name).cardType(cardType).bankName(bankName).build()
                        : new VisaCreditCard.Builder().cardNumber(cardNumber).pin(pin).name(name).cardType(cardType).bankName(bankName).build();
//            case MASTERCARD:
//                return cardType == CardType.DEBIT
//                        ? new MasterCardDebitCard(cardNumber, pin, name, cardType, bankName)
//                        : new MasterCardCreditCard(cardNumber, pin, name, cardType, bankName);
            default:
                throw new IllegalArgumentException("Unsupported card network/type");
        }
    }
}
