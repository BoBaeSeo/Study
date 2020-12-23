package service;

import java.sql.*;
import static db.jdbcUtil.*;
import dao.DramaDAO;
import dto.DramaDTO;

public class DramaService {

	public String Search(String dname) {
		DramaDAO dao = DramaDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		String result = dao.Search(dname);
		close(con);
		return result;
	}

}
