package org.ceo;

import org.ceo.enums.CardType;
import org.ceo.models.ATM;
import org.ceo.models.VisaDebitCard;

public class Main {
    static void main() {
        try {
            ATM atm = new ATM("2424");
            VisaDebitCard card = VisaDebitCard.builder()
                    .cardNumber(1234123412341234L)
                    .pin("1234")
                    .name("Rajat")
                    .cardType(CardType.DEBIT)
                    .bankName("Bank of Tomorrow")
                    .build();

            // Ready State
            atm.initTransaction();

            // Card Reading
            atm.readCardDetailsAndPin(card, "1234");

            // Withdraw Details Reading
            atm.readCashWithdrawDetails(card, 54.0, 23433);

            // Cash Dispensing
            atm.dispenseCash(card, 54.0, 23433);

            // Eject Card
            atm.ejectCard();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
