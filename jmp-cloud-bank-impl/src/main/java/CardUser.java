import java.util.Random;

public class CardUser implements Bank {

    @Override
    public  BankCard createBankCard(User user, BankCardType bankCardType) {

        Random random = new Random();
        String restDigits = " " + String.valueOf(random.nextInt(9999))
                + " " + String.valueOf(random.nextInt(9999))
                + " " + String.valueOf(random.nextInt(9999));

        if (bankCardType.equals(BankCardType.CREDIT)) {
            return new CreditBankCard(bankCardType.firstFourDigits + restDigits, user);
        } else return new DebitBankCard(bankCardType.firstFourDigits + restDigits, user);
    }
}
