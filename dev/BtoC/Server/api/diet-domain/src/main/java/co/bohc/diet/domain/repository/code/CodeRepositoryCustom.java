package co.bohc.diet.domain.repository.code;

import java.util.List;

import org.springframework.data.domain.Pageable;

import co.bohc.diet.domain.service.code.PaperWorkerOutput;
import co.bohc.diet.domain.service.worker.WorkerCodeOutput;

public interface CodeRepositoryCustom {

    public List<WorkerCodeOutput> findCodeNumByWorker(WorkerCriteria criteria, Pageable pageable);

    public List<WorkerCodeOutput> findCodeNumByWorkerNoName(WorkerCriteria criteria, Pageable pageable);

    public List<WorkerCodeOutput> findCodeNumByWorkerNoLocal(WorkerCriteria criteria, Pageable pageable);

    public List<Integer> countCodeNumByWorker(WorkerCriteria criteria);

    public List<Integer> countCodeNumByWorkerNoName(WorkerCriteria criteria);

    public List<Integer> countCodeNumByWorkerNoLocal(WorkerCriteria criteria);

    public List<PaperWorkerOutput> findPaperByWorker(WorkerCriteria criteria, Pageable pageable);

    public List<Integer> countPaperByWorker(WorkerCriteria criteria);
}
