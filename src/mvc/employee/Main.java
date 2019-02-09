package mvc.employee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mvc.employee.controller.MainController;
import mvc.employee.model.dal.OraConn;

public class Main extends Application {
    public static OraConn OraConnInstance;

    private int width = 1000;
    private int height = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.initializeConnection();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./view/Main.fxml" ));
        AnchorPane pane = fxmlLoader.load(); // To oznacza, że będziemy podpinać kontoler do AnchorPane
        primaryStage.setTitle("Employees" );
        Scene scene = new Scene(pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(width);
        primaryStage.setMinHeight(height);
        primaryStage.setMaxWidth(width);
        primaryStage.setMaxHeight(height);
        MainController mainWindowController = fxmlLoader.getController();
        mainWindowController.setPrimaryStage(primaryStage);
        primaryStage.show();
        primaryStage.setOnHiding(event -> {
            System.out.print("setOnHiding" );
            this.closeConnection();
        });
        primaryStage.setOnCloseRequest(event -> {
            System.out.print("setOnCloseRequest" );
            if (Alert.confirmation("Czy zamknąć?" )) {
                event.consume();
            }
        });
    }

    private void initializeConnection() {
        OraConnInstance = new OraConn("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf", "TEMP01", "temp01" );
        try {
            OraConnInstance.open();
        } catch (Exception ex) {
            Alert.showError(ex.getMessage());
        }
    }

    private void closeConnection() {
        try {
            OraConnInstance.close();
        } catch (Exception ex) {
            Alert.showError(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}