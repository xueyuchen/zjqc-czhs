package co.bohc.diet.domain.repository.user;

public class UserWithLatestWeightOutput {
    
    private int userId;

    private String email;
    
    private String startRecDate;
    
    private double weight;
    
    private double firstWeight;
    
    private double targetWeight;
    
    private String recordDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStartRecDate() {
        return startRecDate;
    }

    public void setStartRecDate(String startRecDate) {
        this.startRecDate = startRecDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(double firstWeight) {
        this.firstWeight = firstWeight;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }
    
}
