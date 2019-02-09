package mvc.employee;

import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Alert {
    public static void showError(String msg) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING, msg);
        alert.setTitle("Uwaga!" );
        alert.setHeaderText("Błąd!" );
        alert.showAndWait();
    }

    public static void showMsg(String msg) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, msg);
        alert.setTitle("Informacja" );
        alert.setHeaderText("Sukces!" );
        alert.showAndWait();
    }

    public static boolean confirmation(String msg) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION, msg);
        alert.setTitle("Potwierdzenie" );
        Optional<ButtonType> result = alert.showAndWait();
        return (result.orElse(ButtonType.CANCEL) != ButtonType.OK);
    }

}
