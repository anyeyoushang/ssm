package cn.timeface.ebook.common.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrossDomain implements Filter {
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response,
	FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			// 跨域
			String origin = httpRequest.getHeader("Origin");

			if (origin == null) {
				httpResponse.addHeader("Access-Control-Allow-Origin", "*");
			} else {
				httpResponse.addHeader("Access-Control-Allow-Origin", origin);
			}

			httpResponse.addHeader("Access-Control-Allow-Headers",
					"Origin, x-requested-with, Content-Type, Accept,X-Cookie");

			httpResponse.addHeader("Access-Control-Allow-Credentials", "true");

			httpResponse.addHeader("Access-Control-Allow-Methods",
					"GET,POST,PUT,OPTIONS,DELETE");

			if (httpRequest.getMethod().equals("OPTIONS")) {
				httpResponse.setStatus(HttpServletResponse.SC_OK);
				return;
			}
			chain.doFilter(request, response);
		} catch (Exception e) {
			System.out.println(e);
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {}
}
