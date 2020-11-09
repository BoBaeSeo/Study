package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dto.BoardDTO;
import static db.JdbcUtil.*;

public class BoardListService {

	public ArrayList<BoardDTO> viewBoard() {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		boardList = dao.viewBoard();
		close(con);
		return boardList;
	}

}
