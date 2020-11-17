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
import service.BoardService;
import service.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet(value={"/member/memberLogin", "/member/memberLogout", "/member/memberJoin", "/member/memberModify", "/member/checkId", "/member/modifyUser", "/member/memberDelete"})
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
				response.sendRedirect("MemberMain.jsp");
			}
			break;
		case "/member/memberLogout":
			System.out.println("/member/memberLogout");
			session.invalidate();
			response.sendRedirect("/MemberBoard/Main.jsp");
			break;
		case "/member/memberModify":
			System.out.println("/member/memberModify");
			String sessionId = (String) session.getAttribute("checkId");
			MemberDTO userInfo = memberService.getInfo(sessionId);
			request.setAttribute("userInfo", userInfo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/ViewMember.jsp");
			dispatcher.forward(request, response);
			break;
		case "/member/modifyUser":
			System.out.println("/member/modifyUser");
			String modId = (String) session.getAttribute("checkId");
			MemberDTO modDto = new MemberDTO();
			modDto.setUserPw(request.getParameter("newPw"));
			modDto.setUserName(request.getParameter("newName"));
			modDto.setUserBirth(Date.valueOf(request.getParameter("newBirth")));
			modDto.setUserEmail(request.getParameter("newEmail"));
			int modResult = memberService.modifyDB(modId, modDto);
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			if(modResult > 0) {
				out.println("<script>");
				out.println("alert('회원수정이 완료되었습니다.')");
				out.println("location.href='/MemberBoard/member/MemberMain.jsp'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('회원수정에 실패하였습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
			break;
		case "/member/memberDelete":
			System.out.println("/member/memberDelete");
			String delId = (String) session.getAttribute("checkId");
			BoardService boardService = new BoardService();
			boardService.delBoardDB(delId);
			int delIdResult = memberService.delIdDB(delId);
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			if(delIdResult > 0) {
				session.invalidate();
				out.println("<script>");
				out.println("alert('삭제가 완료되었습니다.')");
				out.println("location.href='/MemberBoard/Main.jsp'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('삭제에 실패하였습니다.')");
				out.println("history.back()");
				out.println("</script>");

			}
			break;
		}
	}

}

