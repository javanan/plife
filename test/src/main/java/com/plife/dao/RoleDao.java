package com.plife.dao;

import com.plife.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by chenjianan on 2016/11/9-21:12.
 * <p>
 * Describe:
 */
public interface RoleDao {
    public Role getRole(Long id);

    @Select("select * from role where note=#{note}")
    public Role findByNote(String note);

    public int addRole(Role role);

    public Role typeHandlerTest(String note);

    public int roleNameCount(String name);

    public Role getRoleById(long dd);

    public List<Role> parameMap(Map map);

    public List<Role> sqltest(@Param("note")String note);
}
