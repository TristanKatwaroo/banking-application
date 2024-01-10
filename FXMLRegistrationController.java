import Bank.BankHandler;
import Bank.Account.PasswordValidator;
import Viewer.View;
import Viewer.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FXMLRegistrationController {

    @FXML
    private Button btnRegister;

    @FXML
    private TextField txtFieldName;

    @FXML
    private TextField txtFieldPassword;

    @FXML
    void onRegister(ActionEvent event) {
        if (PasswordValidator.validatePassword(txtFieldPassword.getText())) {

            BankHandler.getBank().addAccount(txtFieldName.getText(), txtFieldPassword.getText());
            ViewSwitcher.switchTo(View.WELCOME);
    
            TextField textField = new TextField(BankHandler.getSessionAccount().getCardNumberAsString());
            textField.setEditable(false);
            GridPane gridPane = new GridPane();
            gridPane.add(textField, 0, 0);
    
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Account created successfully!\nPlease copy your card number as it will be used to sign in.");
            alert.getDialogPane().setContent(gridPane);
            alert.showAndWait();
        } else {
            System.out.println("Weak password!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            //alert.setHeaderText("Password must be longer than 6 characters and contain at\nleast 1 uppercase, lowercase, and digit.");
            alert.setHeaderText("Password must be longer than 6 characters and contain at least:\n- 1 uppercase character\n- 1 lowercase character\n- 1 digit");
            alert.showAndWait();
        }

    }

    @FXML
    void onBack(ActionEvent event) {
        ViewSwitcher.switchTo(View.WELCOME);
    }
}
