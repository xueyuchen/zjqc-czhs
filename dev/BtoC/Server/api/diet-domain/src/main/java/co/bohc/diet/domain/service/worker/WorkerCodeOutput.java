package co.bohc.diet.domain.service.worker;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkerCodeOutput {

    private Integer workerId;
    private String workerName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone= "GMT+8")
    private Date creDt;
    private Integer codeNum;
    private Integer usedNum;
    private String local;
    public Integer getWorkerId() {
        return workerId;
    }
    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }
    public String getWorkerName() {
        return workerName;
    }
    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }
    public Date getCreDt() {
        return creDt;
    }
    public void setCreDt(Date creDt) {
        this.creDt = creDt;
    }
    public Integer getCodeNum() {
        return codeNum;
    }
    public void setCodeNum(Integer codeNum) {
        this.codeNum = codeNum;
    }
    public Integer getUsedNum() {
        return usedNum;
    }
    public void setUsedNum(Integer usedNum) {
        this.usedNum = usedNum;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    
}
