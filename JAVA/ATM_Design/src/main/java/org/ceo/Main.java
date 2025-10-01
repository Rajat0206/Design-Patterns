package org.ceo;

import org.ceo.models.ATM;
import org.ceo.states.ATMStateMachine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ATM atm = new ATM("2424");
        // Ready State
        atm.initTransaction();

        // Card Reading
        atm.readCardDetailsAndPin();

        // Withdraw Details Reading
        atm.readCashWithdrawDetails();

        // Cash Dispensing
        atm.dispenseCash();

        // Eject Card
        atm.ejectCard();
    }
}
