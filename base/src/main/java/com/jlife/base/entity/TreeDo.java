package com.jlife.base.entity;

import com.jlife.base.util.StringUtils;
import org.hibernate.validator.constraints.Length;


/**
 * 数据Entity类
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
public abstract class TreeDo<T> extends DataDo<T> {

    private static final long serialVersionUID = 1L;

    /**
     * varchar(64) NULL父id
     */
    protected String parentId;
    /**
     * varchar(1000) NULL路径
     */
    protected String path;
    /**
     * int(11) NULL排序
     */
    protected Integer sort;

    /**
     * varchar(100) 名称
     */
    protected String name;
    /**
     * varchar(100)NULL图标
     */
    private String icon;

    @Length(min = 0, max = 1000, message = "icon长度必须介于 1 和 1000 之间")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public TreeDo() {
        super();
        this.sort = 30;
    }

    public TreeDo(String id) {
        super(id);
    }

    @Length(min = 0, max = 64, message = "父id长度必须介于 1 和 64 之间")
    public String getParentId() {
        return StringUtils.isNotBlank(id) ? id : "0";
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Length(min = 0, max = 1000, message = "路径长度必须介于 1 和 1000 之间")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Length(min = 0, max = 11, message = "排序长度必须介于 1 和 11 之间")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Length(min = 0, max = 100, message = "资源名称长度必须介于 1 和 100 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
