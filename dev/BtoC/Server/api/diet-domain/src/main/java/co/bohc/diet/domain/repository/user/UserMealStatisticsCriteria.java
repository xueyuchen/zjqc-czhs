package co.bohc.diet.domain.repository.user;

import java.util.List;

/**
 * 
 * @author dcy created at 2014-12-26
 * modified by dcy at 2014-12-30
 *
 */
public class UserMealStatisticsCriteria {
    
    private Integer userId;
    
    private Integer adminUserId;
    
    private String userName;
    
    private String userNameKana;
    
    private Integer examNo;
    
    private String mealCreDtStart;
    
    private String mealCreDtEnd;
    
    private List<Integer> timeLineFinish;
    
    private List<Integer> evaluateFinish;
    
    private List<Integer> mealCommentFinish;
    
    public String getUserNameKana() {
        return userNameKana;
    }

    public void setUserNameKana(String userNameKana) {
        this.userNameKana = (userNameKana.trim().length()==0?null:userNameKana);
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = (userName.trim().length()==0?null:userName);
    }

    public Integer getExamNo() {
        return examNo;
    }

    public void setExamNo(Integer examNo) {
        this.examNo = examNo;
    }

    public String getMealCreDtStart() {
        return mealCreDtStart;
    }

    public void setMealCreDtStart(String mealCreDtStart) {
        this.mealCreDtStart = (mealCreDtStart.trim().length()==0?null:mealCreDtStart);
    }

    public String getMealCreDtEnd() {
        return mealCreDtEnd;
    }

    public void setMealCreDtEnd(String mealCreDtEnd) {
        this.mealCreDtEnd = (mealCreDtEnd.trim().length()==0?null:mealCreDtEnd);
    }

    public List<Integer> getTimeLineFinish() {
        return timeLineFinish;
    }

    public void setTimeLineFinish(List<Integer> timeLineFinish) {
        this.timeLineFinish = timeLineFinish;
    }

    public List<Integer> getEvaluateFinish() {
        return evaluateFinish;
    }

    public void setEvaluateFinish(List<Integer> evaluateFinish) {
        this.evaluateFinish = evaluateFinish;
    }

    public List<Integer> getMealCommentFinish() {
        return mealCommentFinish;
    }

    public void setMealCommentFinish(List<Integer> mealCommentFinish) {
        this.mealCommentFinish = mealCommentFinish;
    }

}