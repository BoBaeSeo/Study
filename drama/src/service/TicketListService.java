package service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import dao.TicketListDAO;
import dto.InfoDTO;
import dto.MembersDTO;
import static db.jdbcUtil.*;

public class TicketListService {

	public int insertMemDB(MembersDTO dto) {
		Connection con = getConnection();
		TicketListDAO dao = TicketListDAO.getInstance();
		dao.setConnection(con);
		String mCode = dao.getMCode();
		dto.setMcode(mCode);
		int result = dao.insertMemDB(dto);
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public String checkId(String uId) {
		Connection con = getConnection();
		TicketListDAO dao = TicketListDAO.getInstance();
		dao.setConnection(con);
		String result = dao.checkId(uId);
		String resultMsg = null;
		if(result == null) {
			resultMsg = "OK";
		} else {
			resultMsg = "NO";
		}
		close(con);
		return resultMsg;
	}

	public ArrayList<InfoDTO> getInfo(String userId) {
		Connection con = getConnection();
		TicketListDAO dao = TicketListDAO.getInstance();
		dao.setConnection(con);
		ArrayList<InfoDTO> getTKtable = dao.getInfo(userId);
		close(con);
		return getTKtable;
	}

	public InfoDTO viewInfo(String tcode) {
		Connection con = getConnection();
		TicketListDAO dao = TicketListDAO.getInstance();
		dao.setConnection(con);
		InfoDTO info = dao.viewInfo(tcode);
		close(con);
		return info;
	}

	public int cancelDrama(String tcode, int tnum1, String id, String dcode) {
		Connection con = getConnection();
		TicketListDAO dao = TicketListDAO.getInstance();
		dao.setConnection(con);
		int tnum = tnum1;
		int price = dao.getPrcie(dcode);	//구매 금액
		price = price * tnum;
		System.out.println("총 구매금액"+price);
		
		int result = dao.cancelDrama(tcode); //티켓정보삭제
		System.out.println("result"+result);
		
		int result2 = dao.updatebuy(price,id); // 구매금액 빠짐
		System.out.println("회원정보 : " +result2); 
		
		int totalprcie = dao.getTotalPrice(id);//총금액 다시 조회 select
		String Rank = "D";
		if(totalprcie>=200000) {
			Rank="S";
		}else if(totalprcie>=120000) {
			Rank="A";
		}else if(totalprcie>=70000) {
			Rank="B";
		}else if(totalprcie>=20000) {
			Rank="C";
		}else{
			Rank="D";
		}//해당하는거에 맞는 랭크로줌
		int result3 = dao.RankUpdate(Rank,id);//랭크로업데이트
		
		if(result > 0 && result2>0 && result3>0) {
			commit(con);
		}else {
			rollback(con);	
		}

		close(con);
		return result;
	}




}
