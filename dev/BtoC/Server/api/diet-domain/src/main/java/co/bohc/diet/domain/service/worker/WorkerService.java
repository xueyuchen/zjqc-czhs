package co.bohc.diet.domain.service.worker;

import java.util.List;

import co.bohc.diet.domain.model.Worker;
import co.bohc.diet.domain.service.CrudService;

public interface WorkerService extends CrudService<Worker, Integer> {

    public List<Worker> findWorkers();
}
