package service;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;
import static db.JdbcUtil.*;

public class MemberModifyService {

	public MemberDTO modifyMember(String userId) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		MemberDTO member = dao.modifyMember(userId);
		close(con);
		return member;
	}

	public Boolean checkUserPw(String userPw) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		boolean result = dao.checkUserPw(userPw);
		close(con);
		return result;
	}

	public boolean modifyInfo(String userName, String userEmail, String userPw) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		int modifyResult = dao.modifyInfo(userName, userEmail, userPw);
		boolean result = false;
		if(modifyResult > 0) {
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
