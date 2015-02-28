package co.bohc.diet.domain.common.enums;

public enum MealCommentFinish {
    FINISH(2, "済"),  UNFINISH(0, "未済"), NULL(9, "NULL"),REJECT(1,"差戻し");

    private final int value;

    private final String label;

    private MealCommentFinish(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public static MealCommentFinish valueOf(int value) {
        for (MealCommentFinish enums : MealCommentFinish.values()) {
            if (enums.value == value) {
                return enums;
            }
        }
        return null;
    }
}
