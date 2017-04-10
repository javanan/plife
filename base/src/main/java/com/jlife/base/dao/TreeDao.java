package com.jlife.base.dao;

import com.jlife.base.entity.TreeDo;

import java.util.List;

/**
 * Created by chen on 2017/4/10.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:树型结构的DAO支持类实现
 */

public interface TreeDao<T extends TreeDo<T>> extends CrudDao<T> {

    /**
     * 找到所有子节点
     * @param entity
     * @return
     */
    public List<T> findByParentIdsLike(T entity);

    /**
     * 更新所有父节点字段
     * @param entity
     * @return
     */
    public int updateParentIds(T entity);

}