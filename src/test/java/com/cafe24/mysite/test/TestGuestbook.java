package com.cafe24.mysite.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cafe24.mysite.domain.Guestbook;
import com.cafe24.mysite.service.GuestbookService;
import com.cafe24.util.EncryptPassword;

@ContextConfiguration( "classpath:applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class TestGuestbook {
    @Autowired
    private GuestbookService guestbookService;

    @Ignore @Test
    public void test01_getMessageList() {
	List<Guestbook> result = guestbookService.getMessageList();
	assertThat( result, instanceOf( List.class ) );
	assertNotNull( result );
    }

    @Ignore @Test
    public void test02_writeMessage() {
	Guestbook guestbook = new Guestbook();
	guestbook.setName( "Tester" );
	guestbook.setContent( "abcdefg" );
	guestbook.setPassword( EncryptPassword.encrypt( "123" ) );
	guestbook.setRegDate( new Date() );
	assertTrue( "Falied to writeMessage()", guestbookService.writeMessage( guestbook ));
    }
    
    @Ignore @Test
    public void test03_deleteMessage() {
	Guestbook guestbook = new Guestbook();
	guestbook.setNo(5L);
	guestbook.setPassword("123");
	assertTrue("Failed to deleteMessage()", guestbookService.deleteMessage( guestbook ));
    }
}
