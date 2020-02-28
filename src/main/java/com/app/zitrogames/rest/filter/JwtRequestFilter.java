package com.app.zitrogames.rest.filter;

import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.zitrogames.rest.utils.JwtUtils;

import io.jsonwebtoken.ExpiredJwtException;

public class JwtRequestFilter implements Filter {

	private static final Logger LOG = getLogger(JwtRequestFilter.class);

	@Autowired
	private JwtUtils jwtUtil;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		LOG.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());

		final String requestTokenHeader = req.getHeader("Authorization");
		if (requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer ")) {
			throw new ServletException("Bearer token error required.");
		}

		// TODO: check token is from the user

		// check time token
		try {
			jwtUtil.isTokenExpired(requestTokenHeader.substring(7));
		} catch (ExpiredJwtException e) {
			throw new ServletException("Bearer token expired. Game time is over!!!!");
		}

		LOG.info("Logging Response :{}", res.getContentType());
		chain.doFilter(request, response);
	}
}
