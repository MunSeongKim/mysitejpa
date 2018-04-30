package com.cafe24.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite.domain.Member;
import com.cafe24.mysite.dto.JSONResult;
import com.cafe24.mysite.repository.MemberRepository;

@Controller("UserAPIController")
@RequestMapping( "/api/user" )
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @ResponseBody
    @RequestMapping( "/checkemail" )
    public JSONResult checkEMail( 
	    @RequestParam( value = "email", required = true, defaultValue = "" ) String email ) {
	Member member = memberRepository.findByEmail(email);
	return JSONResult.success( member == null ? "not exists" : "exist" );
    }
}