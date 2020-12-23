package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static db.jdbcUtil.close;
import dto.DramaDTO;

public class DramaDAO {
	private static DramaDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private DramaDAO() {};
	public static DramaDAO getInstance() {
		if (dao==null) {
			dao = new DramaDAO();
		}
		return dao;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public String Search(String dname) {
		System.out.println(dname);
		String sql = "SELECT * FROM DR WHERE DNAME LIKE ?";
		String result = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"%"+dname+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println(result);
		return result;
	}
	
	
	
	
	
	
	
	
}
