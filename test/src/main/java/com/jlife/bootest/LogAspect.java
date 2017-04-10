package com.jlife.bootest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by chen on 2017/3/28.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Aspect //通过@Aspect 声明一个切面
@Component //通过@Component 让切面交个 spring容器管理
public class LogAspect {

    private Logger logger= LoggerFactory.getLogger(getClass());
    /**
     * 通过@Pointcut 声明一个切点
     */
    @Pointcut("@annotation(com.jlife.bootest.AnnoLog)")
    public void annotationPointCut() {

    }


    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {//连接点
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();//方法签名
        java.lang.reflect.Method method = methodSignature.getMethod();
        AnnoLog annoLog = method.getAnnotation(AnnoLog.class);
        logger.debug(annoLog.after());

    }

}
