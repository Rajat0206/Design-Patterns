package org.ceo.enums;

// For Representation of Different Types of ATM States
public enum ATMState {
    READY_FOR_TRANSACTION,
    READ_CARD_DETAILS_AND_PIN,
    DISPENSING_CASH,
    EJECTING_CARD,
    READ_CASH_WITHDRAW_DETAILS
}
