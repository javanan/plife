package com.jlife.base.filter;


import com.jlife.base.util.StringUtils;
import org.apache.shiro.web.servlet.OncePerRequestFilter;

import javax.servlet.*;

import java.io.IOException;

/**
 * Created by chenjianan on 2016/12/15-17:43.
 * <p>
 * Describe:
 */
public class OncePerReqFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("InitFilter开始--------");

        // 如果url中有语言属性则设置
        String lang=request.getParameter("lang");
        if (!StringUtils.isEmpty(lang)) {
            // Mvcs.setLocalizationKey(lang);
            //  servletRequest.setAttribute("lang", lang);
        }else{
            // Mvcs.getLocalizationKey()  1.r.56 版本是null,所以要做两次判断, 1.r.57已修复为默认值 Nutz:Fix issue 1072
            // lang=Strings.isBlank(Mvcs.getLocalizationKey())?Mvcs.getDefaultLocalizationKey():Mvcs.getLocalizationKey();
            lang="zh_CN";
        }
        request.setAttribute("lang", lang);
        request.setAttribute("AppName","xx");

        chain.doFilter(request, response);
        System.out.println("InitFilter结束--------");
    }

    public void destroy() {
        System.out.println("InitFilter销毁--------");
    }
}
