package service;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberListService {

	public ArrayList<MemberDTO> printList() {
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		memberList = dao.printList();
		close(con);
		return memberList;
	}

	public MemberDTO memberViewDB(String userId) {
		MemberDTO member = new MemberDTO();
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		member = dao.memberViewDB(userId);
		close(con);
		return member;
	}

	public int memberDeleteDB(String userId) {
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int deleteResult = dao.memberDeleteDB(userId);
		if(deleteResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return deleteResult;
	}

}
