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
    HU_DAO_001("Cannot get list"),
    HU_DAO_002("Cannot add object"),
    HU_DAO_003("Cannot update object"),
    HU_DAO_004("Cannot delete object"),
    HU_DAO_005("Cannot get query "),
    HU_DAO_006("Cannot connect sqllite"),
    HU_DAO_007("Cannot cast class"),
    HU_DAO_008("Cannot create tables"),
    HU_DAO_009("Cannot get data from table parameter"),
    HU_DAO_010("Cannot set data to table parameter"),
    HU_DAO_011("Cannot set data to table docholder"),
    HU_DAO_012("Cannot read oracle properties");


    private final String value;

    private DaoErrorCode(String s) {
        value = s;
    }
    public String toString(){
        return value;
    }
}
