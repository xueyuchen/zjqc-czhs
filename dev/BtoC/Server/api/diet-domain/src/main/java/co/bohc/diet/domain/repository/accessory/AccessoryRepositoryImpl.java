package co.bohc.diet.domain.repository.accessory;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;

import co.bohc.diet.domain.common.utils.QueryParameterUtils;
import co.bohc.diet.domain.common.utils.VelocityUtils;
import co.bohc.diet.domain.model.Accessory;

public class AccessoryRepositoryImpl implements AccesstoryRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Accessory> findByParam(AccessorySearchPar accessorySearchPar) {
        String sql = VelocityUtils.render(accessorySearchPar);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, accessorySearchPar);
        query.setResultTransformer(Transformers.aliasToBean(Accessory.class));
//        query.setFirstResult(pageable.getOffset());
//        query.setMaxResults(pageable.getPageSize());
        @SuppressWarnings("unchecked")
        List<Accessory> list = query.list();
        return list;
    }

    @Override
    public List<Accessory> findByParamSale(AccessorySearchPar accessorySearchPar) {
        String sql = VelocityUtils.render(accessorySearchPar);
        SQLQuery query = entityManager.createNativeQuery(sql.toString()).unwrap(SQLQuery.class);
        QueryParameterUtils.copyParameters(query, accessorySearchPar);
        query.setResultTransformer(Transformers.aliasToBean(Accessory.class));
//        query.setFirstResult(pageable.getOffset());
//        query.setMaxResults(pageable.getPageSize());
        @SuppressWarnings("unchecked")
        List<Accessory> list = query.list();
        return list;
    }

}
