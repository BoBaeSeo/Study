package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberDTO;
import static db.JdbcUtil.*;

public class MemberListService {

	public ArrayList<MemberDTO> printList() {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		ArrayList<MemberDTO> memberList = dao.printList();
		close(con);
		return memberList;
	}

	
}
