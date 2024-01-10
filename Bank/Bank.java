package Bank;

import java.util.*;

import Bank.Account.Account;

public class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    public Bank(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public Bank() {
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(String name, String password) {
        Account newAccount = new Account();
        newAccount.registerAccount(name, password);
        accounts.add(newAccount);
        BankHandler.setSessionAccount(newAccount);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount(int cardNumber) {
        Account account = null;
        for (Account element : accounts) {
            if (element.getCardNumber() == cardNumber) {
                account = element;
            }
        }
        return account;
    }

    public boolean validateAccount(int cardNumber, String password) {
        if (this.getAccount(cardNumber) != null) {
            Account account = getAccount(cardNumber);
            return account.login(cardNumber, password);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bank [accounts=" + accounts + "]";
    }

    public String toJSON() {
        String rtn = "[";
        for (int i = 0; i < accounts.size(); i++) {
            rtn += "{";
            rtn += "\"name\": \"" + accounts.get(i).getName() + "\",";
            rtn += "\"CardNumber\": \"" + accounts.get(i).getCardNumber() + "\",";
            rtn += "\"password\": \"" + accounts.get(i).getPassword() + "\",";
            rtn += "\"balance\": \"" + accounts.get(i).getBalance() + "\"";
            if (i != accounts.size() - 1)
                rtn += "},";
            else
                rtn += "}";
        }
        rtn += "]";
        return rtn;
    }
}
