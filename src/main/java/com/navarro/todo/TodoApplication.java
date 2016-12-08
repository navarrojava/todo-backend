package com.navarro.todo;

import com.navarro.todo.web.filter.CORSFilter;
import com.navarro.todo.web.filter.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class TodoApplication {

    private static final String GENERAL_MAPPING = "/*";

    private final
    CORSFilter corsFilter;

    private final
    SecurityFilter securityFilter;

    @Autowired
    public TodoApplication(@Qualifier("securityFilterBean") SecurityFilter securityFilter, CORSFilter corsFilter) {
        this.securityFilter = securityFilter;
        this.corsFilter = corsFilter;
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean corsFilterRegistrationBean() {
        FilterRegistrationBean cosrsFilterRegistration = new FilterRegistrationBean();
        cosrsFilterRegistration.setUrlPatterns(Collections.singletonList(GENERAL_MAPPING));
        cosrsFilterRegistration.setFilter(corsFilter);
        cosrsFilterRegistration.setOrder(0);
        return cosrsFilterRegistration;
    }

    @Bean
    public FilterRegistrationBean securityFilterRegistrationBean() {
        FilterRegistrationBean securityFilterRegistration = new FilterRegistrationBean();
        securityFilterRegistration.setUrlPatterns(Collections.singletonList(GENERAL_MAPPING));
        securityFilterRegistration.setFilter(securityFilter);
        securityFilterRegistration.setOrder(1);
        return securityFilterRegistration;
    }

}
