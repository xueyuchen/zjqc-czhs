package co.bohc.diet.domain.common.enums;

public enum GmoResultParam {
    
    ORDERID(8,"orderID"),FORWARDED(9,"forwarded"),METHOD(10,"method"),PAYTIMES(11,"payTimes"),
    APPROVE(12,"approve"),TRANID(13,"tranID"),TRANDATE(14,"tranDate"),CHECKSTRING(15,"checkString"),
    PAYTYPE(22,"payType"),CUSTID(30,"custID"),BKCODE(31,"bkCode"),CONFNO(32,"confNo"),
    ENCRYPTRECEIPTNO(33,"encryptReceiptNo"),PAYMENTTERM(38,"paymentTerm");
    
    private final int value;

    private final String label;

    private GmoResultParam(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static GmoResultParam valueOf(int value) {
        for (GmoResultParam enums : GmoResultParam.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
