package co.bohc.diet.domain.repository.code;

import java.util.List;


import co.bohc.diet.domain.service.worker.WorkerCodeOutput;

public interface CodeRepositoryCustom {

    public List<WorkerCodeOutput> findCodeNumByWorker(WorkerCriteria criteria);
    
    public List<WorkerCodeOutput> findCodeNumByWorkerNoName(WorkerCriteria criteria);
}
