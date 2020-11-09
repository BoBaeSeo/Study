package service;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;
import static db.JdbcUtil.*;

public class MemberJoinService {

	public boolean memberJoinDB(MemberDTO member) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		int check = dao.memberJoinDB(member);
		boolean result = false;
		if(check > 0) {
			commit(con);
			result = true;
		} else {
			rollback(con);
			result = false;
		}
		close(con);
		return result;
	}

}
