package com.spocle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.spocle.domain.model.dto.LoginUser;

@EnableJpaAuditing
@Configuration
public class AuditConfig {
	@Bean
    public AuditorAware<String> createAuditorProvider() {
        return new SecurityAuditor();
    }

    @Bean
    public AuditingEntityListener createAuditingListener() {
        return new AuditingEntityListener();
    }

    public static class SecurityAuditor implements AuditorAware<String> {
        @Override
        public String getCurrentAuditor() {
//        	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            if (authentication == null || !authentication.isAuthenticated()){
//                return null;
//            }
//            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
//
//            return loginUser.getUsername();
        	return "hoge";
        }
    }
}
