package com.jlife.bootest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by chen on 2017/3/30.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Controller
public class ELController {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Value("字符串注入")
    private String stringEL;

    @Value("#{systemProperties['os.name']}")
    private String sysProperties;

    @Value("#{ T(java.lang.Math).random()*100.0}")
    private double random;

    @Value("#{ eLService.name}")
    private String otherValue;

    @Value("classpath:eltest.text")
    private Resource fileResource;

    @Value("http://www.baidu.com")
    private Resource httpResource;


    @javax.annotation.Resource
    private Environment environment;

    public void info(){
        logger.info(stringEL);
        logger.info(sysProperties);
        logger.info(String.valueOf(random));
        logger.info(String.valueOf(otherValue));
        try {
            logger.info(String.valueOf(IOUtils.toString(fileResource.getInputStream(), Charset.defaultCharset())));
            logger.info(String.valueOf(IOUtils.toString(httpResource.getInputStream(), Charset.defaultCharset())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info(environment.getProperty("name"));
    }
}
