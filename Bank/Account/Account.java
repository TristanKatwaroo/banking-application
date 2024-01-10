package Bank.Account;

import java.util.Random;

public class Account {
    private String name;
    private int cardNumber;
    private String password;
    private float balance;

    public Account() {
    }

    public Account(String name, int cardNumber, String password, float balance) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.password = password;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getCardNumberAsString() {
        String cardNum = Integer.toString(cardNumber);
        String formattedCardNum = String.format("%s-%s-%s",
                cardNum.substring(0, 3),
                cardNum.substring(3, 6),
                cardNum.substring(6));

        return formattedCardNum;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void registerAccount(String name, String password) {
        setName(name);
        Random rand = new Random();
        setCardNumber(rand.nextInt(900_000) + 451_000_000);
        setBalance(0);
        setPassword(password);

        // return cardNumber;
    }

    public boolean login(int cardNumber, String password) {
        if (this.cardNumber == cardNumber && getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public void deposit(float amount){
        setBalance(getBalance() + amount);
    }

    public void withdraw(float amount){
        setBalance(getBalance() - amount);
    }

    // public void registerAccount(String name, String password) {}

    @Override
    public String toString() {
        return "Account [name=" + name + ", CardNumber=" + cardNumber + ", password=" + password + ", balance="
                + balance + "]";
    }

}