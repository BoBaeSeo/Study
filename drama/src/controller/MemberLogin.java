package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberLoginService;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet({"/MemberLogin","/Rankupdate"})
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		MemberLoginService MemberLoginsvc = new MemberLoginService();
		
		switch (request.getServletPath()) {
		case "/MemberLogin":
			System.out.println("/MemberLogin");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			String idCheck = MemberLoginsvc.checkLogin(id,pw);
			System.out.println("idCheck : "+idCheck);
			String idCode = MemberLoginsvc.getIdcode(id,pw);
			System.out.println("idCode : "+idCode);
			String idRank = MemberLoginsvc.getRank(id);
			System.out.println("idRank : "+idRank);
			if (idCheck==null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인에 실패하였습니다.')");
				out.println("history.back()"); //뒤로 돌아가기
				out.println("</script>");
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter	out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인에 성공하였습니다.')");
				out.println("</script>");
				session.setAttribute("idCheck", idCheck); //세션으로 선언한 idCheck를 boardController에서 사용
				session.setAttribute("idCode", idCode);
				session.setAttribute("idRank", idRank);
				response.sendRedirect("Main.jsp");
				
			}
			break;
		case "/Rankupdate":
			System.out.println("Rankupdate");
			session.removeAttribute("idRank");
			System.out.println("랭크세션초기화");
			id = (String) session.getAttribute("idCheck");
			idRank = MemberLoginsvc.getRank(id);
			session.setAttribute("idRank", idRank);
			String sRank = (String) session.getAttribute("idRank");
			System.out.println(sRank);
			response.sendRedirect("Main.jsp");
			break;
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
