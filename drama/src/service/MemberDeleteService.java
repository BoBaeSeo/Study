package service;

import java.sql.*;
import static db.jdbcUtil.*;
import dao.MembersDAO;

public class MemberDeleteService {

	public int MemberDelete(String idCode) {
		MembersDAO dao = MembersDAO.getInstance();
		Connection con = getConnection(); 
		dao.setConnection(con);
		
		int result3 = dao.CommentsDelete(idCode);
		
		if(result3>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		int result2 = dao.TicketDelete(idCode);
		if(result2>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		int result = dao.MemberDelete(idCode);
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

		

}
