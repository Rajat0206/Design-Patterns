#pragma once
#include "../enums/ATMState.h" 
#include "../models/Card.h"
#include <stdexcept>

class ATMStateMachine {
public:
    virtual ~ATMStateMachine() = default;
    virtual int initTransaction(){
        throw std::logic_error("Cannot Init Transaction");
    } 

    virtual bool readCardDetailsAndPin(Card card,std::string pin){
        throw std::logic_error("Cannot Read Card Details");
    }

    virtual bool cancelTransaction(int transactionId){
        throw std::logic_error("Cannot Cancel Transaction");
    }

    virtual void ejectCard(){
        throw std::logic_error("Cannot Eject Card");
    }
    //this is for atm right so we need to use method from carddispenseservice
    virtual int dispenseCash(Card card, double amount, int transactionId){
        throw std::logic_error("Cannot Dispense Cash");
    }

    virtual bool readCashWithdrawDetails(Card card, double amount, int transactionId){
        throw std::logic_error("Cannot Read Cash Withdraw Details");
    }

    virtual ATMState getState() = 0; // pure virtual
};