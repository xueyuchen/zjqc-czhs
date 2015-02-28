package co.bohc.diet.domain.repository.user;

/**
 * @author dcy created at 2014-12-26
 * modified by dcy at 2014-12-30 add loginId(type=String) field to output
 */
public class UserMealStatisticsOutput {
    
    private Integer userId;
    
    private String userName;
    
    private Integer timeLineFinish;
    
    private Integer evaluateFinish;
    
    private Integer mealCommentFinish;
    
    public Integer getTimeLineFinish() {
        return timeLineFinish;
    }
    
    public void setTimeLineFinish(Integer timeLineFinish) {
        this.timeLineFinish = timeLineFinish;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    public Integer getEvaluateFinish() {
        return evaluateFinish;
    }
    
    public void setEvaluateFinish(Integer evaluateFinish) {
        this.evaluateFinish = evaluateFinish;
    }
    
    public Integer getMealCommentFinish() {
        return mealCommentFinish;
    }
    
    public void setMealCommentFinish(Integer mealCommentFinish) {
        this.mealCommentFinish = mealCommentFinish;
    }
    
}
