package mvc.employee.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import mvc.employee.Alert;
import mvc.employee.model.Employee;
import mvc.employee.model.dal.EmployeesDAL;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    private Stage primaryStage;
    private Employee employee;
    private EmployeesDAL employeesDAL = new EmployeesDAL();

    @FXML
    private DatePicker hireDate;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        this.hireDate.valueProperty().bindBidirectional(this.employee.hireDateProperty());
    }

    public void save() {
        this.employeesDAL.updateEmployeeHireDate(this.employee);
        Alert.showMsg("Zapisano!");
    }
}
