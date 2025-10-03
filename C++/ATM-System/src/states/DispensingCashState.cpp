#include "../states/DispensingCashState.h"
#include "../models/ATM.h"
#include "../states/EjectingCardState.h"
#include <iostream>
#include <stdexcept>

DispensingCashState::DispensingCashState(ATM* atm) : atm(atm) {}

int DispensingCashState::initTransaction() {
    throw std::logic_error("Cannot Init Transaction");
}

bool DispensingCashState::readCardDetailsAndPin() {
    throw std::logic_error("Cannot Read Card");
}

bool DispensingCashState::cancelTransaction() {
    throw std::logic_error("Cannot Cancel Transaction");
}

void DispensingCashState::ejectCard() {
    throw std::logic_error("Cannot Eject Card");
}

int DispensingCashState::dispenseCash() {
    bool isTxnSuccessful = true;  // stubbed backend call

    if (isTxnSuccessful) {
        std::cout << "Transaction Successful" << std::endl;
    } else {
        std::cout << "Something went wrong" << std::endl;
    }

    atm->changeState(new EjectingCardState(atm));
    return 0;
}

bool DispensingCashState::readCashWithdrawDetails() {
    throw std::logic_error("Cannot Read Cash Withdraw Details");
}

ATMState DispensingCashState::getState() {
    return ATMState::DISPENSING_CASH;
}
