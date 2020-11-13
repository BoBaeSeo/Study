package service;

import java.sql.Connection;

import static db.JdbcUtil.*;
import dao.MemberDAO;
import dto.MemberDTO;

public class MemberService {

	public String checkId(String uId) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		String resultMsg;
		String result = dao.checkId(uId);
		if(result == null) {
			resultMsg = "OK";
		} else {
			resultMsg = "NO";
		}
		close(con);
		return resultMsg;
	}

	public int memberJoinDB(MemberDTO dto) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		int result = dao.memberJoinDB(dto);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public String checkLogin(String userId, String userPw) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		String checkId = dao.checkId(userId, userPw);
		close(con);
		return checkId;
	}

	public MemberDTO getInfo(String sessionId) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		MemberDTO userInfo = dao.getInfo(sessionId);
		close(con);
		return userInfo;
	}

	public int modifyDB(String modId, MemberDTO modDto) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		int modResult = dao.modifyDB(modId, modDto);
		if(modResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return modResult;
	}

	public int delIdDB(String delId) {
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		int delResult = dao.delIdDB(delId);
		if(delResult > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return delResult;
	}

}
