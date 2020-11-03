package service;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;
import static db.JdbcUtil.*;

public class MemberDeleteService {

	public MemberDTO memberModify(String userId) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		MemberDTO memberModify = new MemberDTO();
		memberModify = dao.memberViewDB(userId);
		return memberModify;
	}

	
}
