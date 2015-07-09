package co.bohc.diet.domain.repository.code;

import java.util.Date;

public class WorkerCriteria {
    private Date fromDt;
    private Date toDt;
    private String workerName;
    private String local;

    public Date getFromDt() {
        return fromDt;
    }

    public void setFromDt(Date fromDt) {
        this.fromDt = fromDt;
    }

    public Date getToDt() {
        return toDt;
    }

    public void setToDt(Date toDt) {
        this.toDt = toDt;
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
