package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MembersDTO;
import service.TicketListService;

/**
 * Servlet implementation class MemberJoin
 */
@WebServlet(value={"/MemberJoin", "/checkId"})
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoin() {
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
		TicketListService dramaSvc = new TicketListService();
	switch(request.getServletPath()) {
	case "/checkId":
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("checkId");
		String uId = request.getParameter("uId");
		System.out.println(uId);
		String resultMsg = dramaSvc.checkId(uId);
		System.out.println(resultMsg);
		out.print(resultMsg);
		break;
		
	case "/MemberJoin":
		System.out.println("MemberJoin");
		MembersDTO dto = new MembersDTO();
		dto.setName(request.getParameter("userName"));
		dto.setId(request.getParameter("userId"));
		dto.setPw(request.getParameter("userPw"));
		dto.setPhone(request.getParameter("userPhone"));
		dto.setBirth(Date.valueOf(request.getParameter("userBirth")));
		dto.setRank("D");
		int result = dramaSvc.insertMemDB(dto);
		response.setContentType("text/html; charset=UTF-8");
		out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('회원가입이 완료되었습니다.')");
			out.println("location.href='Main.jsp'");
			out.println("</script>");	
		} else {
			out.println("<script>");
			out.println("alert('회원가입에 실패하였습니다.')");
			out.println("history.back()");
			out.println("</script>");	
		}
		break;
	}
		
	}
}
