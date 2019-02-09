package mvc.employee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mvc.employee.model.dal.OraConn;

public class Main extends Application {
    public static OraConn OraConnInstance;

    private int width = 1000;
    private int height = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./view/Main.fxml" ));
        AnchorPane pane = fxmlLoader.load(); // To oznacza, że będziemy podpinać kontoler do AnchorPane
        primaryStage.setTitle("Employees" );
        Scene scene = new Scene(pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(width);
        primaryStage.setMinHeight(height);
        primaryStage.setMaxWidth(width);
        primaryStage.setMaxHeight(height);
//        MainController mainWindowController = fxmlLoader.getController();
//        mainWindowController.setStage(primaryStage);
        primaryStage.show();

        OraConnInstance = new OraConn("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf", "TEMP0", "temp01" );
        try {
            OraConnInstance.open();
        } catch (Exception ex) {
            Alert.showError(ex.getMessage());
        }
        System.out.print("OK" );

    }


    public static void main(String[] args) {
        launch(args);
    }

}