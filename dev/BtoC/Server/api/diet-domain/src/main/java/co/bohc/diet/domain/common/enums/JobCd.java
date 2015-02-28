package co.bohc.diet.domain.common.enums;

public enum JobCd {
    SALES("SALES"), CAPTURE("CAPTURE");
    private String value;
    private JobCd(String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
