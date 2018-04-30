package com.cafe24.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.mysite.component.Pager;
import com.cafe24.mysite.domain.Board;
import com.cafe24.mysite.dto.BoardListDTO;
import com.cafe24.mysite.dto.CommentListDTO;
import com.cafe24.mysite.service.BoardService;
import com.cafe24.mysite.service.CommentService;
import com.cafe24.mysite.vo.BoardVO;

@Controller
@RequestMapping( "/board" )
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private Pager pager;

    @RequestMapping( value = "/list", method = RequestMethod.GET )
    public String list( @RequestParam( value = "k", required = false, defaultValue = "" ) String keyword, 
	    @PageableDefault(size=10, sort={"regDate"}, direction=Direction.DESC) Pageable pageable,
	    Model model ) {
//	pager.setPager( pageNo, keyword );

	Page<Board> posts = boardService.getList( keyword, pageable );
	model.addAttribute( "posts", posts );
	model.addAttribute( "keyword", keyword );
	return "board/list";
    }

//    @RequestMapping( value = "/list", method = RequestMethod.POST )
//    public String list( @RequestParam( "k" ) String keyword, Model model ) {
//	int pageNo = 1;
//	pager.setPager( pageNo, keyword );
//
//	List<BoardListDTO> list = boardService.getList( keyword, pager );
//	model.addAttribute( "pager", pager );
//	model.addAttribute( "list", list );
//	model.addAttribute( "keyword", keyword );
//	return "board/list";
//    }

   /* @RequestMapping( value = "/view/{pno}/{bno}", method = RequestMethod.GET )
    public String view( @PathVariable( "pno" ) int pageNo, @PathVariable( "bno" ) Long boardNo,
	    @RequestParam( "k" ) String keyword, Model model ) {
	boardService.updateHitCount( boardNo );
	BoardVO boardVo = boardService.getPost( boardNo );
	List<CommentListDTO> commentList = commentService.getList( boardNo );

	model.addAttribute( "commentList", commentList );
	model.addAttribute( "board", boardVo );
	model.addAttribute( "pageNo", pageNo );
	model.addAttribute( "boardNo", boardNo );
	model.addAttribute( "keyword", keyword );
	return "board/view";
    }

    @RequestMapping( value = "/delete/{pno}/{bno}", method = RequestMethod.GET )
    public String delete( @PathVariable( "pno" ) int pageNo, @PathVariable( "bno" ) Long boardNo,
	    @RequestParam( "k" ) String keyword ) {
	boardService.deletePost( boardNo );

	return "redirect:/board/list/" + pageNo + "?k=" + keyword;
    }

    @RequestMapping( value = "/write/{pno}", method = RequestMethod.GET )
    public String write( @PathVariable( "pno" ) int pageNo, @RequestParam( "k" ) String keyword, Model model ) {
	model.addAttribute( "pageNo", pageNo );
	model.addAttribute( "keyword", keyword );
	return "board/write";
    }

    @RequestMapping( value = "/write", method = RequestMethod.POST )
    public String write( @RequestParam( "p" ) int pageNo, @RequestParam( "k" ) String keyword,
	    @ModelAttribute BoardVO vo, HttpSession session, Model model ) {
	UserVO authUser = (UserVO) session.getAttribute( "authUser" );
	vo.setUserNo( authUser.getNo() );

	BoardVO boardVo = boardService.writePost( vo );

	model.addAttribute( "board", boardVo );
	model.addAttribute( "pageNo", pageNo );
	model.addAttribute( "keyword", keyword );
	return "board/confirm-view";
    }

    @RequestMapping( value = "/reply/{pno}/{bno}", method = RequestMethod.GET )
    public String reply( @PathVariable( "pno" ) int pageNo, @PathVariable( "bno" ) Long boardNo,
	    @RequestParam( "k" ) String keyword, Model model ) {

	BoardVO boardVo = boardService.getPost( boardNo );

	model.addAttribute( "pageNo", pageNo );
	model.addAttribute( "boardNo", boardNo );
	model.addAttribute( "keyword", keyword );
	model.addAttribute( "result", boardVo );
	return "board/reply";
    }

    @RequestMapping( value = "/reply", method = RequestMethod.POST )
    public String reply( @RequestParam( "p" ) int pageNo, @RequestParam( "k" ) String keyword,
	    @ModelAttribute BoardVO vo, HttpSession session, Model model ) {

	UserVO authUser = (UserVO) session.getAttribute( "authUser" );
	vo.setUserNo( authUser.getNo() );

	boardService.updatePostOrder( vo );
	BoardVO boardVo = boardService.writePost( vo );

	return "redirect:/board/view/" + pageNo + "/" + boardVo.getNo() + "?k=" + keyword;
    }

    @RequestMapping( value = "/modify/{pno}/{bno}", method = RequestMethod.GET )
    public String modify( @PathVariable( "pno" ) int pageNo, @PathVariable( "bno" ) Long boardNo,
	    @RequestParam( "k" ) String keyword, Model model ) {
	BoardVO boardVo = boardService.getPost( boardNo );
	model.addAttribute( "result", boardVo );
	model.addAttribute( "pageNo", pageNo );
	model.addAttribute( "keyword", keyword );

	return "board/modify";
    }

    @RequestMapping( value = "/modify", method = RequestMethod.POST )
    public String modify( @ModelAttribute BoardVO vo, @RequestParam( "pno" ) int pageNo,
	    @RequestParam( "k" ) String keyword, Model model ) {
	boardService.modifyPost( vo );
	model.addAttribute( "pageNo", pageNo );
	model.addAttribute( "keyword", keyword );

	return "redirect:/board/view/" + pageNo + "/" + vo.getNo() + "?k=" + keyword;
    }*/
}
