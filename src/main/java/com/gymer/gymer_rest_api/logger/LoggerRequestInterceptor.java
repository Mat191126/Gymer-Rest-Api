package com.gymer.gymer_rest_api.logger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggerRequestInterceptor implements HandlerInterceptor {

    // spring.autoconfigure.exclude: org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration
    // this line in application.properties disable redirecting user to /error endpoint

    private static final Logger log = LogManager.getRootLogger();

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String message = String.format("METHOD: %s, URL: %s, STATUS: %s",
                request.getMethod(), request.getRequestURI(), response.getStatus());
        log.info(message);
    }

}
