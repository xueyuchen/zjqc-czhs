package co.bohc.diet.app.admin.api.user;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class UserTargetResource {

    private Integer userId;
    @NotBlank
    private String startRecDate;
    @NotNull
    private Double targetWeight;
    @NotNull
    private Integer targetPoint;
    @NotNull
    private Integer adminUserId;

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStartRecDate() {
        return startRecDate;
    }

    public void setStartRecDate(String startRecDate) {
        this.startRecDate = startRecDate;
    }

    public Double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(Double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public Integer getTargetPoint() {
        return targetPoint;
    }

    public void setTargetPoint(Integer targetPoint) {
        this.targetPoint = targetPoint;
    }

}
