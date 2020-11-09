package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet(value={"/member/memberLogin", "/member/memberLogout", "/member/memberJoin", "/member/memberModify", "/member/checkId"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
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
		MemberService memberService = new MemberService();
		switch(request.getServletPath()) {
		case "/member/checkId":
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println("/member/checkId");
			String uId = request.getParameter("uId");
			System.out.println(uId);
			String resultMsg = memberService.checkId(uId);
			out.print(resultMsg);
			break;
		case "/member/memberJoin":
			System.out.println("/member/memberJoin");
			MemberDTO dto = new MemberDTO();
			dto.setUserId(request.getParameter("userId"));
			dto.setUserPw(request.getParameter("userPw"));
			dto.setUserName(request.getParameter("userName"));
			dto.setUserBirth(Date.valueOf(request.getParameter("userBirth")));
			dto.setUserGender(request.getParameter("userGender"));
			String userEmail = request.getParameter("userEmail") + "@" + request.getParameter("email");
			dto.setUserEmail(userEmail);
			int result = memberService.memberJoinDB(dto);
			if(result > 0) {
				response.sendRedirect("LoginForm.jsp");
			} else {
				response.setContentType("text/html; charset=UTF-8");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원가입 실패')");
				out.println("history.back()");
				out.println("</script>");
			}
			break;
		case "/member/memberLogin":
			System.out.println("/member/memberLogin");
			String userId = request.getParameter("userId");
			String userPw = request.getParameter("userPw");
			String checkId = memberService.checkLogin(userId, userPw);
			if(checkId == null) {
				response.setContentType("text/html; charset=UTF-8");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디와 비밀번호가 일치하지 않습니다.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				session.setAttribute("checkId", checkId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("MemberMain.jsp");
				dispatcher.forward(request, response);
			}
			break;
		}
	}

}

