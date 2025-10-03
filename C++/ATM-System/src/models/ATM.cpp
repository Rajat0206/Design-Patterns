#include "ATM.h"
#include "../states/ReadyForTransactionState.h"
#include "../states/ATMStateMachine.h"
#include <stdexcept>

ATM::ATM(std::string atmId) : atmId(atmId) {
    this->atmStateMachine = new ReadyForTransactionState(this);
}

int ATM::initTransaction() {
    return atmStateMachine->initTransaction();
}

bool ATM::readCardDetailsAndPin() {
    return atmStateMachine->readCardDetailsAndPin();
}

bool ATM::readCashWithdrawDetails() {
    return atmStateMachine->readCashWithdrawDetails();
}

bool ATM::cancelTransaction() {
    return atmStateMachine->cancelTransaction();
}

void ATM::ejectCard() {
    atmStateMachine->ejectCard();
}

int ATM::dispenseCash() {
    return atmStateMachine->dispenseCash();
}

void ATM::changeState(ATMStateMachine* newState) {
    this->atmStateMachine = newState;
}
