package service;

import java.sql.Connection;

import dao.MemberDAO;
import static db.JdbcUtil.*;
public class MemberLoginService {

	public String loginDB(String userId, String userPw) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		String loginId = dao.loginDB(userId, userPw);
		close(con);
		return loginId;
	}

}
