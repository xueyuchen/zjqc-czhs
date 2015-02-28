package co.bohc.diet.domain.service;
import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * CRUD Service interface.
 *
 * @param <T>  Your resource POJO to manage, maybe an entity or DTO class
 * @param <ID> Resource id type, usually Long or String
 */
public interface CrudService<T, ID extends Serializable> {

    /**
     * Create new resource.
     *
     * @param resource Resource to create
     * @return new resource
     */
    T create(T resource);
    
    /**
     * Create all given resources.
     * 
     * @param resources
     * @return the saved resources
     * @author LiuYifan
     */
    Iterable<T> create(Iterable<T> resources);

    /**
     * Update existing resource.
     *
     * @param resource Resource to update
     * @return resource updated
     */
    T update(T resource);

    /**
     * Delete existing resource.
     *
     * @param resource Resource to delete
     */
    void delete(T resource);

    /**
     * Delete existing resource.
     *
     * @param id Resource id
     */
    void delete(ID id);


    /**
     * Find resource by id.
     *
     * @param id Resource id
     * @return resource
     */
    T findOne(ID id);

    /**
     * Find resources by their ids.
     *
     * @param ids Resource ids
     * @return a list of retrieved resources, empty if no resource found
     */
    Iterable<T> findAll(Iterable<ID> ids);

    /**
     * Find all resources.
     *
     * @return a list of all resources.
     */
    Iterable<T> findAll();

    /**
     * Find all resources (pageable).
     *
     * @param pageRequest page request
     * @return resources
     */
    Page<T> findPage(Pageable pageRequest);

    /**
     * Count all resources.
     *
     * @return number of resources
     */
    Long count();
}