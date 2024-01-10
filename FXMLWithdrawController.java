import java.net.URL;
import java.util.ResourceBundle;

import Bank.BankHandler;
import Bank.Account.Account;
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

public class FXMLWithdrawController implements Initializable{

    @FXML
    private Button btnWithdraw;

    @FXML
    private TextField txtFieldWithdraw;
    
    @FXML
    private Label lblWithdraw;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lblWithdraw.setText("Your current balance is $" + BankHandler.getSessionAccount().getBalance() + "\nAmount to withdraw:");
    }

    @FXML
    void onWithdraw(ActionEvent event) {
        Account account = BankHandler.getSessionAccount();

        if (account != null) {
            account.withdraw(Integer.parseInt(txtFieldWithdraw.getText()));
            System.out.println("Your new balance is: " + account.getBalance());
            ViewSwitcher.switchTo(View.TRANSACTION);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Withdrawal successful! Your new balance is:");
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

