#include "../states/ReadCashWithdrawalDetailsState.h"
#include "../states/DispensingCashState.h"
#include "../models/ATM.h"
#include "../states/EjectingCardState.h"

#include <stdexcept>

ReadCashWithdrawalDetailsState::ReadCashWithdrawalDetailsState(ATM* atm) : atm(atm) {}

bool ReadCashWithdrawalDetailsState::cancelTransaction() {
    try {
        atm->changeState(new EjectingCardState(atm));
        return true;
    } catch (const std::exception& e) {
        throw std::logic_error("Cannot Cancel Transaction");
    }
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
