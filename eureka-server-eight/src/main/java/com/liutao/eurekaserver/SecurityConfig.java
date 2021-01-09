package com.liutao.eurekaserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * spring security 安全机制只要引入jar包就有了，需要在build.gradle里配置用户名密码
 * 其他节点在注册的时候可以直接把用户名密码拼到url里。但是security安全机制会有个跨域的防火墙
 * 该配置类就是关闭这个跨域的防火墙的
 *
 * Created by liutao20 on 2020/7/17
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.csrf().disable();
        super.configure(security);
    }
}
