package org.ceo.models;

import org.ceo.enums.CardNetworkType;
import org.ceo.enums.CardType;

public class Card {
    private final long cardNumber;
    private final String pin;
    private final String name;
    private final CardType cardType;
    private final String bankName;
    private final CardNetworkType networkType;

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", pin=" + pin +
                ", name='" + name + '\'' +
                ", cardType=" + cardType +
                ", bankName='" + bankName + '\'' +
                ", networkType=" + networkType +
                '}';
    }

    public Card(long cardNumber, String pin, String name, CardType cardType, String bankName, CardNetworkType networkType) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.name = name;
        this.cardType = cardType;
        this.bankName = bankName;
        this.networkType = networkType;
    }


    public long getCardNumber() {
        return cardNumber;
    }

    public String getName() {
        return name;
    }

    public String getPin() {
        return pin;
    }

    public String getBankName() {
        return bankName;
    }

    public CardType getCardType() { return cardType; }

    public CardNetworkType getNetworkType() { return networkType; }
}
