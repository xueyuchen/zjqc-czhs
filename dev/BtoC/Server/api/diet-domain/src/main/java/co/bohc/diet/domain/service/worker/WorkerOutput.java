package co.bohc.diet.domain.service.worker;

import java.io.Serializable;

public class WorkerOutput implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer workerId;
    private String workerName;
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

}
