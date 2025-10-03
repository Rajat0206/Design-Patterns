#include "../states/DispensingCashState.h"
#include "../models/ATM.h"
#include "../states/EjectingCardState.h"
#include "../states/ReadCashWithdrawalDetailsState.h"
#include <stdexcept>

ReadCashWithdrawalDetailsState::ReadCashWithdrawalDetailsState(ATM* atm) : atm(atm) {}

int ReadCashWithdrawalDetailsState::initTransaction() {
    throw std::logic_error("Cannot Init Transaction");
}

bool ReadCashWithdrawalDetailsState::readCardDetailsAndPin() {
    // Normally this state should not handle card reading
    throw std::logic_error("Cannot Read Card Details in this state");
}

bool ReadCashWithdrawalDetailsState::cancelTransaction() {
    try {
        atm->changeState(new EjectingCardState(atm));
        return true;
    } catch (const std::exception& e) {
        throw std::logic_error("Cannot Cancel Transaction");
    }
}

void ReadCashWithdrawalDetailsState::ejectCard() {
    throw std::logic_error("Cannot Eject Card");
}

int ReadCashWithdrawalDetailsState::dispenseCash() {
    throw std::logic_error("Cannot Dispense Cash");
}

bool ReadCashWithdrawalDetailsState::readCashWithdrawDetails() {
    bool isWithdrawValid = true;  // stub logic

    if (isWithdrawValid) {
        atm->changeState(new DispensingCashState(atm));
    } else {
        atm->changeState(new EjectingCardState(atm));
    }

    return isWithdrawValid;
}

ATMState ReadCashWithdrawalDetailsState::getState() {
    return ATMState::READ_CASH_WITHDRAW_DETAILS;
}
