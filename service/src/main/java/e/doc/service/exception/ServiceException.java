package e.doc.service.exception;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 08.09.14
 * Time: 7:39
 * To change this template use File | Settings | File Templates.
 */
public class ServiceException extends Exception {

    private ServiceErrorCode code;
    private Object[] params;
    private String message;

    public ServiceException(Throwable t, ServiceErrorCode code, Object... params) {
        super(t);
        this.code = code;
        this.params = params;
        this.message = String.format(code.toString(), params);
    }

    public ServiceErrorCode getCode() {
        return code;
    }

    public void setCode(ServiceErrorCode code) {
        this.code = code;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
