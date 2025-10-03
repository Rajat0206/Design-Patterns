#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"
#include <stdexcept>

class ATM;  // forward declaration

class EjectingCardState : public ATMStateMachine {
    ATM* atm;   // pointer to the actual ATM
public:
    explicit EjectingCardState(ATM* atm);

    int initTransaction() override;
    bool readCardDetailsAndPin() override;
    bool cancelTransaction() override;
    void ejectCard() override;
    int dispenseCash() override;
    bool readCashWithdrawDetails() override;
    ATMState getState() override;
};


// #include "../models/ATM.h"
// #include "../enums/ATMState.h"

// class EjectingCardState: public ATMStateMachine {
//     const ATM atm;
//     public:
//     EjectingCardState(ATM atm):atm(atm){}
//     int initTransaction() override {
//         throw logic_error("Cannot Init Transaction");
//     }

//     bool readCardDetailsAndPin() override {
//         throw logic_error("Cannot Read Card");
//     }

//     bool cancelTransaction() override {
//        throw logic_error("Cannot Cancel Transaction");
//     }

//     void ejectCard() override {
//         cout<<"Ejected Card Successfully";
//         this->atm.changeState(new ReadyForTransactionState(this->atm));
//     }

//     int dispenseCash() override {
//         throw logic_error("Cannot Dispense Cash");
//     }

//     bool readCashWithdrawDetails() override {
//         throw logic_error("Cannot Read Cash Withdraw Details");
//     }

//     ATMState getState() override {
//         return ATMState::EJECTING_CARD;
//     }
// };