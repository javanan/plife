package com.jlife.bootest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chen on 2017/3/28.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Configuration
public class JavaConf {

    @Bean
    public LogoutService logoutService() {
        return new LogoutService();
    }

    @Bean
    public LogoutController logoutController() {
        LogoutController logoutController = new LogoutController();
        logoutController.setLogoutService(logoutService());
        return logoutController;
    }

    @Bean
    public LogoutController logoutController(LogoutService logoutService) {
        LogoutController logoutController = new LogoutController();
        logoutController.setLogoutService(logoutService);
        return logoutController;
    }

}
