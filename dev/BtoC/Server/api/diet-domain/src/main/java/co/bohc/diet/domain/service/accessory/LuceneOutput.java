package co.bohc.diet.domain.service.accessory;

public class LuceneOutput {

    private String accessoryName;
    private String accessoryNum;
    private String accessoryImg;

    public String getAccessoryName() {
        return accessoryName;
    }

    public void setAccessoryName(String accessoryName) {
        this.accessoryName = accessoryName;
    }

    public String getAccessoryNum() {
        return accessoryNum;
    }

    public void setAccessoryNum(String accessoryNum) {
        this.accessoryNum = accessoryNum;
    }

    public String getAccessoryImg() {
        return accessoryImg;
    }

    public void setAccessoryImg(String accessoryImg) {
        this.accessoryImg = accessoryImg;
    }

    public LuceneOutput(String accessoryName, String accessoryNum, String accessoryImg) {
        super();
        this.accessoryName = accessoryName;
        this.accessoryNum = accessoryNum;
        this.accessoryImg = accessoryImg;
    }

}
