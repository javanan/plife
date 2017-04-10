package com.jlife.sys.controller;

import com.jlife.base.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chenjianan on 2017/2/26-19:06.
 * <p>
 * Describe: 后台系统登录后访问的controller
 */
@Controller
@RequestMapping("/sys")
public class IndexController extends BaseController {

    /**
     * 登录后的欢迎地址
     * @return
     */
    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(){
      //  return "/index/index";
        return "user/index";
    }
}
