#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"
#include <stdexcept>

class ATM;  // forward declaration

class ReadCashWithdrawalDetailsState : public ATMStateMachine {
    ATM* atm;  // pointer to ATM
public:
    explicit ReadCashWithdrawalDetailsState(ATM* atm);

    bool cancelTransaction() override;
    bool readCashWithdrawDetails() override;
    ATMState getState() override;
};


