
import java.io.IOException;

import Bank.Bank;
import Bank.BankHandler;
import Bank.Account.Account;
import Viewer.View;
import Viewer.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLLoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtFieldCardNumber;

    @FXML
    private TextField txtFieldPassword;

    @FXML
    void onLogin(ActionEvent event) throws IOException {

        Bank bank = BankHandler.getBank();

        Account account = bank.getAccount(Integer.parseInt(txtFieldCardNumber.getText().replaceAll("[\\s\\-()]", "")));

        if (account != null) {
            if (bank.validateAccount(account.getCardNumber(), txtFieldPassword.getText()) == true) {
                System.out.println("Login successful! Welcome, " + account.getName());
                BankHandler.setSessionAccount(account);
                ViewSwitcher.switchTo(View.TRANSACTION);

                
                // FXMLLoader loader = new FXMLLoader();
                // loader.setLocation(getClass().getResource("FXMLDeposit.fxml"));
                // Parent root = (Parent)loader.load();
                // FXMLDepositController depositController = loader.getController();
                // depositController.setAccount(account);
            } else {
                System.out.println("Wrong password!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Incorrect password, please try again.");
                alert.showAndWait();
                //ViewSwitcher.switchTo(View.WELCOME);
            }
        } else {
            System.out.println("Account does not exist!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Account not found, please try again.");
            alert.showAndWait();
            //ViewSwitcher.switchTo(View.WELCOME);
        }
    }

    @FXML
    void onBack(ActionEvent event) {
        ViewSwitcher.switchTo(View.WELCOME);
    }
}
