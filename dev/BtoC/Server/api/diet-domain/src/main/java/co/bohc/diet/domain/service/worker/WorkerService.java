package co.bohc.diet.domain.service.worker;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.bohc.diet.domain.model.Worker;
import co.bohc.diet.domain.repository.code.WorkerCriteria;
import co.bohc.diet.domain.service.CrudService;
import co.bohc.diet.domain.service.code.PaperWorkerOutput;

public interface WorkerService extends CrudService<Worker, Integer> {

    public List<Worker> findWorkers(String local);
    
    public String createWorker(String workerName, String local);
    
    public Page<WorkerCodeOutput> findCodeNumByWorker(WorkerCriteria criteria, Pageable pageable);
    
    public Page<PaperWorkerOutput> findPaperByWorker(WorkerCriteria criteria, Pageable pageable);
}
