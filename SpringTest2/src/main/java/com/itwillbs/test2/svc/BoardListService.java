package com.itwillbs.test2.svc;

import java.sql.Connection;
import java.util.List;

import com.itwillbs.test2.dao.BoardDAO;
import com.itwillbs.test2.db.JdbcUtil;
import com.itwillbs.test2.vo.BoardBean;

public class BoardListService {

	// 글목록 조회 요청
	// => 파라미터 : 시작행번호, 목록갯수   리턴타입 : java.util.List<BoardBean>(boardList)
	public List<BoardBean> getBoardList(int startRow, int listLimit) {
		List<BoardBean> boardList = null;
		
		Connection con = JdbcUtil.getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		// BoardDAO - selectBoardList() 메서드 호출하여 글목록 조회 작업 요청
		// => 파라미터 : 없음   리턴타입 : java.util.List<BoardBean>(boardList)
		boardList = dao.selectBoardList(startRow, listLimit);
		
		JdbcUtil.close(con);
		
		return boardList;
	}

	// 전체 게시물 수 조회 요청
	public int getBoardListCount() {
		int listCount = 0;
		
		Connection con = JdbcUtil.getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		// BoardDAO - selectBoardListCount() 메서드 호출하여 글목록 조회 작업 요청
		// => 파라미터 : 없음   리턴타입 : int(listCount)
		listCount = dao.selectBoardListCount();
		
		JdbcUtil.close(con);
		
		return listCount;
	}

}
