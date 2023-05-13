package e.doc.service.exception;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 08.09.14
 * Time: 7:49
 * To change this template use File | Settings | File Templates.
 */
public enum ServiceErrorCode {
    HU_SERVICE_000("Cannot get contract info"),
    HU_SERVICE_001("Cannot get Client Info By Gln"),
    HU_SERVICE_002("Cannot get weight"),
    HU_SERVICE_003(" convertFormSM SAX Exception"),
    HU_SERVICE_004("convertFormSM IO Exception"),
    HU_SERVICE_005("convertFormSM Parse Exception "),
    HU_SERVICE_006("Cannot init database sqlLite"),
    HU_SERVICE_007("Cannot get start time"),
    HU_SERVICE_008("Cannot update start time"),
    HU_SERVICE_009("Cannot write Hold Barcode to table holder"),
    HU_SERVICE_010("Cannot parse downloaded WayBill"),
    HU_SERVICE_011("Cannot MalformedURLException downloaded WayBill"),
    HU_SERVICE_012("download way bill IO Exception"),
    HU_SERVICE_013("Cannot send mail"),
    HU_SERVICE_014("Cannot convert ettn"),
    HU_SERVICE_015("Cannot get Holderbarcode"),
    HU_SERVICE_016("Cannot get Barcodes by articles"),
    HU_SERVICE_017("Cannot get articles  by Barcodes"),
    HU_SERVICE_018("Cannot init DAO StoreUnit"),
    HU_SERVICE_019("Cannot find Barcode");


    private final String value;

    private ServiceErrorCode(String s) {
        value = s;
    }
    public String toString(){
        return value;
    }
}
