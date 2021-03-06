package com.jlife.sys.controller;


import com.jlife.sys.service.SysUserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by chenjianan on 2016/11/27-15:53.
 * <p>
 * Describe: 用户 controller
 */
@RequestMapping("sys/user")
@Controller
public class UserController {

    @Resource
    private SysUserService sysUserService;


    @RequestMapping("index")
    public ModelAndView  index(Model model){
        sysUserService.getById("1");
        ModelAndView view = new ModelAndView("/user/index");
        view.addObject("username","dddd");
        view.addObject("s","士大夫");
        return view;

    }
}
