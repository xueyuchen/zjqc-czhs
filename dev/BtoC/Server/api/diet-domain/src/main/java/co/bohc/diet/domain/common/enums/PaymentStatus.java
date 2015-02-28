package co.bohc.diet.domain.common.enums;

public enum PaymentStatus {
    PAYSUCCESS("PAYSUCCESS",2),CAPTURE("CAPTURE",3),REQSUCCESS("REQSUCCESS",1);
    private String value;
    private Integer status;
    private PaymentStatus(String value,Integer status) {
        this.value = value;
        this.status = status;
    }
    public String getValue() {
        return value;
    }
    public Integer getStatus() {
        return status;
    }
}
