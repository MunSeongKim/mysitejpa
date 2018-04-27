package com.cafe24.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.mysite.domain.Guestbook;
import com.cafe24.mysite.service.GuestbookService;

@Controller
@RequestMapping( "/guestbook" )
public class GuestbookController {
    @Autowired
    private GuestbookService guestbookService;
    
    
    @RequestMapping( "/list" )
    public String list( Model model ) {
	List<Guestbook> list = guestbookService.getMessageList();
	model.addAttribute( "list", list );
	return "guestbook/list";
    }

    @RequestMapping( value = "/write", method = RequestMethod.POST )
    public String write( @ModelAttribute Guestbook guestbook ) {
	guestbookService.writeMessage( guestbook );
	return "redirect:/guestbook/list";
    }

    @RequestMapping( value = "/delete/{no}", method = RequestMethod.GET )
    public String delete( @PathVariable Long no, Model model ) {
	model.addAttribute( "no", no );
	return "guestbook/delete";
    }

    @RequestMapping( value = "/delete", method = RequestMethod.POST )
    public String delete( @ModelAttribute Guestbook guestbook ) {
	System.out.println( guestbook );
	guestbookService.deleteMessage( guestbook );
	return "redirect:/guestbook/list";
    }
    
    @RequestMapping( value = "/ajax", method = RequestMethod.GET )
    public String ajax( Model model ) {
	/*final Long initIndex = 0L;
	List<Guestbook> list = gbService.getList(initIndex);
	model.addAttribute( "list", list );*/
	return "guestbook/index-ajax";
    }

}
