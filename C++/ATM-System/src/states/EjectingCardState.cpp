#include "../states/EjectingCardState.h"
#include "../models/ATM.h"
#include "../states/ReadyForTransactionState.h"
#include <iostream>
#include <stdexcept>

EjectingCardState::EjectingCardState(ATM* atm) : atm(atm) {}

int EjectingCardState::initTransaction() {
    throw std::logic_error("Cannot Init Transaction");
}

bool EjectingCardState::readCardDetailsAndPin() {
    throw std::logic_error("Cannot Read Card");
}

bool EjectingCardState::cancelTransaction() {
    throw std::logic_error("Cannot Cancel Transaction");
}

void EjectingCardState::ejectCard() {
    std::cout << "Ejected Card Successfully" << std::endl;
    atm->changeState(new ReadyForTransactionState(atm));
}

int EjectingCardState::dispenseCash() {
    throw std::logic_error("Cannot Dispense Cash");
}

bool EjectingCardState::readCashWithdrawDetails() {
    throw std::logic_error("Cannot Read Cash Withdraw Details");
}

ATMState EjectingCardState::getState() {
    return ATMState::EJECTING_CARD;
}
