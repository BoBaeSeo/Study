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

	public BoardDTO boardView(int bNumber) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		int hits = dao.updateHits(bNumber);
		if(hits > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		BoardDTO boardView =  dao.boardView(bNumber);
		String content = boardView.getbContents();
		content = content.replaceAll("\r\n", "<br>");
		boardView.setbContents(content);
		close(con);
		return boardView;
	}

	public int boardDel(int bNumber) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		int result = dao.boardDel(bNumber);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public BoardDTO boardModify(int bNumber) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		BoardDTO modifyDTO = dao.boardModify(bNumber);
		close(con);
		return modifyDTO;
	}

	public int boardUpdate(BoardDTO changeDTO) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		int result = dao.boardUpdate(changeDTO);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public String getBFile(int bNumber) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		String delFile = dao.getBFile(bNumber);
		close(con);
		return delFile;
	}


}
