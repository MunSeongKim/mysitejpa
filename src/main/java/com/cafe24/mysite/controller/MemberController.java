package com.cafe24.mysite.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cafe24.mysite.domain.Member;
import com.cafe24.mysite.service.MemberService;
import com.cafe24.security.Auth;

@Controller
@RequestMapping( "/member" )
@SessionAttributes("authMember")
public class MemberController {
    @Autowired
    private MemberService MemberService;

    @RequestMapping( value = "/join", method = RequestMethod.GET )
    public String join(@ModelAttribute Member member) {
	return "member/join";
    }

    @RequestMapping( value = "/join", method = RequestMethod.POST )
    public String join( @ModelAttribute @Valid Member member, BindingResult result ) {
	if( result.hasErrors() ) {
	    List<ObjectError> list = result.getAllErrors();
	    for(ObjectError error: list){
		System.out.println( "Object Error: " + error );
	    }
	    
	    return "member/join";
	}
	MemberService.join( member );
	return "redirect:/member/joinsuccess";
    }

    @RequestMapping( value = "/joinsuccess", method = RequestMethod.GET )
    public String joinsuccess() {
	return "member/joinsuccess";
    }

    @RequestMapping( value = "/login", method = RequestMethod.GET )
    public String login() {
	return "member/login";
    }
    
    @Auth
    @RequestMapping( value = "/modify", method = RequestMethod.GET )
    public String modify( @ModelAttribute("authMember") Member authMember, Model model ) {
	System.out.println( authMember );
	Member member = MemberService.getMemberByNo( authMember.getNo() );
	model.addAttribute( "member", member );
	return "member/modify";
    }

    @Auth
    @RequestMapping( value = "/modify", method = RequestMethod.POST )
    public String modify( @ModelAttribute Member member, @ModelAttribute("authMember") Member authMember, Model model ) {
	Member modifiedMember = MemberService.modifyMember( member );
	authMember = modifiedMember;

	model.addAttribute( "member", modifiedMember );
	model.addAttribute( "authMember", authMember );
	return "member/modify";
    }
}