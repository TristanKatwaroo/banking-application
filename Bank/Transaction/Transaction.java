package Bank.Transaction;

import Bank.Account.Account;

public class Transaction extends Account {

    public Transaction(String name, int cardNumber, String password, float balance) {
        super(name, cardNumber, password, balance);
    }

    public Transaction() {
    }

    @Override
    public void deposit(float amount) {
        deposit(amount);
    }

    @Override
    public void withdraw(float amount) {
        withdraw(amount);
    }

    public void selectTransactionType(TransactionType selectedTransactionType, float amount) {
        if (selectedTransactionType == TransactionType.DEPOSIT) {
            deposit(amount);
        } else if (selectedTransactionType == TransactionType.WITHDRAW) {
            withdraw(amount);
        }
    }

    @Override
    public String toString() {
        return "Transaction []";
    }

}