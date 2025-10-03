#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"
#include <stdexcept>

class ATM;  // forward declaration

class ReadCardAndPinDetailsState : public ATMStateMachine {
    ATM* atm;   // pointer to ATM
public:
    explicit ReadCardAndPinDetailsState(ATM* atm);

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

// class ReadCardAndPinDetailsState:public ATMStateMachine{
//     public:
//     ReadCardAndPinDetailsState(ATM atm) {
//         this->atm = atm;
//     }
//     int initTransaction() override {
//         throw logic_error("Cannot Init Transaction");
//     }

//     bool readCardDetailsAndPin() override {
//         // logic to check pin and card validation
//         boolean isCardValid = true;

//         if(isCardValid) {
//             this->atm.changeState(new ReadCashWithdrawalDetailsState(this->atm));
//         } else {
//             this->atm.changeState(new EjectingCardState(this->atm));
//         }
//     }

//     bool cancelTransaction() override {
//        try {
//             this->atm.changeState(new EjectingCardState(this->atm));
//             return true;
//         } catch (Exception e) {
//             throw logic_error("Cannot Eject Card");
//         }
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
//         return ATMState::READ_CARD_DETAILS_AND_PIN;
//     }
// };