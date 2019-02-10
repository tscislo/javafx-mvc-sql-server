package mvc.employee.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Department {
    private IntegerProperty departmentId;
    private StringProperty departmentName;


    public Department() {
        this.departmentId = new SimpleIntegerProperty();
        this.departmentName = new SimpleStringProperty();
        this.setDepartmentName("N/A");
    }

    public Integer getDepartmentId() {
        return departmentId.get();
    }

    public IntegerProperty departmentIdProperty() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId.setValue(departmentId);
    }


    public String getDepartmentName() {
        return departmentName.get();
    }

    public StringProperty departmentNameProperty() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName.setValue(departmentName);
    }

    public String toString() {
        return this.getDepartmentId() + this.getDepartmentName();
    }

}
