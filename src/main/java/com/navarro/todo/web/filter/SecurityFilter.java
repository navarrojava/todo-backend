package com.navarro.todo.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Component
public class SecurityFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityFilter.class);



    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        String path = request.getServletPath();
        String URI = request.getRequestURI();
        String URL = String.valueOf(request.getRequestURL());
        String method = request.getMethod();
        UUID apiToken = UUID.fromString("00000000-0000-0000-0000-000000000000");
        UUID validApiToken = UUID.fromString("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");


        if (method.equalsIgnoreCase("OPTIONS")) {
                grantAccess(request, res, chain);
            }
            else {

                if (request.getHeader("ApiKey") != null) {
                     apiToken = UUID.fromString(request.getHeader("ApiKey"));

                }
                if (!apiToken.equals(validApiToken)) {
                    rejectAccess(res);
                } else  {
                    grantAccess(request, res, chain);
                }
            }
        }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

    public void rejectAccess(ServletResponse res) throws IOException {
        ((HttpServletResponse) res).setStatus(UNAUTHORIZED.value());
        res.getWriter().write(UNAUTHORIZED.toString());
        res.getWriter().flush();

        LOGGER.info("[ TODO INFO ] ACESSO NEGADO API KEY INVÁLIDA!!!");
    }

    public void grantAccess(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(req, res);
    }

    @Bean
    public SecurityFilter securityFilterBean() {
        return new SecurityFilter();
    }
}
