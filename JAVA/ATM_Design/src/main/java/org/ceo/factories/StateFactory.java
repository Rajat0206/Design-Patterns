package org.ceo.factories;

import org.ceo.enums.ATMState;
import org.ceo.models.ATM;
import org.ceo.states.*;

public class StateFactory {

    public static ATMStateMachine getState(ATMState state, ATM atm) {
        switch (state) {
            case READY_FOR_TRANSACTION:
                return new ReadyForTransactionState(atm);
            case READ_CARD_DETAILS_AND_PIN:
                return new ReadCardAndPinDetailsState(atm);
            case READ_CASH_WITHDRAW_DETAILS:
                return new ReadCashWithdrawalDetailsState(atm);
            case DISPENSING_CASH:
                return new DispensingCashState(atm);
            case EJECTING_CARD:
                return new EjectingCardState(atm);
            default:
                throw new IllegalArgumentException("Unknown ATM state: " + state);
        }
    }
}