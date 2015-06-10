package co.bohc.diet.domain.common.enums;

public enum LocalEnums {

    E("西南", "1"),
    S("西北", "2");
//    W("西", "3"),
//    N("北", "4");

    private String value;
    
    private String desc;
    
    private String name;
    
    private LocalEnums(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }       
    
    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
    
    public static String getByName(String statusName) {
        for (LocalEnums item : LocalEnums.values()) {
            if (item.desc.equals(statusName)) {
                return item.value;
            }
        }
        throw new IllegalArgumentException(statusName);
    }
   
    
}
