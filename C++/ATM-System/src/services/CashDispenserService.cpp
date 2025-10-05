#include "../models/ATM.h"

class CashDispenserService {
    public:
    //from atm amount will deduct
     virtual void dispenseCash(ATM atm, int transactionId, double amount)=0;
};