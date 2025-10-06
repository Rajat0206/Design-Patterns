package org.ceo.models;

import org.ceo.enums.CardNetworkType;
import org.ceo.enums.CardType;

public class VisaCreditCard extends Card implements Visa, Debit {
    private VisaCreditCard(Builder builder) {
        super(builder.cardNumber, builder.pin, builder.name, builder.cardType, builder.bankName, CardNetworkType.VISA);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long cardNumber;
        private String pin;
        private String name;
        private CardType cardType;
        private String bankName;

        public Builder cardNumber(long cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }
        public Builder pin(String pin) {
            this.pin = pin;
            return this;
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder cardType(CardType cardType) {
            this.cardType = cardType;
            return this;
        }
        public Builder bankName(String bankName) {
            this.bankName = bankName;
            return this;
        }
        public VisaCreditCard build() {
            return new VisaCreditCard(this);
        }
    }

    @Override
    public void makePinPayment() {
        this.connectToVisa();
        System.out.println("Making payment with pin via Visa");
    }

    @Override
    public void connectToVisa() {
        System.out.println("Connecting to Visa");
    }
}