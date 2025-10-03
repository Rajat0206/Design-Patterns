#include <iostream>
#include "models/ATM.h"   // adjust include path based on your folder structure

int main() {
    ATM atm("2424");   // construct ATM object directly

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

    return 0;
}
// g++ src/main.cpp src/models/ATM.cpp src/states/ReadyForTransactionState.cpp src/states/ReadCardAndPinDetailsState.cpp src/states/ReadCashWithdrawalDetailsState.cpp src/states/EjectingCardState.cpp src/states/DispensingCashState.cpp -o atm_program
