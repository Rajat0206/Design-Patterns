#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"
#include <stdexcept>

class ATM;  // forward declaration

class ReadCardAndPinDetailsState : public ATMStateMachine {
    ATM* atm;   // pointer to ATM
public:
    ReadCardAndPinDetailsState(ATM* atm) : atm(atm) {}
    bool readCardDetailsAndPin(Card card,std::string pin) override;
    bool cancelTransaction(int transactioId) override;
    ATMState getState() override;
};


