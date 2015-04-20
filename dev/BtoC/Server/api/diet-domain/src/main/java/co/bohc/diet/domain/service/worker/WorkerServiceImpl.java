package co.bohc.diet.domain.service.worker;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.model.Worker;
import co.bohc.diet.domain.repository.code.CodeRepository;
import co.bohc.diet.domain.repository.worker.WorkerRepository;
import co.bohc.diet.domain.service.CrudServiceImpl;

@Service
@Transactional(readOnly = true)
public class WorkerServiceImpl extends CrudServiceImpl<Worker, Integer, WorkerRepository> implements WorkerService {

    @Inject
    public void setRepository(WorkerRepository repository) {
        super.setRepository(repository);
    }

    @Override
    public List<Worker> findWorkers() {
        return repository.findAllWorkerByDelFlg();
    }

}
