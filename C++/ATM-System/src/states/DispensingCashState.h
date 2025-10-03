#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"
#include <stdexcept>

class ATM;  // forward declaration

class DispensingCashState : public ATMStateMachine {
    ATM* atm;  // pointer to ATM
public:
    explicit DispensingCashState(ATM* atm);

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

// class DispensingCashState : public ATMStateMachine{
//     const ATM atm;
//     public:
//     DispensingCashState(ATM atm) {
//         this.atm = atm;
//     }
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
//         throw logic_error("Cannot Eject Card");
//     }

//     int dispenseCash() override {
//         boolean isTxnSuccessful = true;
//         if(isTxnSuccessful) {
//             System.out.println("Trx Successful");
//         } else {
//             System.out.println("Something went Wrong");
//         }

//         this->atm.changeState(new EjectingCardState(this->atm));
//         return 0;
//     }

//     bool readCashWithdrawDetails() override {
//         throw logic_error("Cannot Read Cash Withdraw Details");
//     }

//     ATMState getState() override {
//         return ATMState::DISPENSING_CASH;
//     }
// };