package com.jlife.bootest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by chen on 2017/3/28.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @AnnoLog(after = "after---login")
    public void  login(){
        loginService.login();
    }
}
