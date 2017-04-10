package com.jlife.test.bootest;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.jlife.bootest.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by chen on 2017/3/28.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public class Test {

    private Logger logger= LoggerFactory.getLogger(getClass());
    /**
     * 注解配置
     */
   // @org.junit.Test
    public void annoConf() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AnnoConf.class);
        LoginController loginController = annotationConfigApplicationContext.getBean(LoginController.class);
        loginController.login();
        annotationConfigApplicationContext.close();
    }

    /**
     * java配置
     */
   // @org.junit.Test
    public void javaConf() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AnnoConf.class);
        LogoutController logoutController = annotationConfigApplicationContext.getBean(LogoutController.class);
        logoutController.logout();
        annotationConfigApplicationContext.close();
    }

    /**
     * aop测试
     */
   // @org.junit.Test
    public void aopTest() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AopConf.class);
        LoginController loginController = annotationConfigApplicationContext.getBean(LoginController.class);
        loginController.login();
        annotationConfigApplicationContext.close();
    }


    /**
     * scope测试 singleton  prototype request session globalsession
     */
  //  @org.junit.Test
    public void scopeTest() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ScopeConf.class);
        SingletonService singletonService1 = annotationConfigApplicationContext.getBean(SingletonService.class);
        SingletonService singletonService2 = annotationConfigApplicationContext.getBean(SingletonService.class);

        ProtoTypeService protoTypeService1 = annotationConfigApplicationContext.getBean(ProtoTypeService.class);
        ProtoTypeService protoTypeService2 = annotationConfigApplicationContext.getBean(ProtoTypeService.class);

        logger.info(String.valueOf(singletonService1.equals(singletonService2)));

        logger.info(String.valueOf(protoTypeService1.equals(protoTypeService2)));


        annotationConfigApplicationContext.close();
    }

    /**
     * spring el 表达式的使用
     */
   // @org.junit.Test
    public void elTest() {

        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(ELConf.class);
        ELController elController=  annotationConfigApplicationContext.getBean(ELController.class);
        elController.info();
        annotationConfigApplicationContext.close();
    }


   // @org.junit.Test
    public void jedisTest() {

        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(JedisConf.class);
        JedisUtil jedisUtil=  annotationConfigApplicationContext.getBean(JedisUtil.class);

        jedisUtil.add("spring","ddd");
        annotationConfigApplicationContext.close();
    }
}
