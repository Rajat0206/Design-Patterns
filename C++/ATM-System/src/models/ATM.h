#pragma once
#include <iostream>
#include <string>
#include <exception>
using namespace std;

// Forward declaration (to avoid include loop)
class ATMStateMachine;
// ATM has a states so we have has an relation and we keep instance of every state here if we are not making ATMStateMacchine.
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



