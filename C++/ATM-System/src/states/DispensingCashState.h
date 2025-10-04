#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"
#include <stdexcept>

class ATM;  // forward declaration

class DispensingCashState : public ATMStateMachine {
    ATM* atm;  // pointer to ATM
public:
    explicit DispensingCashState(ATM* atm);

    int dispenseCash() override;
    ATMState getState() override;
};



