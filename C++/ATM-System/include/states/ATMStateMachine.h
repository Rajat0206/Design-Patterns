#include "../enums/ATMState.h" 

class ATMStateMachine {
public:
    virtual ~ATMStateMachine() = default;

    virtual int initTransaction() = 0;                 // pure virtual
    virtual bool readCardDetailsAndPin() = 0;
    virtual bool cancelTransaction() = 0;
    virtual void ejectCard() = 0;
    virtual int dispenseCash() = 0;
    virtual ATMState getState() = 0;
};