package mvc.employee.controller;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mvc.employee.model.Department;
import mvc.employee.model.Employee;
import mvc.employee.model.dal.EmployeesDAL;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Stage primaryStage;
    private EmployeesDAL employeesDAL = new EmployeesDAL();

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
    private
    TableColumn<Employee, LocalDate> hireDateColumn;

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

    @FXML
    private Button editButton;

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

        hireDateColumn.setCellValueFactory(cellData ->
                cellData.getValue().hireDateProperty());

        initializeList();

        employeeTable.getSelectionModel().selectedItemProperty().addListener((observable) -> {
            if (employeeTable.getSelectionModel().getSelectedItem() != null) {
                this.selectedEmployee = employeeTable.getSelectionModel().getSelectedItem().clone();
                this.bindSelectedPerson();
            }
        });

    }

    private void initializeList() {
        this.employees = employeesDAL.getEmployees();

        employeeTable.setItems(this.employees);

        this.bindSelectedPerson();
    }

    private void bindSelectedPerson() {
        employeeIdLabel.textProperty().bind(Bindings.convert(this.selectedEmployee.employeeIdProperty()));
        firstNameLabel.textProperty().bindBidirectional(this.selectedEmployee.firstNameProperty());
        lastNameLabel.textProperty().bindBidirectional(this.selectedEmployee.lastNameProperty());
        emailLabel.textProperty().bindBidirectional(this.selectedEmployee.emailProperty());
        phoneNumberLabel.textProperty().bindBidirectional(this.selectedEmployee.phoneNumberProperty());
        this.editButton.disableProperty().bind(Bindings.createBooleanBinding(
                () -> !this.selectedEmployee.isValid
        ));

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

    public void edit() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Edit.fxml" ));
        try {
            AnchorPane pane = fxmlLoader.load();
            Stage editWindowStage = new Stage();
            editWindowStage.setTitle("Edycja" );
            editWindowStage.initModality(Modality.WINDOW_MODAL);
            editWindowStage.initOwner(primaryStage);
            editWindowStage.setMinHeight(500);
            editWindowStage.setMinWidth(400);
            Scene scene = new Scene(pane);
            editWindowStage.setScene(scene);
            EditController editController = fxmlLoader.getController();
            editController.setEmployee(this.selectedEmployee);
            editWindowStage.setOnCloseRequest(event -> {
                initializeList();
            });
            editWindowStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
