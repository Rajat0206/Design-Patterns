#include "../states/DispensingCashState.h"
#include "../models/ATM.h"
#include "../states/EjectingCardState.h"
#include <iostream>
#include <stdexcept>

DispensingCashState::DispensingCashState(ATM* atm) : atm(atm) {}


int DispensingCashState::dispenseCash(Card card, double amount, int transactionId) {
    bool isTxnSuccessful = true;  // stubbed backend call

    if (isTxnSuccessful) {
        std::cout << "Transaction Successful" << std::endl;
    } else {
        std::cout << "Something went wrong" << std::endl;
    }

    atm->changeState(new EjectingCardState(atm));
    return 0;
}

ATMState DispensingCashState::getState() {
    return ATMState::DISPENSING_CASH;
}
