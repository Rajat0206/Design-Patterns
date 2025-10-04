#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"

class ATM;

class ReadyForTransactionState : public ATMStateMachine {
    ATM* atm;  // hold pointer to actual ATM
public:
    ReadyForTransactionState(ATM* atm) : atm(atm) {}
    int initTransaction() override;
    ATMState getState() override;

};



