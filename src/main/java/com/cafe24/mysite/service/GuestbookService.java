package com.cafe24.mysite.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.mysite.domain.Guestbook;
import com.cafe24.mysite.repository.GuestbookRepository;
import com.cafe24.util.EncryptPassword;

@Service
@Transactional
public class GuestbookService {
    @Autowired
    private GuestbookRepository guestbookRepository;

    public List<Guestbook> getMessageList() {
	return (List<Guestbook>) guestbookRepository.findAll();
    }

    public boolean writeMessage( Guestbook guestbook ) {
	String encryptedPassword = EncryptPassword.encrypt(guestbook.getPassword());
	guestbook.setPassword(encryptedPassword);
	guestbook.setRegDate(new Date());
	if( guestbookRepository.save( guestbook ) == null ){
	    return false;
	}
	return true;
    }

    public boolean deleteMessage( Guestbook guestbook ) {
	Guestbook result = guestbookRepository.findOne( guestbook.getNo() );
	String encryptedPassword = EncryptPassword.encrypt( guestbook.getPassword() );
	if( !encryptedPassword.equals(result.getPassword()) ){
	    System.out.println( "fail" );
	    return false;
	}
	guestbookRepository.delete( result );
	return true;
    }
}
