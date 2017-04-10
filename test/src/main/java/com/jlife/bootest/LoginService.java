package com.jlife.bootest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by chen on 2017/3/28.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Service
public class LoginService {

    private Logger logger = LoggerFactory.getLogger(getClass());


    public boolean login(){
        logger.debug("login------");
        return true;
    }
}
