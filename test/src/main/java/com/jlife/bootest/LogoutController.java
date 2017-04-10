package com.jlife.bootest;

/**
 * Created by chen on 2017/3/28.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public class LogoutController {

    private LogoutService logoutService;

    public void setLogoutService(LogoutService logoutService) {
        this.logoutService = logoutService;
    }

    public void logout(){
        logoutService.logout();
    }
}
