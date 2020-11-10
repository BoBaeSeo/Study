package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BoardDTO;
import static db.JdbcUtil.*;

public class BoardDAO {

	static BoardDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public int getBNumber() {
		String sql = "SELECT MAX(BNUMBER) FROM BOARDS";
		int bNumber = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bNumber = rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return bNumber;
	}

	public ArrayList<BoardDTO> boardList() {
		String sql = "SELECT * FROM BOARDS";
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO dto = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new BoardDTO();
				dto.setbNumber(rs.getInt(1));
				dto.setbWriter(rs.getString(2));
				dto.setbTitle(rs.getNString(4));
				dto.setbDate(rs.getDate(6));
				dto.setbHits(rs.getInt(7));
				dto.setbFile(rs.getNString(8));
				boardList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return boardList;
	}

	public int boardWriteDB(BoardDTO contents) {
		String sql = "INSERT INTO BOARDS VALUES(?,?,?,?,?,SYSDATE,0,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, contents.getbNumber());
			pstmt.setNString(2, contents.getbWriter());
			pstmt.setNString(3, contents.getbPassword());
			pstmt.setString(4, contents.getbTitle());
			pstmt.setString(5, contents.getbContents());
			pstmt.setString(6, contents.getbFile());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<BoardDTO> getWriteList(String userId) {
		String sql = "SELECT * FROM BOARDS WHERE BWRITER=?";
		ArrayList<BoardDTO> writeList = new ArrayList<BoardDTO>();
		BoardDTO write = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				write = new BoardDTO();
				write.setbNumber(rs.getInt(1));
				write.setbWriter(rs.getString(2));
				write.setbTitle(rs.getNString(4));
				write.setbDate(rs.getDate(6));
				write.setbHits(rs.getInt(7));
				write.setbFile(rs.getNString(8));
				writeList.add(write);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return writeList;
	}
}
