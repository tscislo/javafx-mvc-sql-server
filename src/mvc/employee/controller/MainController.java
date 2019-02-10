package mvc.employee.controller;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mvc.employee.model.Department;
import mvc.employee.model.Employee;
import mvc.employee.model.dal.EmployeesDAL;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Stage primaryStage;

    @FXML
    private
    TableView<Employee> employeeTable;
    @FXML
    private
    TableColumn<Employee, Integer> employeeIdColumn;
    @FXML
    private
    TableColumn<Employee, String> firstNameColumn;
    @FXML
    private
    TableColumn<Employee, String> lastNameColumn;
    @FXML
    private
    TableColumn<Employee, String> emailColumn;

    @FXML
    private
    TableColumn<Employee, String> phoneNumberColumn;

    @FXML
    private
    TableColumn<Employee, String> departmentTableColumn;

    @FXML
    private Label employeeIdLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label phoneNumberLabel;

    private ObservableList<Employee> employees = FXCollections.observableArrayList();

    private Employee selectedEmployee = new Employee();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeTable.setTableMenuButtonVisible(true);

        employeeIdColumn.setCellValueFactory(cellData ->
                cellData.getValue().employeeIdProperty().asObject());

        firstNameColumn.setCellValueFactory(cellData ->
                cellData.getValue().firstNameProperty());

        lastNameColumn.setCellValueFactory(cellData ->
                cellData.getValue().lastNameProperty());

        emailColumn.setCellValueFactory(cellData ->
                cellData.getValue().emailProperty());

        phoneNumberColumn.setCellValueFactory(cellData ->
                cellData.getValue().phoneNumberProperty());

        departmentTableColumn.setCellValueFactory(cellData ->
                cellData.getValue().getDepartment().departmentNameProperty());

        firstNameLabel.textProperty().bindBidirectional(this.selectedEmployee.firstNameProperty());

        EmployeesDAL employeesDAL = new EmployeesDAL();
        this.employees = employeesDAL.getEmployees();

        employeeTable.setItems(this.employees);


        employeeTable.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            if (employeeTable.getSelectionModel().getSelectedItem() != null) {
                this.selectedEmployee = employeeTable.getSelectionModel().getSelectedItem().clone();
                this.bindSelectedPerson();
            }
        });

    }

    private void bindSelectedPerson() {
        employeeIdLabel.textProperty().bind(Bindings.convert(this.selectedEmployee.employeeIdProperty()));
        firstNameLabel.textProperty().bindBidirectional(this.selectedEmployee.firstNameProperty());
        lastNameLabel.textProperty().bindBidirectional(this.selectedEmployee.lastNameProperty());
        emailLabel.textProperty().bindBidirectional(this.selectedEmployee.emailProperty());
        phoneNumberLabel.textProperty().bindBidirectional(this.selectedEmployee.phoneNumberProperty());
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
