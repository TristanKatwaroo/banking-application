import Viewer.View;
import Viewer.ViewSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FXMLWelcomeController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    void onLogin(ActionEvent event) {
        ViewSwitcher.switchTo(View.LOGIN);
    }

    @FXML
    void onRegister(ActionEvent event) {
        ViewSwitcher.switchTo(View.REGISTER);
    }
}