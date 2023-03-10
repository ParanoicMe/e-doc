package e.doc.dao.exception;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 08.09.14
 * Time: 7:49
 * To change this template use File | Settings | File Templates.
 */
public enum DaoErrorCode {
    HU_DAO_000("Cannot get by id"),
    HU_DAO_001("Cannot get list");


    private final String value;

    private DaoErrorCode(String s) {
        value = s;
    }
    public String toString(){
        return value;
    }
}
