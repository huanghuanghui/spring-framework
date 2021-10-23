package org.hhh.bean;

import org.springframework.stereotype.Component;

/**
 * @Author: hhh
 * @Date: 2021/10/20 11:23 上午
 * @Description TODO
 */
@Component
public class SqlSessionConfig {

    public String getName() {
        return "SqlSessionConfig/name";
    }

    public String getPassword() {
        return "SqlSessionConfig/password";
    }

}
