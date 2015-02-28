package co.bohc.diet.domain.repository.user;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class UserCriteria {
	
	private Integer userId;
	
	private String userName;
	
	private String kanaName;
	
	private Integer examId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date creDtStart;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date creDtEnd;
	
	private Integer timelineFlag;
	
	private Integer evaluateFlag;
	
	private Integer mealCommentFlag;

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

	public String getKanaName() {
		return kanaName;
	}

	public void setKanaName(String kanaName) {
		this.kanaName = kanaName;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public Date getCreDtStart() {
		return creDtStart;
	}

	public void setCreDtStart(Date creDtStart) {
		this.creDtStart = creDtStart;
	}

	public Date getCreDtEnd() {
		return creDtEnd;
	}

	public void setCreDtEnd(Date creDtEnd) {
		this.creDtEnd = creDtEnd;
	}

	public Integer getTimelineFlag() {
		return timelineFlag;
	}

	public void setTimelineFlag(Integer timelineFlag) {
		this.timelineFlag = timelineFlag;
	}

	public Integer getEvaluateFlag() {
		return evaluateFlag;
	}

	public void setEvaluateFlag(Integer evaluateFlag) {
		this.evaluateFlag = evaluateFlag;
	}

	public Integer getMealCommentFlag() {
		return mealCommentFlag;
	}

	public void setMealCommentFlag(Integer mealCommentFlag) {
		this.mealCommentFlag = mealCommentFlag;
	}
	
}
