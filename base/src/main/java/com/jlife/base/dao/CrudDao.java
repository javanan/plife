package com.jlife.base.dao;

import java.util.List;

/**
 * Created by chen on 2017/4/10.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * DAO支持类实现
 *
 * @param <T>
 */

public interface CrudDao<T> extends BaseDao {

    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    T getById(String id);

    /**
     * 获取单条数据
     *
     * @param entity
     * @return
     */
    T getByEntity(T entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     *
     * @param entity
     * @return
     */
    public List<T> findList(T entity);

    /**
     * 查询所有数据列表
     *
     * @param entity
     * @return
     */
    List<T> findAllList(T entity);

    /**
     * 查询所有数据列表
     *
     * @return
     * @see public List<T> findAllList(T entity)
     */
    @Deprecated
    public List<T> findAllList();

    /**
     * 插入数据
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 更新数据
     *
     * @param entity
     * @return
     */
    int update(T entity);


    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     *
     * @param entity
     * @return
     */
    int delete(T entity);

    /**
     * 物理删除
     *
     * @param entity
     * @return
     */
    int remove(T entity);

}
