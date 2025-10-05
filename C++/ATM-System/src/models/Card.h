#include "../enums/CardType.h"
#include <string>

class Card {
    const long cardNumber;
    const std::string name;
    const std::string pin;
    const std::string bankName;
    const CardType type;

public:
    Card(long cardNumber, const std::string& name, const std::string& pin,
         const std::string& bankName, CardType type)
        : cardNumber(cardNumber), name(name), pin(pin), bankName(bankName), type(type) {}

    long getCardNumber() const { 
        return cardNumber; 
    }

    const std::string& getName() const { 
        return name; 
    }

    const std::string& getPin() const { 
        return pin; 
    }

    const std::string& getBankName() const { 
        return bankName; 
    }
    

    CardType getCardType() const { 
        return type; 
    }
};
