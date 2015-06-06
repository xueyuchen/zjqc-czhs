package co.bohc.diet.domain.repository.code;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import co.bohc.diet.domain.common.utils.QueryParameterUtils;
import co.bohc.diet.domain.common.utils.VelocityUtils;
import co.bohc.diet.domain.service.worker.WorkerCodeOutput;

public class CodeRepositoryImpl implements CodeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<WorkerCodeOutput> findCodeNumByWorker(WorkerCriteria criteria) {
        String sql = VelocityUtils.render(criteria);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, criteria);
        query.setResultTransformer(Transformers.aliasToBean(WorkerCodeOutput.class));
        @SuppressWarnings("unchecked")
        List<WorkerCodeOutput> list = query.list();
        return list;
        
    }

    @Override
    public List<WorkerCodeOutput> findCodeNumByWorkerNoName(WorkerCriteria criteria) {
        String sql = VelocityUtils.render(criteria);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, criteria);
        query.setResultTransformer(Transformers.aliasToBean(WorkerCodeOutput.class));
        @SuppressWarnings("unchecked")
        List<WorkerCodeOutput> list = query.list();
        return list;
    }

}
