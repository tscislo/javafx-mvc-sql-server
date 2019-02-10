package mvc.employee.model;

import javafx.beans.property.*;

import java.time.LocalDate;


public class Employee {


    private IntegerProperty employeeId;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty email;
    private StringProperty phoneNumber;
    private IntegerProperty departmentId;
    private ObjectProperty<LocalDate> hireDate;

    public boolean isValid = false;
    private Department department;


    public Employee() {
        this.employeeId = new SimpleIntegerProperty();
        this.departmentId = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.phoneNumber = new SimpleStringProperty();
        hireDate = new SimpleObjectProperty<LocalDate>(LocalDate.now());
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
        this.isValid = true;
        this.employeeId.set(employeeId);
    }


    public Integer getDepartmentId() {
        return departmentId.get();
    }

    public IntegerProperty departmentIdProperty() {
        return departmentId;
    }

    public void setDepartmentId(Integer employeeId) {
        this.departmentId.set(employeeId);
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


    public LocalDate getHireDate() {
        return hireDate.get();
    }

    public ObjectProperty<LocalDate> hireDateProperty() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate.setValue(hireDate);
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
        cloned.setHireDate(this.getHireDate());

        return cloned;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
