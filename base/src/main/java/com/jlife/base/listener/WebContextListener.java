package com.jlife.base.listener;

import org.slf4j.Logger;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * Created by chenjianan on 2016/12/16-10:30.
 * <p>
 * Describe: 作用：在启动Web容器时，自动装配Spring applicationContext.xml的配置信息。
 * DispatcherServlet的上下文仅仅是Spring MVC的上下文，而Spring加载的上下文是通过ContextLoaderListener来加载的。
 * 一般spring web项目中同时会使用这两种上下文，前者仅负责MVC相关bean的配置管理（如ViewResolver、Controller、MultipartResolver等），
 * 后者则负责整个spring相关bean的配置管理（如相关Service、DAO等）。
 */
public class WebContextListener extends org.springframework.web.context.ContextLoaderListener {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    @Override
    public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
        logger.info("在启动Web容器时，自动装配Spring applicationContext.xml的配置信息.....");
        return super.initWebApplicationContext(servletContext);
    }
}