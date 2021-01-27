package com.gymer.gymer_rest_api.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggerRequestInterceptor implements HandlerInterceptor {

	private static final Logger log = LogManager.getRootLogger();

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) {

		String message = String.format("METHOD: %s, URL: %s, STATUS: %s",
				request.getMethod(), request.getRequestURI(), response.getStatus());
		log.info(message);
	}
}
