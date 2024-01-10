import Viewer.View;
import Viewer.ViewSwitcher;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// AFTER LAUNCHING THE APP, REGISTER FOR A NEW ACCOUNT AND USE THAT TO SIGN IN

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        var scene = new Scene(new Pane());

        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.WELCOME);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
