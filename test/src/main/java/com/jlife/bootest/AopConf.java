package com.jlife.bootest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by chen on 2017/3/28.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Configuration
@ComponentScan("com.jlife.bootest")
@EnableAspectJAutoProxy //开启spring 对Aspect的支持
public class AopConf {

}
