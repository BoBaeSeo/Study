package dao;
import static db.jdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.InfoDTO;
import dto.MembersDTO;

public class TicketCheckDAO {

	private static TicketCheckDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	private TicketCheckDAO() {};
	
	public static TicketCheckDAO getInstance() {
		if(dao==null) {
			dao=new TicketCheckDAO();
		}
		return dao;
	}	
public void setConnection(Connection con) {
	this.con=con;
}

public InfoDTO selectCheck(String idcode) {
       String sql="SELECT*FROM ME WHERE MCODE=?";
       InfoDTO dto=null;
       try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, idcode);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			dto=new InfoDTO();
			dto.setName(rs.getString("NAME"));
			dto.setPhone(rs.getString("PHONE"));
            dto.setMcode(rs.getString("MCODE"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(pstmt);
		close(rs);
	}

	return dto;
}

public InfoDTO selectCheckDrama(String dcode, int tnum) {
//	String sql="SELECT DCODE,DNAME,DIRECTOR,GENRE,RUNTIME,AGE,PRICE,CONTENTS,HITS,SHOWDATE,FILES FROM DR WHERE DCODE=?";
	String sql="SELECT DCODE,DNAME,DIRECTOR,GENRE,RUNTIME,AGE,PRICE*?,CONTENTS,HITS,SHOWDATE,FILES FROM DR WHERE DCODE=?";
	InfoDTO dto=null;
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,tnum);
		pstmt.setString(2, dcode);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			dto=new InfoDTO();
			dto.setDcode(rs.getString(1));
			dto.setDname(rs.getString(2));
			dto.setDirector(rs.getString(3));
			dto.setGenre(rs.getString(4));
			dto.setRuntime(rs.getInt(5));
			dto.setAge(rs.getInt(6));
			dto.setPrice(rs.getInt(7));
			dto.setShowdate(rs.getDate(10));
			dto.setFiles(rs.getString(11));
	
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		close(pstmt);
		close(rs);
	}
	
	return dto;
}


//혹시모르니깐 나뚬
public InfoDTO UpdateCheckprice(String dcode) {
	String sql="SELECT *FROM DR WHERE DCODE=?";
	InfoDTO dto=null;
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, dcode);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			dto.setPrice(rs.getInt(7));
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		close(pstmt);
		close(rs);
	}
	
	return dto;
}

public int InsertCheck(int Checktnum,String checktmcode,String checktdcode, int TnumCode) {
	String sql="INSERT INTO TK VALUES(?,?,?,?,SYSDATE)";
	int result=0;
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,Checktnum);
		pstmt.setNString(2, checktmcode);
		pstmt.setNString(3, checktdcode);
		pstmt.setInt(4,TnumCode);
		result=pstmt.executeUpdate();
	
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	
	return result;
}

public int TnumSelect() {
	String sql="SELECT MAX(TCODE) FROM TK";
	int result=0;
    try {
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			result=rs.getInt(1)+1;
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}
	return result;
}

public int buyUpdate(int price,String checktmcode) {
	String sql = "UPDATE ME SET BUY =BUY+? WHERE MCODE=?";
	int result = 0;
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, price);
		pstmt.setString(2, checktmcode);
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
}

public int getPrcie(String checktdcode) {
	String sql = "SELECT PRICE FROM DR WHERE DCODE = ?";
	int price = 0;
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, checktdcode);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			price = rs.getInt(1);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		close(rs);
		close(pstmt);
	}
	return price;
}

public int gettotalPrice(String checktmcode) {
	String sql = "SELECT BUY FROM ME WHERE MCODE =?";
	int result = 0;
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, checktmcode);
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

public int buyRank(String checktmcode, String rank) {
	String sql = "UPDATE ME SET RANK =? WHERE MCODE=?";
	int result = 0;
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, rank);
		pstmt.setString(2, checktmcode);
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


