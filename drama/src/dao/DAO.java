package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import dto.CommentsDTO;
import dto.DramaDTO;

import static db.jdbcUtil.*;

public class DAO {
	private static DAO dao;
	static Connection con; 
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static DAO getInstance() {
		if (dao == null) {
			dao = new DAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) { 
		this.con =con; 
	}

	public int  Dramahti(String dcode) {
		String sql ="update dr set HITS = HITS+1 where DCODE = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dcode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public DramaDTO DramaView(String dcode) {
		String sql = "select * from dr where dcode = ?";
		DramaDTO info = new DramaDTO();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dcode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				info.setDcode(rs.getString(1));
				info.setDname(rs.getString(2));
				info.setDirector(rs.getString(3));
				info.setGenre(rs.getString(4));
				info.setRuntime(rs.getInt(5));
				info.setAge(rs.getInt(6));
				info.setPrice(rs.getInt(7));
				info.setContents(rs.getString(8));
				info.setHits(rs.getInt(9));
				info.setShowdate(rs.getDate(10));
				System.out.println(rs.getDate(10));
				info.setFiles(rs.getString(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return info;
	}

	public ArrayList<CommentsDTO> commentsList(String dcode) {
		String sql = "SELECT M.MCODE,D.DCODE,C.COMMENTS,C.GRADE,C.CCODE,C.CPW \r\n" + 
				"FROM ME M INNER JOIN CM C ON M.MCODE = C.C_MCODE INNER JOIN DR D ON D.DCODE = C.C_DCODE\r\n" + 
				"WHERE DCODE = ?";
		ArrayList<CommentsDTO> list = new ArrayList<CommentsDTO>();
		CommentsDTO info = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dcode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				info = new CommentsDTO();
				info.setC_mcode(rs.getString(1));
				info.setC_dcode(rs.getString(2));
				info.setComments(rs.getString(3));
				info.setGrade(rs.getFloat(4));
				info.setCcode(rs.getInt(5));
				info.setCpw(rs.getString(6));
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public float grade(String dcode) {
		String sql = "SELECT ROUND(AVG(GRADE),1) FROM CM WHERE C_DCODE =?";
		float grade = 0.0f;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dcode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				grade = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return grade;
	}

	public int ccode() {
		String sql = "SELECT max(ccode) FROM cm";
		int ccode = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ccode = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return ccode;
	}

	public boolean Comments(CommentsDTO commentsDTO) {
		String sql = "insert into cm values(?,?,?,?,?,?)";
		int result = 0;
		boolean check = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, commentsDTO.getC_mcode());
			pstmt.setString(2, commentsDTO.getC_dcode());
			pstmt.setString(3, commentsDTO.getComments());
			pstmt.setFloat(4, commentsDTO.getGrade());
			pstmt.setInt(5, commentsDTO.getCcode());
			pstmt.setString(6, commentsDTO.getCpw());
			result = pstmt.executeUpdate();
			if(result>0) {
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return check;
	}
	
	
	
	
	
	
}
