package dao;

import static db.jdbcUtil.close;

import java.sql.*;

import dto.MembersDTO;

public class MembersDAO {
	private static MembersDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private MembersDAO() {};
	public static MembersDAO getInstance() {
		if (dao==null) {
			dao = new MembersDAO();
		}
		return dao;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public MembersDTO Modify(String id) {
		String sql = "SELECT * FROM ME WHERE ID = ?";
		MembersDTO dto = new MembersDTO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setName(rs.getString(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setPhone(rs.getString(4));
				dto.setRank(rs.getString(5));
				dto.setBuy(rs.getInt(6));
				dto.setBirth(rs.getDate(7));
			}System.out.println(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return dto;
	}
	public MembersDTO MemberView(String id) {
		String sql = "SELECT * FROM ME WHERE ID = ?";
		MembersDTO dto = new MembersDTO();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setName(rs.getString(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setPhone(rs.getString(4));
				dto.setRank(rs.getString(5));
				dto.setBuy(rs.getInt(6));
				dto.setBirth(rs.getDate(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return dto;
	}
	public int ModifyUpdate(MembersDTO dto, String sId) {
		String sql = "UPDATE ME SET NAME = ?, ID = ?, PW = ?, PHONE = ?, BIRTH = ? WHERE ID = ?";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getPhone());
			pstmt.setDate(5, dto.getBirth());
			pstmt.setString(6, sId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public int MemberDelete(String idCode) {
		String sql = "DELETE FROM me WHERE MCODE=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idCode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public int TicketDelete(String idCode) {
		String sql = "DELETE FROM tk WHERE T_MCODE=?";
		int result = 0;
		System.out.println(idCode);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idCode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int CommentsDelete(String idCode) {
		String sql = "DELETE FROM cm WHERE C_MCODE = ?";
		int result = 0;
		System.out.println(idCode);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idCode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
