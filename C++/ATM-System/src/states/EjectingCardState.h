#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"
#include <stdexcept>

class ATM;  // forward declaration

class EjectingCardState : public ATMStateMachine {
    ATM* atm;   // pointer to the actual ATM
public:
    explicit EjectingCardState(ATM* atm);
    void ejectCard() override;
    ATMState getState() override;
};



