package mvc.employee.model.dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class OraConn {
    private Connection connection;
    private String oracleURL;
    private String userName;
    private String userPass;

    public OraConn(String url, String login, String pass) {
        this.oracleURL = url;
        this.userName = login;
        this.userPass = pass;
    }

    public void open() throws OraConnException {
        try {
            this.connection = DriverManager.getConnection(
                    oracleURL, userName, userPass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new OraConnException(1, "Unable to connect to Oracle SQL server" );
        }
    }

    public void close() throws OraConnException {
        try {
            this.connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new OraConnException(2, "Unable to close connection to Oracle SQL server" );
        }
    }

    public void testConnection() {
        try {
            this.registerDriver();
            this.open();
            this.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void registerDriver() throws OraConnException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver" );
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new OraConnException(3, "Unable to register driver for Oracle server" );
        }

    }

    public Connection getConnection() {
        return this.connection;
    }

}
