/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.jlife.sys.security;


import com.jlife.base.config.Global;
import com.jlife.base.util.CacheUtils;
import com.jlife.base.util.SpringContextHolder;
import com.jlife.sys.basepojo.BaseDo;
import com.jlife.sys.config.SysGlobal;
import com.jlife.sys.dao.SysRoleDao;
import com.jlife.sys.dao.SysUserDao;
import com.jlife.sys.entity.SysRole;
import com.jlife.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * 用户工具类
 * @author ThinkGem
 * @version 2013-12-05
 */
public class SysUserUtils {

	private static SysUserDao sysUserDao = SpringContextHolder.getBean(SysUserDao.class);
	private static SysRoleDao sysRoleDao = SpringContextHolder.getBean(SysRoleDao.class);

	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_LOGIN_NAME_ = "ln";
	public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";
	public static final String USER_CACHE_LIST_BY_COMPANY_ID_ = "cid_";

	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";
	



	


	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 获取当前登录者对象
	 */
	public static SystemAuthorizingRealm.Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			SystemAuthorizingRealm.Principal principal = (SystemAuthorizingRealm.Principal)subject.getPrincipal();
			if (principal != null){
				return principal;
			}
//			subject.logout();
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
//			subject.logout();
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	// ============== User Cache ==============
	
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
//		Object obj = getCacheMap().get(key);
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
//		getCacheMap().put(key, value);
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
//		getCacheMap().remove(key);
		getSession().removeAttribute(key);
	}
	
//	public static Map<String, Object> getCacheMap(){
//		Principal principal = getPrincipal();
//		if(principal!=null){
//			return principal.getCacheMap();
//		}
//		return new HashMap<String, Object>();
//	}

	/**
	 * 根据登录名获取用户
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static SysUser getByLoginName(String loginName){
		SysUser sysUser = (SysUser)CacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + loginName);
		if (sysUser == null){
			sysUser = sysUserDao.getByLoginName(loginName, BaseDo.DEL_FLAG_NORMAL);
			if (sysUser == null){
				return null;
			}
			// TODO 加入角色
		//	sysUser.setSysRoleList(sysRoleDao.findList(new SysRole(sysUser)));
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + sysUser.getId(), sysUser);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + sysUser.getLoginName(), sysUser);
		}
		return sysUser;
	}

	/**
	 * 获取当前用户
	 * @return 取不到返回 new User()
	 */
	public static SysUser getSysUser(){
		SystemAuthorizingRealm.Principal principal = getPrincipal();
		if (principal!=null){
			SysUser user = getById(principal.getId());
			if (user != null){
				return user;
			}
			return new SysUser();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new SysUser();
	}

	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static SysUser getById(String id){
		SysUser sysUser = (SysUser)CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
		if (sysUser ==  null){
			sysUser = sysUserDao.getById(id);
			if (sysUser == null){
				return null;
			}

			sysUser.setSysRoleList(sysRoleDao.findList(new SysRole(sysUser)));
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + sysUser.getId(), sysUser);
			CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + sysUser.getLoginName(), sysUser);
		}
		return sysUser;
	}

	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache(){
		removeCache(CACHE_ROLE_LIST);
		removeCache(CACHE_MENU_LIST);
		removeCache(CACHE_AREA_LIST);
		removeCache(CACHE_OFFICE_LIST);
		removeCache(CACHE_OFFICE_ALL_LIST);
		clearCache(getSysUser());
	}

	/**
	 * 清除指定用户缓存
	 * @param sysUser
	 */
	public static void clearCache(SysUser sysUser){
		CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + sysUser.getId());
		CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + sysUser.getLoginName());
		//CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + sysUser.getOldLoginName());
		if (sysUser.getSysCompany() != null && sysUser.getSysCompany().getId() != null){
			CacheUtils.remove(USER_CACHE, USER_CACHE_LIST_BY_COMPANY_ID_+ sysUser.getId());
		}
		if (sysUser.getSysRoleList() != null && sysUser.getSysRoleList().size()>0 ){
			CacheUtils.remove(USER_CACHE, CACHE_OFFICE_LIST + sysUser.getId());
		}
	}
}
