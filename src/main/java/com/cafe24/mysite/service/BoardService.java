package com.cafe24.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cafe24.mysite.domain.Board;
import com.cafe24.mysite.repository.BoardDAO;
import com.cafe24.mysite.repository.BoardRepository;
import com.cafe24.mysite.vo.BoardVO;

@Service
public class BoardService {
    @Autowired
    private BoardDAO boardDao;
    
    @Autowired
    private BoardRepository boardRepository;

    public Page<Board> getList( String keyword, Pageable pageable ) {
	Page<Board> boards = boardRepository.findAllByTitleContaining( keyword, pageable );
	return boards;
    }

    public BoardVO getPost( Long boardNo ) {
	return boardDao.read( boardNo );
    }

    public void updateHitCount( Long boardNo ) {
	boardDao.update( boardNo );
    }

    public void deletePost( Long boardNo ) {
	boardDao.delete( boardNo );
    }

    public BoardVO writePost( BoardVO vo ) {
	return boardDao.create( vo );
    }
    
    public BoardVO writeReply( BoardVO vo ) {
	vo.setOrderNo( vo.getOrderNo() + 1 );
	vo.setDepth( vo.getDepth() + 1 );
	return boardDao.create( vo );
    }

    public void updatePostOrder( BoardVO vo ) {
	Long groupNo = vo.getGroupNo();
	Long orderNo = vo.getOrderNo() + 1;
	boardDao.update( groupNo, orderNo);
    }

    public void modifyPost( BoardVO vo ) {
	boardDao.update( vo );
    }
}