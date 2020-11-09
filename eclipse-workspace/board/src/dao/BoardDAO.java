package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BoardDTO;
import static db.JdbcUtil.*;

public class BoardDAO {
	
	private static BoardDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private BoardDAO() {};
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public int bNumber() {
		String sql = "SELECT COUNT(BNUMBER) FROM BOARDS";
		int number = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				number = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return number;
	}
	public int bWriteDB(BoardDTO dto) {
		String sql = "INSERT INTO BOARDS VALUES(?,?,?,?,?,SYSDATE,0)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getbNumber());
			pstmt.setNString(2, dto.getbWriter());
			pstmt.setNString(3, dto.getbPassword());
			pstmt.setNString(4, dto.getbTitle());
			pstmt.setNString(5, dto.getbContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			close(pstmt);
		}
		return result;
	}
	public ArrayList<BoardDTO> viewBoard() {
		String sql = "SELECT * FROM BOARDS";
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO dto = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new BoardDTO();
				dto.setbNumber(rs.getInt(1));
				dto.setbWriter(rs.getNString(2));
				dto.setbTitle(rs.getNString(4));
				dto.setbDate(rs.getDate(6));
				dto.setbHits(rs.getInt(7));
				boardList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			close(pstmt);
			close(rs);
		}
		return boardList;
	}
	public BoardDTO getBoardHit(int bNumber) {
		String sql = "SELECT * FROM BOARDS WHERE BNUMBER=?";
		BoardDTO dto = new BoardDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setbNumber(rs.getInt(1));
				dto.setbWriter(rs.getNString(2));
				dto.setbTitle(rs.getNString(4));
				dto.setbContents(rs.getNString(5));
				dto.setbHits(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			close(pstmt);
			close(rs);
		}
		return dto;
	}
	public int updateHits(int bHits, int bNumber) {
		String sql = "UPDATE BOARDS SET BHITS=? WHERE BNUMBER=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bHits);
			pstmt.setInt(2, bNumber);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			close(pstmt);
		}
		return result;
	}
	public BoardDTO selBoard(int bNumber) {
		String sql = "SELECT * FROM BOARDS WHERE BNUMBER=?";
		BoardDTO dto = new BoardDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setbNumber(rs.getInt(1));
				dto.setbWriter(rs.getNString(2));
				dto.setbPassword(rs.getNString(3));
				dto.setbTitle(rs.getNString(4));
				dto.setbContents(rs.getNString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			close(pstmt);
			close(rs);
		}
		return dto;
	}

}
