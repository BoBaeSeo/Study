package service;

import static db.jdbcUtil.*;
import dao.MembersDAO;
import dto.MembersDTO;
import java.sql.*;

public class MemberViewService {

	public MembersDTO MemberView(String id) {
		MembersDAO dao = MembersDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		MembersDTO dto = dao.MemberView(id);
		
		close(con);
		return dto;
	}

}
