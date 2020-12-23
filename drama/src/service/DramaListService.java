package service;

import static db.jdbcUtil.close;
import static db.jdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DramaListDAO;
import dto.DramaDTO;

public class DramaListService {

	public ArrayList<DramaDTO> DramaList() {
		DramaListDAO dao = DramaListDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		ArrayList<DramaDTO> DramaList = new ArrayList<DramaDTO>();
		DramaList = dao.dramaList();
		
		close(con);
		return DramaList;
	}

}
