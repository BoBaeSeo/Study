package service;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;
import static db.JdbcUtil.*;

public class MemberJoinService {

	public boolean memberJoin(MemberDTO member) {
		
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		boolean insertResult;
		int result = dao.memberJoin(member);
		if(result > 0) {
			commit(con);
			insertResult = true;
		} else {
			rollback(con);
			insertResult = false;
		}
		close(con);
		return insertResult;
	}

}
