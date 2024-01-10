import java.net.URL;
import java.util.ResourceBundle;

import Bank.BankHandler;
import Bank.Account.Account;
//import Bank.Transaction.Transaction;
//import Bank.Transaction.Transaction;
import Viewer.View;
import Viewer.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

public class FXMLDepositController implements Initializable{

    @FXML
    private Button btnDeposit;

    @FXML
    private TextField txtFieldDeposit;

    @FXML
    private Label lblDeposit;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lblDeposit.setText("Your current balance is $" + BankHandler.getSessionAccount().getBalance() + "\nAmount to deposit:");
    }

    @FXML
    void onDeposit(ActionEvent event) {

        Account account = BankHandler.getSessionAccount();

        if (account != null) {
            account.deposit(Integer.parseInt(txtFieldDeposit.getText()));
            System.out.println("Your new balance is: " + account.getBalance());
            ViewSwitcher.switchTo(View.TRANSACTION);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Deposit successful! Your new balance is:");
            alert.setContentText("$" + Float.toString(account.getBalance()));
            alert.showAndWait();
        } else {
            System.out.println("Account does not exist!");
            ViewSwitcher.switchTo(View.WELCOME);
        }
    }

    @FXML
    void onBack(ActionEvent event) {
        ViewSwitcher.switchTo(View.TRANSACTION);
    }
}
