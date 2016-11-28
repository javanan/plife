package com.plife.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenjianan on 2016/11/27-15:53.
 * <p>
 * Describe: 用户 controller
 */
@RequestMapping("sys/user")
@Controller
public class UserController {

    @RequestMapping("index")
    public String index(Model model){
    return "v/user/index";
    }
}
