package service;

import java.sql.Connection;

import dao.MemberDAO;
import static db.JdbcUtil.*;

public class MemberModifyService {

	public String checkPw(String userId, String checkPw) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		String checkUserId = dao.memberLogin(userId, checkPw);
		System.out.println(checkUserId);
		close(con);
		
		return checkUserId;
	}

	public boolean updateMember(String newName, String newEmail, String checkUserId) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int updateResult = dao.updateMember(newName, newEmail, checkUserId);
		boolean result = false;
		if(updateResult > 0) {
			commit(con);
			result = true;
		} else {
			rollback(con);
			result = false;
		}
		return result;
	}



}
