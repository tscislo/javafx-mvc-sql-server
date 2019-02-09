package mvc.employee;

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
}
