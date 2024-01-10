import java.util.*;

import Bank.Bank;
import Bank.BankHandler;
import Bank.Account.Account;
import Bank.Transaction.Transaction;
import Bank.Transaction.TransactionType;
import FileIO.Load;
import FileIO.Save;

public class Test {
    public static void main(String[] args) throws Exception {

        Bank bank = new Bank();

        bank.addAccount("ux1", "ux1");
        bank.addAccount("ux2", "ux2");
        bank.addAccount("ux3", "ux3");
        bank.addAccount("ux4", "ux4");
        bank.addAccount("ux5", "ux5");

        System.out.println(bank.toJSON());

        Save.saveAsJSON(bank.toJSON());
        BankHandler.bank = Load.loadAsJSON();

        /*old
        Bank moneyDance = new Bank();

        // moneyDance.addAccount("John Doe", "money123");

        System.out.println("REGISTERING ACCOUNT");
        System.out.println("Enter your name: ");
        Scanner input1 = new Scanner(System.in);
        String name = input1.nextLine();

        System.out.println("Enter your password: ");
        Scanner input2 = new Scanner(System.in);
        String password = input2.nextLine();

        moneyDance.addAccount(name, password);

        System.out.println("LOGGING IN");
        System.out.println("Enter your card number: ");
        Scanner input3 = new Scanner(System.in);
        String cardNumberInput = input3.nextLine();

        System.out.println("Enter your password: ");
        Scanner input4 = new Scanner(System.in);
        String passwordInput = input4.nextLine();

        Account account = moneyDance.getAccount(Integer.parseInt(cardNumberInput));

        if (account != null) {
            if (moneyDance.validateAccount(account.getCardNumber(), passwordInput)) {
                System.out.println("Login successful! Welcome, " + account.getName());

                System.out.println("Would you like to WITHDRAW, or make a DEPOSIT?");
                Scanner input5 = new Scanner(System.in);
                String transactionInput = input5.nextLine();

                System.out.println("Enter the amount:");
                Scanner input6 = new Scanner(System.in);
                float amount = input6.nextFloat();

                Transaction transaction = new Transaction(account.getName(), account.getCardNumber(),
                        account.getPassword(), account.getBalance());

                if (transactionInput.equalsIgnoreCase("withdraw")) {
                    transaction.selectTransactionType(TransactionType.WITHDRAW, amount);
                } else if (transactionInput.equalsIgnoreCase("deposit")) {
                    transaction.selectTransactionType(TransactionType.DEPOSIT, amount);
                } else {
                    System.out.println("Invalid transaction type!");
                }

                System.out.println("Your new balance is: " + transaction.getBalance());

                input5.close();
                input6.close();

            } else {
                System.out.println("Wrong password!");
            }
        } else {
            System.out.println("Account does not exist!");
        }

        // System.out.println("Would you like to WITHDRAW, or make a DEPOSIT?");
        // Scanner input5 = new Scanner(System.in);
        // String transactionInput = input5.nextLine();
        input1.close();
        input2.close();
        input3.close();
        input4.close();
*/
    }
}
