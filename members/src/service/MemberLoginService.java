package service;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;

public class MemberLoginService {

	Connection con;
	public String memberLogin(String userId, String userPw) {
		
		MemberDAO dao = MemberDAO.getInstance();
		con = getConnection();
		dao.setConnection(con);
		
		String loginId = dao.memberLogin(userId, userPw);
		
		close(con);
		return loginId;
	}
	
	
}
