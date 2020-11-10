package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dto.BoardDTO;
import static db.JdbcUtil.*;

public class BoardService {

	public ArrayList<BoardDTO> boardList() {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		ArrayList<BoardDTO> boardList = dao.boardList();
		close(con);
		return boardList;
	}

	public int boardWriteDB(BoardDTO contents) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		contents.setbNumber(dao.getBNumber());
		int result = dao.boardWriteDB(contents);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public ArrayList<BoardDTO> getWriteList(String userId) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		ArrayList<BoardDTO> writeList = dao.getWriteList(userId);
		close(con);
		return writeList;
	}

}
