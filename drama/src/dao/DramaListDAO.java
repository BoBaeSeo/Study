package dao;

import static db.jdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.DramaDTO;

public class DramaListDAO {
	private static DramaListDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private DramaListDAO() {};
	public static DramaListDAO getInstance() {
		if (dao==null) {
			dao = new DramaListDAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;		
	}

	public ArrayList<DramaDTO> dramaList() {
		String sql = "SELECT * FROM DR ORDER BY HITS DESC";
		ArrayList<DramaDTO> DramaList = new ArrayList<DramaDTO>();
		DramaDTO drama = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				drama = new DramaDTO();
				drama.setDcode(rs.getString(1));
				drama.setDname(rs.getString(2));
				drama.setDirector(rs.getString(3));
				drama.setGenre(rs.getString(4));
				drama.setRuntime(rs.getInt(5));
				drama.setAge(rs.getInt(6));
				drama.setPrice(rs.getInt(7));
				drama.setHits(rs.getInt(9));
				drama.setFiles(rs.getString(11));
				DramaList.add(drama);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return DramaList;
	}

}
