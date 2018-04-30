package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.mysite.domain.Member;
import com.cafe24.mysite.service.MemberService;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private MemberService memberService;

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler )
	    throws Exception {
	String email = request.getParameter( "email" );
	String password = request.getParameter( "password" );

	Member authMember = memberService.getMember( email, password );

	if ( authMember == null ) {
	    request.setAttribute( "email", email );
	    request.setAttribute( "result", "fail" );
	    request.getRequestDispatcher( "/WEB-INF/views/member/login.jsp" ).forward( request, response );
	    return false;
	}

	HttpSession session = request.getSession( true );
	session.setAttribute( "authMember", authMember );
	response.sendRedirect( request.getContextPath() );
	return false;
    }
}
