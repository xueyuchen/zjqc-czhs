package co.bohc.diet.domain.service;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import co.bohc.diet.domain.common.constants.Constants;
import co.bohc.diet.domain.service.security.BohSecurityContextHolder;

/**
 * CRUD service that uses a {@link org.springframework.data.repository.PagingAndSortingRepository} Spring Data repository implementation
 *
 * You should extend it and inject your Repository bean by overriding {@link #setRepository(org.springframework.data.repository.PagingAndSortingRepository)}
 *
 * @param <T> Your resource class to manage, usually an entity class
 * @param <ID> Resource id type, usually Long or String
 * @param <R> The repository class
 */
@Transactional(readOnly = true)
public class CrudServiceImpl<T, ID extends Serializable, R extends PagingAndSortingRepository<T, ID>> implements
        CrudService<T, ID> {

    protected R repository;

    /**
     * @param repository the repository to set
     */
    public void setRepository(R repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public T create(T resource) {
        Assert.notNull(resource, "Resource can't be null");
        wrapEntityWithDefaults(resource);
        return repository.save(resource);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Iterable<T> create(Iterable<T> resources) {
        Assert.notNull(resources, "Resources can't be null");
        for (T resource : resources) {
            wrapEntityWithDefaults(resource);
        }
        return repository.save(resources);
    }
    
    protected Object wrapEntityWithDefaults(Object entity) {
        try {
            Date currDate = new Date();
            BeanUtils.setProperty(entity, Constants.D_TField_CREDT, currDate);
            BeanUtils.setProperty(entity, Constants.D_TField_UPDDT, currDate);
            BeanUtils.setProperty(entity, Constants.D_TField_CREUSERID, BohSecurityContextHolder.getCurrentId());
            BeanUtils.setProperty(entity, Constants.D_TField_UPDUSERID, BohSecurityContextHolder.getCurrentId());
            BeanUtils.setProperty(entity, Constants.D_TField_DELFLG, false);
            return entity;
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("finally")
    @Override
    @Transactional
    public T update(T resource) {
        Assert.notNull(resource, "Resource can't be null");
        try {
            Date currDate = new Date();
            BeanUtils.setProperty(resource, Constants.D_TField_UPDDT, currDate);
            BeanUtils.setProperty(resource, Constants.D_TField_UPDUSERID, BohSecurityContextHolder.getCurrentId());
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }finally{
            return repository.save(resource);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(T resource) {
        Assert.notNull(resource, "Resource can't be null");
        repository.delete(resource);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(ID id) {
        Assert.notNull(id, "Resource ID can't be null");
        repository.delete(id);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public T findOne(ID id) {
        Assert.notNull(id, "Resource ID can't be null");
        return repository.findOne(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<T> findAll(Iterable<ID> ids) {
        Assert.notNull(ids, "Resource ids can't be null");
        return repository.findAll(ids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<T> findPage(Pageable pageRequest) {
        Assert.notNull(pageRequest, "page request can't be null");
        return repository.findAll(pageRequest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        return repository.count();
    }
}