#include "../services/CardManagerService.h"

class DebitCardManagerService:public CardManagerService{
    public:
    bool validateCard(Card card,std::string pin) override{
        return false;
    }
    bool validateWithdrawal(int transactionId,double amount) override{
        return false;
    }
    bool doTransaction(Card card,double amount,int transactionId) override{
        return false;
    }
};