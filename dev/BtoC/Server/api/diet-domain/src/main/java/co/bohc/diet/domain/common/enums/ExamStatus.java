package co.bohc.diet.domain.common.enums;

public enum ExamStatus {

    SS(0, "登録申請済み"),
    NK(1, "入金待ち"),
    NC(2, "支払い済み"),
    SE(3, "検体キット送信済み"),
    KS(4, "ユーザから検体キット受信済み"),
    WR(5, "検査機関へ送付済み"),
    CP(6, "検査機関から受信済み"),
    IM(7, "遺伝子結果取り込み済み");

    private int value;
    
    private String desc;
    
    private String name;
    
    private ExamStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }       
    
    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
    
    public static ExamStatus getByName(String statusName) {
        for (ExamStatus item : ExamStatus.values()) {
            if (item.name().equals(statusName)) {
                return item;
            }
        }
        throw new IllegalArgumentException(statusName);
    }
   
    
    public static ExamStatus switchStatus(String statusName) {
        if (statusName.equals(CP.name)) {
            throw new IllegalArgumentException(statusName);
        }
        
        ExamStatus status = getByName(statusName);
        for (ExamStatus item : ExamStatus.values()) {
            if (item.value == (status.value + 1)) {
                return item;
            }
        }
        throw new IllegalArgumentException(statusName);
    }
    
}
