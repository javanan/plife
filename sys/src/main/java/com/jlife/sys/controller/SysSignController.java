package com.jlife.sys.controller;

import com.jlife.base.config.Global;
import com.jlife.base.session.SessionDAO;
import com.jlife.base.util.CookieUtils;
import com.jlife.base.web.BaseController;
import com.jlife.sys.security.SysUserUtils;
import com.jlife.sys.security.SystemAuthorizingRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chenjianan on 2017/1/17-14:07.
 * <p>
 * Describe: 系统登录 controller
 */
@Controller
public class SysSignController extends BaseController{

    @Autowired
    private SessionDAO sessionDAO;
    /**
     * 管理登录，实际的登录交给了 shiro--》filter
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "sys/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        SystemAuthorizingRealm.Principal principal = SysUserUtils.getPrincipal();


        if (logger.isDebugEnabled()){
            logger.debug("login, active session size: {}", sessionDAO.getActiveSessions(false).size());
        }

        // 如果已登录，再次访问主页，则退出原账号。
        if (Global.YES.equals(Global.getConfig("notAllowRefreshIndex"))){
            CookieUtils.setCookie(response, "LOGINED", "false");
        }

        // 如果已经登录，则跳转到管理首页
        if(principal != null && !principal.isMobileLogin()){
            return "redirect:" + adminPath+successUrl;
        }

        return "/sign/login";
    }

}
