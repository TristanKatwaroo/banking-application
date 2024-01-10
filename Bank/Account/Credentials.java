package Bank.Account;

public class Credentials extends Account {

    public Credentials(String name, int cardNumber, String password, float balance) {
        super(name, cardNumber, password, balance);
    }

    public void registerAccount(String name, String password) {
        super.registerAccount(name, password);
    }

    public boolean login(int cardNumber, String password) {
        return super.login(cardNumber, password);
    }

    @Override
    public String toString() {
        return "Credentials []";
    }

}