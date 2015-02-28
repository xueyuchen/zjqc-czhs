package co.bohc.diet.domain.repository.user;

import java.util.Date;

import co.bohc.diet.domain.common.utils.TimeUtils;


/**
 * 
 * @author dcy created at 2015-1-6
 *
 */
public class UserPaymentStatusOutput {
    
    private String applyDt;
    
    private Integer userId;
    
    private String orderNum;
    
    private String email;
    
    private String userNameKanji;
    
    private String userNameKana;
    
    private String statusKbn;

    public String getStatusKbn() {
        return statusKbn;
    }

    public void setStatusKbn(String statusKbn) {
        this.statusKbn = statusKbn;
    }

    public String getApplyDt() {
        return applyDt;
    }

    public void setApplyDt(Date applyDt) {
        this.applyDt = TimeUtils.dateToStr(applyDt).replace("-", "/");
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserNameKanji() {
        return userNameKanji;
    }

    public void setUserNameKanji(String userNameKanji) {
        this.userNameKanji = userNameKanji;
    }

    public String getUserNameKana() {
        return userNameKana;
    }

    public void setUserNameKana(String userNameKana) {
        this.userNameKana = userNameKana;
    }
    
    
}
