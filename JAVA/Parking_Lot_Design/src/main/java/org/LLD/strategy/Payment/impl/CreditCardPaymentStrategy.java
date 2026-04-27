package org.LLD.strategy.Payment.impl;

import org.LLD.strategy.Payment.PaymentStrategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(Long amount) {
        System.out.println(amount + "Paid via CC");
    }
}
