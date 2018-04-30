package com.cafe24.mysite.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mysite.domain.Guestbook;
import com.cafe24.mysite.dto.JSONResult;
import com.cafe24.mysite.service.GuestbookService;

@Controller( "GuestbookAPIController" )
@RequestMapping( "/api/guestbook" )
public class GuestbookController {
    @Autowired
    private GuestbookService guestbookService;

    @ResponseBody
    @RequestMapping( "/list" )
    public JSONResult list( @RequestParam( value = "idx", required = true, defaultValue = "0L" ) Long no ) {
	List<Guestbook> list = guestbookService.getMessageList( no );
	return JSONResult.success( list );
    }

    @ResponseBody
    @RequestMapping( "/insert" )
    public JSONResult insert( @RequestBody Guestbook guestbook ) {
	Guestbook result = guestbookService.writeAPI( guestbook );
	if ( result == null ) {
	    return JSONResult.fail( "Failed to write" );
	}
	return JSONResult.success( result );
    }

    @ResponseBody
    @RequestMapping( "/delete" )
    public JSONResult delete( @ModelAttribute Guestbook vo ) {
	boolean result = guestbookService.deleteMessage( vo );
	return JSONResult.success( result ? vo.getNo() : -1 );
    }
}