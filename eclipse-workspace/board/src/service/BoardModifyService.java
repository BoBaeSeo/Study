package service;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardModifyService {

	public BoardDTO selBoard(int bNumber) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		BoardDTO dto = dao.selBoard(bNumber);
		return dto;
	}

}
