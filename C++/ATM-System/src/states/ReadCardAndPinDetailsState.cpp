#include "../states/ReadCardAndPinDetailsState.h"
#include "../models/ATM.h"
#include "../states/ReadCashWithdrawalDetailsState.h"
#include "../states/EjectingCardState.h"

ReadCardAndPinDetailsState::ReadCardAndPinDetailsState(ATM* atm) : atm(atm) {}

int ReadCardAndPinDetailsState::initTransaction() {
    throw std::logic_error("Cannot Init Transaction");
}

bool ReadCardAndPinDetailsState::readCardDetailsAndPin() {
    bool isCardValid = true;

    if (isCardValid) {
        atm->changeState(new ReadCashWithdrawalDetailsState(atm));
    } else {
        atm->changeState(new EjectingCardState(atm));
    }
    return isCardValid;
}

bool ReadCardAndPinDetailsState::cancelTransaction() {
    try {
        atm->changeState(new EjectingCardState(atm));
        return true;
    } catch (const std::exception& e) {
        throw std::logic_error("Cannot Cancel Transaction");
    }
}

void ReadCardAndPinDetailsState::ejectCard() {
    throw std::logic_error("Cannot Eject Card");
}

int ReadCardAndPinDetailsState::dispenseCash() {
    throw std::logic_error("Cannot Dispense Cash");
}

bool ReadCardAndPinDetailsState::readCashWithdrawDetails() {
    throw std::logic_error("Cannot Read Cash Withdraw Details");
}

ATMState ReadCardAndPinDetailsState::getState() {
    return ATMState::READ_CARD_DETAILS_AND_PIN;
}
