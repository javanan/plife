package com.plife.base.filter;


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
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("InitFilter结束--------");
    }

    public void destroy() {
        System.out.println("InitFilter销毁--------");
    }
}
