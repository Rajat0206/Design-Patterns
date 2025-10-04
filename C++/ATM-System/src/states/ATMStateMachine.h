#pragma once
#include "../enums/ATMState.h" 
#include <stdexcept>

class ATMStateMachine {
public:
    virtual ~ATMStateMachine() = default;
    virtual int initTransaction(){
        throw std::logic_error("Cannot Init Transaction");
    } 

    virtual bool readCardDetailsAndPin(){
        throw std::logic_error("Cannot Read Card Details");
    }

    virtual bool cancelTransaction(){
        throw std::logic_error("Cannot Cancel Transaction");
    }

    virtual void ejectCard(){
        throw std::logic_error("Cannot Eject Card");
    }

    virtual int dispenseCash(){
        throw std::logic_error("Cannot Dispense Cash");
    }

    virtual bool readCashWithdrawDetails(){
        throw std::logic_error("Cannot Read Cash Withdraw Details");
    }

    virtual ATMState getState() = 0; // pure virtual
};