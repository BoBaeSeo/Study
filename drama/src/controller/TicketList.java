package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.InfoDTO;
import service.TicketListService;

/**
 * Servlet implementation class TicketList
 */
@WebServlet(value={"/TicketList", "/cancelDrama", "/bookDetail"})
public class TicketList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		TicketListService dramaSvc = new TicketListService();
		
		switch(request.getServletPath()) {
		case "/TicketList":
		String id = (String) session.getAttribute("idCheck");
		ArrayList<InfoDTO> infoList = new ArrayList<InfoDTO>();
		infoList = dramaSvc.getInfo(id);
		try {
			if(infoList.get(0) == null) {
			} else {
				request.setAttribute("infoList", infoList);
				request.setAttribute("ok", "ok");	
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("TicketList.jsp");
		dispatcher.forward(request, response);
		break;
		
		case "/bookDetail":
			String tcode = request.getParameter("tcode");
			InfoDTO info = dramaSvc.viewInfo(tcode);
			request.setAttribute("info", info);
			String userPw = info.getPw();
			request.setAttribute("userPw", userPw);
			dispatcher = request.getRequestDispatcher("BookDetail.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "/cancelDrama":
			tcode = request.getParameter("tcode");
			int tnum =  Integer.parseInt(request.getParameter("tnum"));
			id = (String) session.getAttribute("idCheck");
			String dcode = request.getParameter("dcode");
			System.out.println(tcode+" "+tnum );
			
			int result = dramaSvc.cancelDrama(tcode,tnum,id,dcode);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.println("<script>");
				out.println("alert('예매취소가 완료되었습니다.')");
				out.println("location.href='Rankupdate'");
				out.println("</script>");	
			} else {
				out.println("<script>");
				out.println("alert('예매취소에 실패하였습니다.')");
				out.println("history.back()");
				out.println("</script>");	
			}
			break;
		}
		
		
	}

}
