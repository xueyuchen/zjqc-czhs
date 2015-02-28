package co.bohc.diet.domain.repository.adminuser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;

import co.bohc.diet.domain.common.utils.VelocityUtils;


public class AdminUserRepositoryImpl implements AdminUserRepositoryCustom {

	@PersistenceContext
    private EntityManager entityManager;
   
	@Override
	public int dleteAboutAdminUser(Integer adminUserId) {
        SQLQuery query = entityManager.createNativeQuery(VelocityUtils.render()).unwrap(SQLQuery.class);
        query.setParameter("adminUserId", adminUserId);
        return query.executeUpdate();
	}
}
