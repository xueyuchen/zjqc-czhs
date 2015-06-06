package co.bohc.diet.domain.service.worker;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.bohc.diet.domain.model.Worker;
import co.bohc.diet.domain.repository.code.CodeRepository;
import co.bohc.diet.domain.repository.code.WorkerCriteria;
import co.bohc.diet.domain.repository.worker.WorkerRepository;
import co.bohc.diet.domain.service.CrudServiceImpl;

@Service
@Transactional(readOnly = true)
public class WorkerServiceImpl extends CrudServiceImpl<Worker, Integer, WorkerRepository> implements WorkerService {

    @Inject
    public void setRepository(WorkerRepository repository) {
        super.setRepository(repository);
    }
    
    @Inject
    private CodeRepository codeRepository;

    @Override
    public List<Worker> findWorkers() {
        return repository.findAllWorkerByDelFlg();
    }

    @Override
    @Transactional
    public String createWorker(String workerName, String local) {
        Worker worker = repository.findByWorkerName(workerName);
        if (worker != null) {
            return "此用户名已存在，请重新命名！";
        } else {
            worker = new Worker();
            worker.setCreDt(new Date());
            worker.setWorkerName(workerName);
            worker.setLocal(local);
            repository.save(worker);
            return "定损员录入成功！";
        }
    }

    @Override
    public List<WorkerCodeOutput> findCodeNumByWorker(WorkerCriteria criteria) {
        if((criteria.getWorkerName() == null) || ("".equals(criteria.getWorkerName()))){
            return codeRepository.findCodeNumByWorkerNoName(criteria);
        }else{
            return codeRepository.findCodeNumByWorker(criteria);
        }
    }

}
