package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.InfoDTO;
import dto.MembersDTO;
import static db.jdbcUtil.*;

public class TicketListDAO {

	static TicketListDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	public static TicketListDAO getInstance() {
		if(dao == null) {
			dao = new TicketListDAO();
		}
		return dao;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public String getMCode() {
		String sql = "SELECT nvl(max(MCODE),0)+1 FROM ME";
		String mCode = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mCode =rs.getString(1);
			}
			System.out.println("mcode = "+ mCode);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return mCode;
	}
	public int insertMemDB(MembersDTO dto) {
		String sql = "INSERT INTO ME VALUES(?,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, dto.getName());
			pstmt.setNString(2, dto.getId());
			pstmt.setString(3, dto.getPw());
			pstmt.setNString(4, dto.getPhone());
			pstmt.setNString(5, dto.getRank());
			pstmt.setInt(6, dto.getBuy());
			pstmt.setDate(7, dto.getBirth());
			pstmt.setNString(8, dto.getMcode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public String checkId(String uId) {
		String sql = "SELECT ID FROM ME WHERE ID = ?";
		String checkId = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, uId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				checkId = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return checkId;
	}
	public ArrayList<InfoDTO> getInfo(String userId) {
		String sql1 = "SELECT MCODE, PW FROM ME WHERE ID=?";
		String sql2 = "SELECT * FROM DR, TK WHERE DCODE=T_DCODE AND T_MCODE=? order by tcode";
		ArrayList<InfoDTO> getInfo = new ArrayList<InfoDTO>();
		InfoDTO dto = null;
		String mCode = null;
		String mPw = null;
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setNString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mCode = rs.getNString(1);
				mPw = rs.getNString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.setNString(1, mCode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new InfoDTO();
				dto.setDname(rs.getNString("DNAME"));
				dto.setDirector(rs.getNString("DIRECTOR"));
				dto.setGenre(rs.getNString("GENRE"));
				dto.setBuyDate(rs.getDate("BUYDATE"));
				dto.setPrice(rs.getInt("PRICE"));
				dto.setShowdate(rs.getDate("SHOWDATE"));
				dto.setFiles(rs.getNString("FILES"));
				dto.setMcode(rs.getNString("T_MCODE"));
				dto.setDcode(rs.getNString("T_DCODE"));
				dto.setTcode(rs.getInt("TCODE"));
				dto.setTnum(rs.getInt("TNUM"));
				dto.setPw(mPw);
				getInfo.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return getInfo;
	}
	public InfoDTO viewInfo(String tcode) {
		String sql = "SELECT * FROM ME, DR, TK WHERE DCODE=T_DCODE AND MCODE=T_MCODE AND TCODE=?";
		InfoDTO info = new InfoDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tcode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				info.setName(rs.getNString("NAME"));
				info.setId(rs.getString("ID"));
				info.setPw(rs.getString("PW"));
				info.setPhone(rs.getString("PHONE"));
				info.setDname(rs.getNString("DNAME"));
				info.setDirector(rs.getNString("DIRECTOR"));
				info.setGenre(rs.getNString("GENRE"));
				info.setRuntime(rs.getInt("RUNTIME"));
				info.setPrice(rs.getInt("PRICE"));
				info.setShowdate(rs.getDate("SHOWDATE"));
				info.setFiles("FILES");
				info.setTnum(rs.getInt("TNUM"));
				info.setTcode(rs.getInt("TCODE"));
				info.setBuyDate(rs.getDate("BUYDATE"));
				info.setDcode(rs.getString("DCODE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return info;
	}

	public int cancelDrama(String tcode) {
		String sql = "DELETE FROM TK WHERE TCODE=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, tcode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int updatebuy(int price,String id) {
		String sql = "UPDATE ME SET BUY=BUY-? WHERE ID=?";
		int result = 0;
		try {
			System.out.println("price");
			System.out.println(id);
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int getPrcie(String tcode) {
		int price = 0;
		String sql ="SELECT PRICE FROM DR WHERE DCODE = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tcode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				price = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return price;
	}
	public int getTotalPrice(String id) {
		String sql = "SELECT BUY FROM ME WHERE id =?";
		int result = 0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return result;
	}
	public int RankUpdate(String rank, String id) {
		String sql = "UPDATE ME SET RANK =? WHERE id=?";
		int result = 0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, rank);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	
}
