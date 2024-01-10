package FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Bank.Bank;
import Bank.Account.Account;

public class Load {
    public static Bank loadAsJSON() {
        try (BufferedReader br = new BufferedReader(new FileReader("bank.json"))) {
            String line;
            Bank bank = new Bank();
            while ((line = br.readLine()) != null) {
                // process the line
                String[] lines = line.split("}");
                for (String string : lines) {
                    // System.out.println("\nline " + string + "\n");
                    String name = "";
                    String CardNumber = "";
                    int CardNumberint = 0;
                    String password = "";
                    String balance = "";
                    Float balanceflt = 0.0f;
                    if (string.contains("]") == false) {
                        name = string.substring(string.indexOf("name") + 8,
                                string.indexOf(',', string.indexOf("name")) - 1);
                        CardNumber = string.substring(string.indexOf("CardNumber") + 14,
                                string.indexOf(',', string.indexOf("CardNumber")) - 1);
                        password = string.substring(string.indexOf("password") + 12,
                                string.indexOf(',', string.indexOf("password")) - 1);
                        balance = string.substring(string.indexOf("balance") + 11, string.indexOf('.') + 2);

                        CardNumberint = Integer.parseInt(CardNumber);
                        balanceflt = Float.parseFloat(balance);

                        bank.addAccount(new Account(name, CardNumberint, password, balanceflt));
                    }
                }
            }
            return bank;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}