#include "../states/ReadCardAndPinDetailsState.h"
#include "../models/ATM.h"
#include "../states/ReadyForTransactionState.h"
#include <iostream>
#include <stdexcept>
using namespace std;

int ReadyForTransactionState::initTransaction() {
    int transactionId = 1234;  // fake backend call
    atm->changeState(new ReadCardAndPinDetailsState(atm));
    return transactionId;
}

bool ReadyForTransactionState::readCardDetailsAndPin() {
    throw logic_error("Cannot Read Card");
}

bool ReadyForTransactionState::cancelTransaction() {
    throw logic_error("Cannot Cancel Transaction");
}

void ReadyForTransactionState::ejectCard() {
    throw logic_error("Cannot Eject Card");
}

int ReadyForTransactionState::dispenseCash() {
    throw logic_error("Cannot Dispense Cash");
}

bool ReadyForTransactionState::readCashWithdrawDetails() {
    throw logic_error("Cannot Read Cash Withdraw Details");
}

ATMState ReadyForTransactionState::getState() {
    return ATMState::READY_FOR_TRANSACTION;
}
