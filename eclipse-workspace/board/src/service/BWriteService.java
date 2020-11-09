package service;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;
import static db.JdbcUtil.*;

public class BWriteService {

	public boolean bWriteDB(BoardDTO dto) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		int bNumber = dao.bNumber() + 1;
		dto.setbNumber(bNumber); 
		int resultDB = dao.bWriteDB(dto); 
		boolean result = false;
		if(resultDB > 0) {
			commit(con);
			result = true;
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

}
