import java.net.URL;
import java.util.ResourceBundle;

import Bank.BankHandler;
import FileIO.Save;
import Viewer.View;
import Viewer.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLTransactionController implements Initializable {

    @FXML
    private Button btnDeposit;

    @FXML
    private Button btnWithdraw;

    @FXML
    private Label lblWelcome;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Bank bank = BankHandler.getBank();
        // lblWelcome.setText("Welcome, " + bank.getAccount(2147483647).getName());
        lblWelcome.setText("Welcome, " + BankHandler.getSessionAccount().getName());
    }

    @FXML
    void onDeposit(ActionEvent event) {
        Save.saveAsJSON(BankHandler.bank.toJSON());
        ViewSwitcher.switchTo(View.DEPOSIT);
    }

    @FXML
    void onWithdraw(ActionEvent event) {
        Save.saveAsJSON(BankHandler.bank.toJSON());
        ViewSwitcher.switchTo(View.WITHDRAW);
    }

    @FXML
    void onSignOut(ActionEvent event) {
        ViewSwitcher.switchTo(View.WELCOME);
        BankHandler.setSessionAccount(null);
    }
}
