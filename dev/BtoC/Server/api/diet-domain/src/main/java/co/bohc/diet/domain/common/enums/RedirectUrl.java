package co.bohc.diet.domain.common.enums;

public enum RedirectUrl {
    GMO(0),P0001(1);
    private int value;
    private RedirectUrl(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}
