package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.InfoDTO;
import dto.MembersDTO;
import service.TicketCheckService;

/**
 * Servlet implementation class TicketCheckController
 */
@WebServlet({ "/TicketCheck", "/TicketCheckProcess" })
public class TicketCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TicketCheckController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		InfoDTO infodto = new InfoDTO();
		InfoDTO infodto2 = new InfoDTO();
		InfoDTO infodto3 = new InfoDTO();
		TicketCheckService svc = new TicketCheckService();
		System.out.println(request.getServletPath());
		switch (request.getServletPath()) {
		case "/TicketCheck":
			System.out.println("티켓쳌크");
			String idcode = (String) session.getAttribute("idCode") ;
			System.out.println("이름코드:"+idcode);
			 String dcode=request.getParameter("dcode");//연극코드
			 System.out.println("dcode : "+dcode);
			 int tnum=Integer.parseInt(request.getParameter("tnum"));//티켓장수
		
			// infodto=svc.updateChecktnum(dcode);//매수,가격
			infodto2 = svc.selectCheck(idcode); // 이름,핸드폰번호
			infodto3 = svc.selectCheckDrama(dcode,tnum);// 연극이름,감독이름,장르,가격,매수,상영하는날짜(시간),파일

			// 매수
            request.setAttribute("Tnum", tnum);
			request.setAttribute("memberDTO", infodto2);
			request.setAttribute("dramaDTO", infodto3);

			RequestDispatcher dispatcher = request.getRequestDispatcher("TicketCheck.jsp");
			dispatcher.forward(request, response);

			break;

		// 가격

		case "/TicketCheckProcess":
           
			int Checktnum = Integer.parseInt(request.getParameter("tnum"));
			String Checktmcode = request.getParameter("mcode"); //회원코드
			String Checktdcode = request.getParameter("dcode"); // 드라마코드
			int result = svc.InsertCheckTicket(Checktnum,Checktmcode, Checktdcode); //회원정보수정포함(구매금액)
			if (result > 0) {
				response.sendRedirect("Rankupdate");
			}
			break;

		/*
		 * String dname=request.getParameter("dname"); String
		 * director=request.getParameter("director"); String
		 * genre=request.getParameter("genre"); int
		 * age=Integer.parseInt(request.getParameter("age")); int
		 * runtime=Integer.parseInt(request.getParameter("runtime")); Date
		 * showdate=Date.valueOf(request.getParameter("showdate")); String
		 * files=request.getParameter("files");
		 * 
		 * infodto.setDname(dname); infodto.setDirector(director);
		 * infodto.setGenre(genre); infodto.setAge(age); infodto.setRuntime(runtime);
		 * infodto.setShowdate(showdate); infodto.setFiles(files);
		 * 
		 */

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
