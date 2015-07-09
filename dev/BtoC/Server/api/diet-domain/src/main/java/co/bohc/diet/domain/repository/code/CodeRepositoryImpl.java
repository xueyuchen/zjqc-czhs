package co.bohc.diet.domain.repository.code;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.data.domain.Pageable;

import co.bohc.diet.domain.common.utils.QueryParameterUtils;
import co.bohc.diet.domain.common.utils.VelocityUtils;
import co.bohc.diet.domain.service.code.PaperWorkerOutput;
import co.bohc.diet.domain.service.worker.WorkerCodeOutput;

public class CodeRepositoryImpl implements CodeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<WorkerCodeOutput> findCodeNumByWorker(WorkerCriteria criteria, Pageable pageable) {
        String sql = VelocityUtils.render(criteria);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, criteria);
        query.setResultTransformer(Transformers.aliasToBean(WorkerCodeOutput.class));
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        @SuppressWarnings("unchecked")
        List<WorkerCodeOutput> list = query.list();
        return list;
        
    }

    @Override
    public List<WorkerCodeOutput> findCodeNumByWorkerNoName(WorkerCriteria criteria, Pageable pageable) {
        String sql = VelocityUtils.render(criteria);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, criteria);
        query.setResultTransformer(Transformers.aliasToBean(WorkerCodeOutput.class));
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        @SuppressWarnings("unchecked")
        List<WorkerCodeOutput> list = query.list();
        return list;
    }

    @Override
    public List<Integer> countCodeNumByWorker(WorkerCriteria criteria) {
        String sql = VelocityUtils.render(criteria);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, criteria);
        @SuppressWarnings("unchecked")
        List<Integer> list = query.list();
        return list;
    }

    @Override
    public List<Integer> countCodeNumByWorkerNoName(WorkerCriteria criteria) {
        String sql = VelocityUtils.render(criteria);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, criteria);
        @SuppressWarnings("unchecked")
        List<Integer> list = query.list();
        return list;
    }

    @Override
    public List<Integer> countCodeNumByWorkerNoLocal(WorkerCriteria criteria) {
        String sql = VelocityUtils.render(criteria);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, criteria);
        @SuppressWarnings("unchecked")
        List<Integer> list = query.list();
        return list;
    }

    @Override
    public List<WorkerCodeOutput> findCodeNumByWorkerNoLocal(WorkerCriteria criteria, Pageable pageable) {
        String sql = VelocityUtils.render(criteria);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, criteria);
        query.setResultTransformer(Transformers.aliasToBean(WorkerCodeOutput.class));
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        @SuppressWarnings("unchecked")
        List<WorkerCodeOutput> list = query.list();
        return list;
    }

    @Override
    public List<PaperWorkerOutput> findPaperByWorker(WorkerCriteria criteria, Pageable pageable) {
        String sql = VelocityUtils.render(criteria);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, criteria);
        query.setResultTransformer(Transformers.aliasToBean(PaperWorkerOutput.class));
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        @SuppressWarnings("unchecked")
        List<PaperWorkerOutput> list = query.list();
        return list;
    }

    @Override
    public List<Integer> countPaperByWorker(WorkerCriteria criteria) {
        String sql = VelocityUtils.render(criteria);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, criteria);
        @SuppressWarnings("unchecked")
        List<Integer> list = query.list();
        return list;
    }

}
