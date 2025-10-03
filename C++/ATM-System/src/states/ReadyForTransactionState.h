#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"

class ATM;

class ReadyForTransactionState : public ATMStateMachine {
    ATM* atm;  // hold pointer to actual ATM
public:
    ReadyForTransactionState(ATM* atm) : atm(atm) {}

    int initTransaction() override;
    bool readCardDetailsAndPin() override;
    bool cancelTransaction() override;
    void ejectCard() override;
    int dispenseCash() override;
    bool readCashWithdrawDetails() override;
    ATMState getState() override;
};



// #pragma once
// //#include "../models/ATM.h"
// #include "../enums/ATMState.h"


// class ATM;

// class ReadyForTransactionState : public ATMStateMachine{
//     const ATM atm;  
//     public:
//     ReadyForTransactionState(ATM atm):atm(atm) {}

//     int initTransaction() override {
//         //logic to connect to backend and give transaction id

//         int transactionId = 1234;
//         this->atm.changeState(new ReadCardAndPinDetailsState(this->atm));
//         return transactionId;
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
//         throw logic_error("Cannot Dispense Cash");
//     }

//     bool readCashWithdrawDetails() override {
//         throw logic_error("Cannot Read Cash Withdraw Details");
//     }

//     ATMState getState() override {
//         return ATMState::READY_FOR_TRANSACTION;
//     }
// };