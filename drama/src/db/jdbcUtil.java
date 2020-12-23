package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class jdbcUtil {

	public static Connection getConnection() {
		Connection con=null;
		try {
			Context initCtx = new InitialContext(); //초기설정값
			Context envCtx=(Context)initCtx.lookup("java:comp/env"); //경로 찾아가는 지정
			DataSource ds=(DataSource) envCtx.lookup("jdbc/OracleDB");// 지정값 context 과 동일한 이름
			
			con=ds.getConnection(); //연결
			con.setAutoCommit(false);  //자동커밋x
			System.out.println("DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
		public static void close(Connection con) {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		public static void commit(Connection con) {
			try {
				con.commit();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void rollback(Connection con) {
			try {
				con.rollback();
			}catch(Exception e) {
				
				e.printStackTrace();
				
				
			}
		}
	
}
