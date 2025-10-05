#include "../models/Card.h"

class CardManagerService{
    public:
    virtual ~CardManagerService() = default; // virtual destructor for proper cleanup
    virtual bool validateCard(Card card,std::string pin)=0;
    virtual bool validateWithdrawal(int transactionId,double amount)=0;
    virtual bool doTransaction(Card card,double amount,int transactionId)=0;
};