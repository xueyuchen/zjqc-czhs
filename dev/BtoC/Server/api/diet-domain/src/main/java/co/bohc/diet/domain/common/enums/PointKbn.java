package co.bohc.diet.domain.common.enums;

/**
 * @author LiuYifan 
 *
 */
public enum PointKbn {

    CH("CH"),
    WR("WR"),
    ER("ER"),
    PR("PR"),
    SR("SR"),
    BF("BF"),
    MV("MV"),
    HK("HK"),
    GW("GW");
    
    private String value;
    
    private PointKbn(String value) {
        this.value = value;
    }
    
    public int getPoint() {
        int point = 0;
        switch (this) {
        case WR:
            point = 1; break;
        case SR:
            point = 1; break;
        case BF:
            point = 1; break;
        case PR:
            point = 1; break;
        case HK:
            point = 3; break;
        case ER:
            point = 1; break;
        // TODO add other type point.
        default:
            break;
        }
        return point;
    }
    
    public String getTypeStr() {
        return value;
    }
}

