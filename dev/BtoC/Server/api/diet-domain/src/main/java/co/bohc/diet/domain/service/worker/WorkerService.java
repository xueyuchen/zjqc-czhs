package co.bohc.diet.domain.service.worker;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.bohc.diet.domain.model.Worker;
import co.bohc.diet.domain.repository.code.WorkerCriteria;
import co.bohc.diet.domain.service.CrudService;

public interface WorkerService extends CrudService<Worker, Integer> {

    public List<Worker> findWorkers();
    
    public String createWorker(String workerName, String local);
    
    public Page<WorkerCodeOutput> findCodeNumByWorker(WorkerCriteria criteria, Pageable pageable);
}
