package com.cafe24.mysite.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.mysite.domain.Member;
import com.cafe24.mysite.repository.MemberRepository;
import com.cafe24.mysite.type.Role;
import com.cafe24.util.EncryptPassword;

@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void join( Member member ) {
	String encPassword = EncryptPassword.encrypt( member.getPassword() );
	member.setPassword( encPassword );
	member.setRole( Role.user );
	member.setJoinDate( new Date() );
	memberRepository.save( member );
    }

    public boolean isExistEmail( String email ) {
	Member member = memberRepository.findByEmail( email );
	return member != null;
    }

    public Member getMember( String email, String password ) {
	String encPassword = EncryptPassword.encrypt( password );
	return memberRepository.findByEmailAndPassword( email, encPassword );
    }
    
    public Member getMemberByNo( Long no ){
	return memberRepository.findOne(no);
    }

    public Member modifyMember( Member member ) {
	if( memberRepository.update( member ) == 1 ){
	    return memberRepository.findOne(member.getNo());
	}
	return null;
    }
}
