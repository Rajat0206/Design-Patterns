#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"
#include <stdexcept>

class ATM;  // forward declaration

class ReadCardAndPinDetailsState : public ATMStateMachine {
    ATM* atm;   // pointer to ATM
public:
    ReadCardAndPinDetailsState(ATM* atm) : atm(atm) {}
    bool readCardDetailsAndPin() override;
    bool cancelTransaction() override;
    ATMState getState() override;
};


