package com.spocle.config;


import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * Created by h.ono on 2017/04/11.
 */
//@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {
    @Bean
    HttpSessionStrategy httpSessionStrategy() {
        return new CookieHttpSessionStrategy();
    }
}
