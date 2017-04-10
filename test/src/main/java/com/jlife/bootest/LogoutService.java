package com.jlife.bootest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chen on 2017/3/28.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public class LogoutService {

    private Logger logger= LoggerFactory.getLogger(getClass());

    public void logout(){
        logger.debug("--logout");
    }

}
