package service;

import static db.jdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DAO;
import dto.CommentsDTO;
import dto.DramaDTO;
public class service {

	public DramaDTO DramaView(String dcode) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con); // 접속
		int result = dao.Dramahti(dcode);
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		DramaDTO DramaDTO = dao.DramaView(dcode); 
		close(con);
		return DramaDTO;
	}

	public ArrayList<CommentsDTO> commentsList(String dcode) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		ArrayList<CommentsDTO> list = dao.commentsList(dcode);
		close(con);
		return list;
	}

	public float grade(String dcode) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		float grade = dao.grade(dcode);
		close(con);
		return grade;
	}

	public boolean Comments(CommentsDTO commentsDTO) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int ccode = dao.ccode()+1;

		commentsDTO.setCcode(ccode);
		boolean check = dao.Comments(commentsDTO);
		if(check) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return check;
	}
	

}
