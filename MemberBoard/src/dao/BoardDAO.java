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
		String sql = "SELECT * FROM BOARDS WHERE BWRITER=? ORDER BY BNUMBER";
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

	public BoardDTO boardView(int bNumber) {
		String sql = "SELECT * FROM BOARDS WHERE BNUMBER=?";
		BoardDTO boardView = new BoardDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardView.setbNumber(rs.getInt(1));
				boardView.setbWriter(rs.getNString(2));
				boardView.setbPassword(rs.getNString(3));
				boardView.setbTitle(rs.getNString(4));
				boardView.setbContents(rs.getNString(5));
				boardView.setbDate(rs.getDate(6));
				boardView.setbHits(rs.getInt(7));
				boardView.setbFile(rs.getNString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return boardView;
	}

	public int updateHits(int bNumber) {
		String sql = "UPDATE BOARDS SET BHITS=BHITS+1 WHERE BNUMBER=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int boardDel(int bNumber) {
		String sql = "DELETE FROM BOARDS WHERE BNUMBER=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public BoardDTO boardModify(int bNumber) {
		String sql = "SELECT * FROM BOARDS WHERE BNUMBER=?";
		BoardDTO dto = new BoardDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setbNumber(rs.getInt(1));
				dto.setbWriter(rs.getNString(2));
				dto.setbPassword(rs.getNString(3));
				dto.setbTitle(rs.getNString(4));
				dto.setbContents(rs.getNString(5));
				dto.setbDate(rs.getDate(6));
				dto.setbHits(rs.getInt(7));
				dto.setbFile(rs.getNString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return dto;
	}

	public int boardUpdate(BoardDTO changeDTO) {
		String sql = "UPDATE BOARDS SET BTITLE=?, BCONTENTS=?, BFILE=? WHERE BNUMBER=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, changeDTO.getbTitle());
			pstmt.setNString(2, changeDTO.getbContents());
			pstmt.setString(3, changeDTO.getbFile());
			pstmt.setInt(4, changeDTO.getbNumber());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public String getBFile(int bNumber) {
		String sql = "SELECT BFILE FROM BOARDS WHERE BNUMBER=?";
		String delBFile = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNumber);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				delBFile = rs.getNString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return delBFile;
	}

}
