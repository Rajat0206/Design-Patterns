#include "../states/EjectingCardState.h"
#include "../models/ATM.h"
#include "../states/ReadyForTransactionState.h"
#include <iostream>
#include <stdexcept>

EjectingCardState::EjectingCardState(ATM* atm) : atm(atm) {}



void EjectingCardState::ejectCard() {
    std::cout << "Ejected Card Successfully" << std::endl;
    atm->changeState(new ReadyForTransactionState(atm));
}


ATMState EjectingCardState::getState() {
    return ATMState::EJECTING_CARD;
}
