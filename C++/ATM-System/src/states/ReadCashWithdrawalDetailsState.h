#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"
#include <stdexcept>

class ATM;  // forward declaration

class ReadCashWithdrawalDetailsState : public ATMStateMachine {
    ATM* atm;  // pointer to ATM
public:
    explicit ReadCashWithdrawalDetailsState(ATM* atm);

    bool cancelTransaction(int transactionId) override;
    bool readCashWithdrawDetails(Card card, double amount, int transactionId) override;
    ATMState getState() override;
};


