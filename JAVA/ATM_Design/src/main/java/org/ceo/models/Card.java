package org.ceo.models;

import org.ceo.enums.CardType;

public class Card {
    private final long cardNumber;
    private final String name;
    private final String pin;
    private final String bankName;
    private final CardType type;

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", name='" + name + '\'' +
                ", pin='" + pin + '\'' +
                ", bankName='" + bankName + '\'' +
                ", type=" + type +
                '}';
    }

    public Card(long cardNumber, String name, String pin, String bankName, CardType type) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.pin = pin;
        this.bankName = bankName;
        this.type = type;
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

    public CardType getType() {
        return type;
    }
}
