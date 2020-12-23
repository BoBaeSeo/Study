package service;

import dto.InfoDTO;
import dto.MembersDTO;

import static db.jdbcUtil.*;

import java.sql.Connection;

import dao.TicketCheckDAO;
public class TicketCheckService {

	public InfoDTO selectCheck(String idcode) {
		TicketCheckDAO dao=TicketCheckDAO.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		InfoDTO dto=new InfoDTO();
		dto=dao.selectCheck(idcode);//이름,생년월일 받아옴
		System.out.println("sel1");
		close(con);
		return dto;
	}

	public InfoDTO selectCheckDrama(String dcode, int tnum) {
		TicketCheckDAO dao=TicketCheckDAO.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		InfoDTO dto=new InfoDTO();
		dto=dao.selectCheckDrama(dcode,tnum);
	
		
		System.out.println("sel2");
		close(con);
		return dto;
	}


	public int InsertCheckTicket(int Checktnum,String checktmcode, String checktdcode) {
		TicketCheckDAO dao=TicketCheckDAO.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		int TnumCode=dao.TnumSelect();
		int result=dao.InsertCheck(Checktnum,checktmcode,checktdcode,TnumCode);	//티켓테이블추가
		String Rank = "D";
		System.out.println("result:::"+result);
		System.out.println("티켓번호 : "+TnumCode); //티켓코드
		commit(con);
		int tnum = Checktnum;
		int price  = dao.getPrcie(checktdcode);// 티켓의 번호를 가지고 검색 
		price = price *tnum;
		System.out.println("구매한 금액 : "+price);
		int check =  dao.buyUpdate(price,checktmcode); // 업데이트
		int totalprcie = dao.gettotalPrice(checktmcode); // 셀렉트
		System.out.println("총금액 : "+totalprcie);
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
		}
		System.out.println("받은 랭크 : "+Rank);
		int check2 = dao.buyRank(checktmcode, Rank); //업데이트3
		
		System.out.println(result + " " + check +" "+check2);
		
		if(result>0 && check>0 && check2>0) {
			commit(con);
			System.out.println("커밋실행");
		}else{
			rollback(con);
		}
			
			
		close(con);
		return result;
	}




//	public InfoDTO updateChecktnum(String dcode) {
//		TicketCheckDAO dao=TicketCheckDAO.getInstance();
//		Connection con=getConnection();
//		dao.setConnection(con);
//		InfoDTO dto=new InfoDTO();
//	dto=dao.UpdateCheckprice(dcode);
//	return dto;
//	}
	//혹시모르니깐 나둠

}
