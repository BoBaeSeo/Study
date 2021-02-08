package service;

import java.sql.Connection;

import static db.JdbcUtil.*;
import dao.MembersDAO;
import dto.MembersDTO;

public class MembersService {

	public int memberJoin(MembersDTO memberDTO) {
		Connection con = getConnection();
		MembersDAO dao = MembersDAO.getInstance();
		dao.setConnection(con);
		int userNum = dao.getUserNum();
		memberDTO.setUsernum(userNum);
		int insertResult = dao.memberJoin(memberDTO);
		if(insertResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return insertResult;
	}

	public String memberLogin(String checkId, String checkPw) {
		Connection con = getConnection();
		MembersDAO dao = MembersDAO.getInstance();
		dao.setConnection(con);
		String loginId = dao.memberLogin(checkId, checkPw);
		close(con);
		return loginId;
	}

	public MembersDTO memberInfo(String userId) {
		Connection con = getConnection();
		MembersDAO dao = MembersDAO.getInstance();
		dao.setConnection(con);
		MembersDTO memberDTO = dao.memberInfo(userId);
		close(con);
		return memberDTO;
	}

	public int memberModify(MembersDTO memberDTO) {
		Connection con = getConnection();
		MembersDAO dao = MembersDAO.getInstance();
		dao.setConnection(con);
		int modifyResult = dao.memberModify(memberDTO);
		if(modifyResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return modifyResult;
	}

	public String checkId(String userId) {
		Connection con = getConnection();
		MembersDAO dao = MembersDAO.getInstance();
		dao.setConnection(con);
		String checkUserId = dao.checkId(userId);
		String checkResult = "NO";
		if(checkUserId == null) {
			checkResult = "OK";
		}
		close(con);
		return checkResult;
	}

}
