#pragma once
#include <iostream>
#include <string>
#include <exception>
using namespace std;

// Forward declaration (to avoid include loop)
class ATMStateMachine;

class ATM {
    string atmId;
    ATMStateMachine* atmStateMachine;

public:
    ATM(string atmId);

    int initTransaction();
    bool readCardDetailsAndPin();
    bool readCashWithdrawDetails();
    bool cancelTransaction();
    void ejectCard();
    int dispenseCash();

    string getAtmId() const { return atmId; }
    void changeState(ATMStateMachine* newState);
};


// #pragma once

// #include "../states/ATMStateMachine.h"
// #include "../states/ReadyForTransactionState.h"
// //class ATMStateMachine;


// class ATM{
//     const string atmId;   // equivalent to 'private final String atmId'
//     ATMStateMachine* atmStateMachine; //Never instantiate abstract classes directly.Use pointers/references to abstract classes.

//                                       //Always implement a concrete subclass that provides the logic for all pure virtual methods.
//     public:
//     ATM(string atmId):atmId(atmId){
//         //Don’t assign to const members inside the constructor body.
//         this->atmStateMachine = new READY_FOR_TRANSACTION(this);
//     }

//     int initTransaction() {
//         try {
//             return atmStateMachine.initTransaction();
//         } catch (Exception e) {
//             throw e;
//         }
//     }

//     bool readCardDetailsAndPin() {
//         try {
//             return atmStateMachine.readCardDetailsAndPin();
//         } catch (Exception e) {
//             throw e;
//         }
//     }

//     bool readCashWithdrawDetails() {
//         try {
//             return atmStateMachine.readCashWithdrawDetails();
//         } catch (Exception e) {
//             throw e;
//         }
//     }

//     bool cancelTransaction() {
//         try {
//             return atmStateMachine.cancelTransaction();
//         } catch (Exception e) {
//             throw e;
//         }
//     }

//     void ejectCard() {
//         try {
//             atmStateMachine.ejectCard();
//         } catch (Exception e) {
//             throw e;
//         }
//     }

//     int dispenseCash() {
//         try {
//             return atmStateMachine.dispenseCash();
//         } catch (Exception e) {
//             throw e;
//         }
//     }

//     string getAtmId() {
//         return atmId;
//     }

//     void changeState(ATMStateMachine newState) {
//         this->atmStateMachine = newState;
//     }
// };