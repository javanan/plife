package com.jlife.bootest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by chen on 2017/3/30.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Service(value = "eLService")
public class ELService {

    @Value("${name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
