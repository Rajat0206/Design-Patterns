package org.ceo.states;

import org.ceo.Enums.ATMState;

public interface ATMStateMachine {
    int initTransaction();                      //returns transaction id
    boolean readCardDetailsAndPin();
    boolean cancelTransaction();
    void ejectCard();
    boolean readCashWithdrawDetails();
    int dispenseCash();
    ATMState getState();
}
