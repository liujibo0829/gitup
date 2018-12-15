package com.baa.dailyreport.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;

import com.baa.dailyreport.dao.Mark;
import com.baa.dailyreport.pojo.User;

@Configuration
public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		User user = (User) session.getAttribute(Mark.LOGIN_SESSION_USER);
		if (uri.contains("logined")) {
			chain.doFilter(request, response);
		} else if (user != null) {
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("login").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
