#pragma once
#include "../states/ATMStateMachine.h"
#include "../enums/ATMState.h"
#include <stdexcept>

class ATM;  // forward declaration

class ReadCashWithdrawalDetailsState : public ATMStateMachine {
    ATM* atm;  // pointer to ATM
public:
    explicit ReadCashWithdrawalDetailsState(ATM* atm);

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

// class ReadCashWithdrawalDetailsState:public ATMStateMachine{
//     const ATM atm;
//     public:
//     ReadCashWithdrawalDetailsState(ATM atm) {
//         this.atm = atm;
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
//         // logic to validate

//         boolean isWithdrawValid = true;
//         if(isWithdrawValid) {
//             this->atm.changeState(new DispensingCashState(this->atm));
//         } else {
//             this->atm.changeState(new EjectingCardState(this->atm));
//         }

//         return isWithdrawValid;
//     }

//     ATMState getState() override {
//         return ATMState::READ_CASH_WITHDRAW_DETAILS;
//     }
// };