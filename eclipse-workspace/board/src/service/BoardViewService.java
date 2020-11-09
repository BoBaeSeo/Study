package service;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;
import static db.JdbcUtil.*;

public class BoardViewService {

	public BoardDTO boardView(int bNumber) {
		Connection con = getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		BoardDTO dto = dao.getBoardHit(bNumber);
		if(dto.getbNumber() != 0) {
			int bHits = dto.getbHits() + 1;
			dto.setbHits(bHits);
			int result = dao.updateHits(bHits, bNumber);
			if(result >  0) {
				commit(con);
			} else {
				rollback(con);
			}
		}
		close(con);
		return dto;
	}

}
