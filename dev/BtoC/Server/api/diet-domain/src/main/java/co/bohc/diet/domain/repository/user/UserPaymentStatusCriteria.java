package co.bohc.diet.domain.repository.user;
/**
 * 
 * @author dcy created at 2015-1-6
 *
 */
public class UserPaymentStatusCriteria {
    
    private Integer userId;
    
    private String userNameKanji;
    
    private String userNameKana;
    
    private String applyDtStart;
    
    private String applyDtEnd;
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getUserNameKanji() {
        return userNameKanji;
    }
    
    public void setUserNameKanji(String userNameKanji) {
        this.userNameKanji = (userNameKanji.trim().length()==0?null:userNameKanji);
    }
    
    public String getUserNameKana() {
        return userNameKana;
    }
    
    public void setUserNameKana(String userNameKana) {
        this.userNameKana = (userNameKana.trim().length()==0?null:userNameKana);
    }
    
    public String getApplyDtStart() {
        return applyDtStart;
    }
    
    public void setApplyDtStart(String applyDtStart) {
        this.applyDtStart = (applyDtStart.trim().length()==0?null:applyDtStart);
    }
    
    public String getApplyDtEnd() {
        return applyDtEnd;
    }
    
    public void setApplyDtEnd(String applyDtEnd) {
        this.applyDtEnd = (applyDtEnd.trim().length()==0?null:applyDtEnd);
    }
    
}
