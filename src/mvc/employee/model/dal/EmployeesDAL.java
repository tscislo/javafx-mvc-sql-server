package mvc.employee.model.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mvc.employee.Main;
import mvc.employee.model.Employee;

public class EmployeesDAL {

    private SQLException ex;

    public SQLException getSQLException() {
        return ex;
    }

    public EmployeesDAL() {
    }

    public ObservableList<Employee> getEmployees() {

        ObservableList<Employee> employees = FXCollections.observableArrayList();
        try (Statement statement = Main.OraConnInstance.getConnection().createStatement();) {

            String query = "SELECT * FROM EMPLOYEES";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                employees.add(rs2Employee(resultSet));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return employees;
    }

    public ObservableList<Employee> getEmployeesByEmployeeId(int EmployeeId) {

        ObservableList<Employee> employees = FXCollections.observableArrayList();
        try (Statement statement = Main.OraConnInstance.getConnection().createStatement();) {

            String query = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID =" + EmployeeId;
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                employees.add(rs2Employee(resultSet));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return employees;
    }

    public int deleteByEmployeeId(int EmployeeId) {

        try (Statement statement = Main.OraConnInstance.getConnection().createStatement();) {

            String query = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID =" + EmployeeId;
            int affectedRows = statement.executeUpdate(query);
            return affectedRows;
        } catch (SQLException ex) {
            this.ex = ex;
            return 0;
        }
    }

//    public int updateEmployee(Employee emp) {
//        try (Statement statement = Main.OraConnInstance.getConnection().createStatement();) {
//
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd" );
//            String hireDate = dtf.format(emp.getHireDate());
//
//            String query = "UPDATE EMPLOYEES SET "
//                    + "LAST_NAME     = '" + emp.getLastName() + "', "
//                    + "FIRST_NAME    = '" + emp.getFirstName() + "', "
//                    + "EMAIL         = '" + emp.getEmail() + "', "
//                    + "JOB_ID        = '" + emp.getJobId() + "', "
//                    + "PHONE_NUMBER  = '" + emp.getPhoneNumber() + "', "
//                    + "HIRE_DATE     =  to_date('" + hireDate + "', 'yyyyMMdd') , "
//                    + "DEPARTMENT_ID =  " + emp.getDepartmentId() + " , "
//                    + "MANAGER_ID    =  " + emp.getManagerId() + " , "
//                    + "SALARY        =  " + emp.getSalary() + "   "
//                    + "WHERE "
//                    + "EMPLOYEE_ID   =  " + emp.getEmployeeId();
//            int affectedRows = statement.executeUpdate(query);
//            Main.OraConnInstance.getConnection().commit();
//            return affectedRows;
//        } catch (SQLException ex) {
//            this.ex = ex;
//            return 0;
//        }
//    }
//
//    public int insertEmployee(Employee emp) {
//        try (Statement statement = Main.OraConnInstance.getConnection().createStatement();) {
//
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd" );
//            String hireDate = dtf.format(emp.getHireDate());
//
//            String query = "INSERT INTO EMPLOYEES VALUES("
//                    + "(SELECT MAX(EMPLOYEE_ID) + 1 FROM EMPLOYEES) , '"
//                    + emp.getFirstName() + "','"
//                    + emp.getLastName() + "','"
//                    + emp.getEmail() + "','"
//                    + emp.getPhoneNumber() + "', "
//                    + "to_date('" + hireDate + "','yy/MM/dd'), '"
//                    + emp.getJobId() + "', "
//                    + emp.getSalary() + " , "
//                    + "null" + " , "
//                    + emp.getManagerId() + " , "
//                    + emp.getDepartmentId() + " ) ";
//            return statement.executeUpdate(query);
//        } catch (SQLException ex) {
//            this.ex = ex;
//            return 0;
//        }
//    }

    private Employee rs2Employee(ResultSet resultSet) {
        Employee emp = null;
        try {
            int col = 1;
            emp = new Employee(resultSet.getInt(col++));
            emp.setFirstName(resultSet.getNString(col++));
            emp.setLastName(resultSet.getNString(col++));
            emp.setEmail(resultSet.getNString(col++));
            emp.setPhoneNumber(resultSet.getNString(col++));
//            emp.setHireDate(resultSet.getDate(col++).toLocalDate());
//            emp.setJobId(resultSet.getNString(col++));
//            emp.setSalary(resultSet.getDouble(col++));
            col++;
//            emp.setManagerId(resultSet.getInt(col++));
//            emp.setDepartmentId(resultSet.getInt(col++));
        } catch (SQLException ex) {
            this.ex = ex;
        }
        return emp;
    }
}
