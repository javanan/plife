package com.jlife.bootest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by chen on 2017/3/30.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Configuration
@ComponentScan("com.jlife.bootest")
@PropertySource("classpath:eltest.properties")
public class ELConf {


}
