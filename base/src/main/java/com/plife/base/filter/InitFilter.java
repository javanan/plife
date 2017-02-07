package com.plife.base.filter;


import com.plife.base.utils.StringUtils;

import javax.servlet.*;

import java.io.IOException;

/**
 * Created by chenjianan on 2016/12/15-17:43.
 * <p>
 * Describe:
 */
public class InitFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("InitFilter初始化--------");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("InitFilter开始--------");


        // 如果url中有语言属性则设置
        String lang=servletRequest.getParameter("lang");
        if (!StringUtils.isEmpty(lang)) {
           // Mvcs.setLocalizationKey(lang);
          //  servletRequest.setAttribute("lang", lang);
        }else{
            // Mvcs.getLocalizationKey()  1.r.56 版本是null,所以要做两次判断, 1.r.57已修复为默认值 Nutz:Fix issue 1072
           // lang=Strings.isBlank(Mvcs.getLocalizationKey())?Mvcs.getDefaultLocalizationKey():Mvcs.getLocalizationKey();
            lang="zh_CN";
        }
        servletRequest.setAttribute("lang", lang);

        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("InitFilter结束--------");
    }

    public void destroy() {
        System.out.println("InitFilter销毁--------");
    }
}
