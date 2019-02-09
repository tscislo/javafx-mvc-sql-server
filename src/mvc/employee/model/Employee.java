package mvc.employee.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Employee {


    private IntegerProperty employeeId;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty email;
    private StringProperty phoneNumber;


    public Employee() {
        this.employeeId = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.phoneNumber = new SimpleStringProperty();
    }

    public Employee(int employeeId) {
        this();
        this.employeeId.set(employeeId);
    }

    public Integer getEmployeeId() {
        return employeeId.get();
    }

    public IntegerProperty employeeIdProperty() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId.set(employeeId);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.setValue(firstName);
    }


    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.setValue(lastName);
    }


    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.setValue(email);
    }


    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.setValue(phoneNumber);
    }


    public String toString() {
        return this.getEmployeeId() + " " + this.getFirstName() + " " + this.getLastName();
    }

    public Employee clone() {
       Employee cloned = new Employee();

        cloned.setFirstName(this.getFirstName());
        cloned.setLastName(this.getLastName());
        cloned.setEmployeeId(this.getEmployeeId());
        cloned.setPhoneNumber(this.getPhoneNumber());
        cloned.setEmail(this.getEmail());

        return cloned;
    }
}
