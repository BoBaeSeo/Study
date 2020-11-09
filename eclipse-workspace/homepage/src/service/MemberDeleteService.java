package service;

import java.sql.Connection;

import dao.MemberDAO;
import static db.JdbcUtil.*;

public class MemberDeleteService {

	public boolean memberDelete(String userId) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		int delete = dao.memberDelete(userId);
		boolean result = false;
		if(delete > 0) {
			commit(con);
			result = true;
		} else {
			rollback(con);
			result = false;
		}
		return result;
	}

}
