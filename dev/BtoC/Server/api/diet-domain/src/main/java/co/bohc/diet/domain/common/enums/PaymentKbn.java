package co.bohc.diet.domain.common.enums;

public enum PaymentKbn {
    NC("NC","入金済み"),
    NK("NK","入金確認済み");
    private String value;
    private String desc;
    private PaymentKbn(String value,String desc){
        this.value = value;
        this.desc = desc;
    }
    public String getValue(){
        return value;
    }
    
	public String getDesc() {
		return desc;
	}
    
}
