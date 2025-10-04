#include "../states/ReadyForTransactionState.h"
#include "../states/ReadCardAndPinDetailsState.h"
#include "../models/ATM.h"
#include <iostream>
#include <stdexcept>

int ReadyForTransactionState::initTransaction() {
    int transactionId = 1234;  // fake backend call
    atm->changeState(new ReadCardAndPinDetailsState(atm));
    return transactionId;
}

ATMState ReadyForTransactionState::getState() {
    return ATMState::READY_FOR_TRANSACTION;
}
