package co.bohc.diet.domain.repository.accessory;


public class AccessorySearchPar {

    private Integer modelId;
    private Integer styleId;
    private Integer partId;

    public AccessorySearchPar(Integer modelId2, Integer styleId2, Integer partId2) {
        this.modelId = modelId2;
        this.styleId = styleId2;
        this.partId = partId2;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }


}