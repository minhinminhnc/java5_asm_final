package com.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.entity.Account;

@Component
public class AuthInterceptor implements HandlerInterceptor{
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	HttpServletResponse response;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		Account account = (Account) httpSession.getAttribute("account");
		if(account == null) {
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}

}
