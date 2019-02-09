package mvc.employee.model.dal;

public class OraConnException extends Exception {
    public Integer errCode;
    public String errMsg;

    public OraConnException(Integer errCode, String errMsg) {
        super("Code: " + errCode + " Message: " + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

}
