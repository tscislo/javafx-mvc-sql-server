package mvc.employee.controller;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Stage primaryStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void closeMainWindow() {
        this.primaryStage.close();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
