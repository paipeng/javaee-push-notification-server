package com.paipeng.pushserver.interceptor;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.paipeng.pushserver.utils.ServerConfig;

public class SessionInterceptor implements Filter {
	@Inject
	private Logger log;

	//private static ThreadLocal<String> sessionTokenThreadLocal = new ThreadLocal<String>();

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		log.info("doFilter");
		
		ServerConfig serverConfig = new ServerConfig();
		log.info("gcm_apikey " + serverConfig.getGcmApiKey());
		chain.doFilter(request, response);
		// sessionTokenThreadLocal.set(null);
		log.info("doFilter done");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("init");
	}

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		log.info("intercept");

		return context.proceed();
	}
}
