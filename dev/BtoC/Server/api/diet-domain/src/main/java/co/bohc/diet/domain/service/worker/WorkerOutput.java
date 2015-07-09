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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((local == null) ? 0 : local.hashCode());
        result = prime * result + ((workerName == null) ? 0 : workerName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        WorkerOutput other = (WorkerOutput) obj;
        if (local == null) {
            if (other.local != null)
                return false;
        } else if (!local.equals(other.local))
            return false;
        if (workerName == null) {
            if (other.workerName != null)
                return false;
        } else if (!workerName.equals(other.workerName))
            return false;
        return true;
    }
    

}
