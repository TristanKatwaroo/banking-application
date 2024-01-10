package Bank;

import Bank.Account.Account;
import FileIO.Load;

public class BankHandler {

    static public Bank bank = Load.loadAsJSON();
    static Account sessionAccount;

    public static Bank getBank() {
        return bank;
    }

    public static Account getSessionAccount() {
        return sessionAccount;
    }

    public static void setSessionAccount(Account inputSessionAccount) {
        sessionAccount = inputSessionAccount;
    }

}
