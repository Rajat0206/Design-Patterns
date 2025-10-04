#include "../states/ReadCardAndPinDetailsState.h"
#include "../models/ATM.h"
#include "../states/ReadCashWithdrawalDetailsState.h"
#include "../states/EjectingCardState.h"


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


ATMState ReadCardAndPinDetailsState::getState() {
    return ATMState::READ_CARD_DETAILS_AND_PIN;
}
