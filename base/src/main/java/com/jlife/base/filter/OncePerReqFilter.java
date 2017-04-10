package com.jlife.base.filter;


import com.jlife.base.util.StringUtils;
import com.jlife.base.web.Servlets;
import org.apache.shiro.web.servlet.OncePerRequestFilter;
import org.slf4j.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by chenjianan on 2016/12/15-17:43.
 * <p>
 * Describe:
 */
public class OncePerReqFilter extends OncePerRequestFilter {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    @Override
    protected void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        logger.debug("InitFilter开始-----{}", Servlets.getRequest().getRequestURI());

        // 如果url中有语言属性则设置
        String lang = request.getParameter("lang");
        if (!StringUtils.isEmpty(lang)) {

        } else {

            lang = "zh_CN";
        }
        request.setAttribute("lang", lang);
        request.setAttribute("AppName", "xx");

        chain.doFilter(request, response);
        logger.debug("InitFilter结束--------{}",Servlets.getRequest().getRequestURI());
    }

    public void destroy() {

        logger.debug("InitFilter销毁--------");

    }
}
