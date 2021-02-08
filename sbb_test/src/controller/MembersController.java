package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MembersDTO;
import service.MembersService;

/**
 * Servlet implementation class MembersController
 */
@WebServlet(value = {"/memberJoin", "/memberLogin", "/memberInfo", "/memberModify", "/logout", "/checkUserId"})
public class MembersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembersController() {
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
		MembersService memberSvc = new MembersService();
		switch (request.getServletPath()) {
		case "/memberJoin":
			System.out.println("memberJoin");
			MembersDTO memberDTO = new MembersDTO();
			memberDTO.setUserid(request.getParameter("userId"));
			memberDTO.setUserpw(request.getParameter("userPw"));
			memberDTO.setUsername(request.getParameter("userName"));
			memberDTO.setUserphone(request.getParameter("userPhone"));
			memberDTO.setUsergender(request.getParameter("gender"));
			memberDTO.setUseraddr(request.getParameter("addr"));
			String useremail = request.getParameter("inputEmail") + "@" + request.getParameter("emailDomain");
			memberDTO.setUseremail(useremail);
			int result = memberSvc.memberJoin(memberDTO);
			if(result > 0) {
				response.sendRedirect("Home.jsp");
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html; charset=UTF-8");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원가입 실패')");
				out.println("history.back()");
				out.println("</script>");
			}
			break;
		case "/memberLogin":
			System.out.println("memberLogin");
			String checkId = request.getParameter("userId");
			String checkPw = request.getParameter("userPw");
			String loginId = memberSvc.memberLogin(checkId, checkPw);
			if(loginId != null) {
				session.setAttribute("loginId", loginId);
				response.sendRedirect("Home.jsp");
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html; charset=UTF-8");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디와 비밀번호가 일치하지 않습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
			break;
		case "/memberInfo":
			System.out.println("memberInfo");
			String userId = (String) session.getAttribute("loginId");
			memberDTO = memberSvc.memberInfo(userId);
			String[] userEmail = memberDTO.getUseremail().split("@");
			memberDTO.setInputEmail(userEmail[0]);
			memberDTO.setEmailDomain(userEmail[1]);
			request.setAttribute("memberDTO", memberDTO);
			RequestDispatcher dispatcher = request.getRequestDispatcher("memberInfo.jsp");
			dispatcher.forward(request, response);
			break;
		case "/memberModify" :
			System.out.println("memberModify");
			memberDTO = new MembersDTO();
			memberDTO.setUsernum(Integer.parseInt(request.getParameter("userNum")));
			memberDTO.setUserid(request.getParameter("userId"));
			memberDTO.setUserpw(request.getParameter("userPw"));
			memberDTO.setUsername(request.getParameter("userName"));
			memberDTO.setUserphone(request.getParameter("userPhone"));
			memberDTO.setUsergender(request.getParameter("gender"));
			memberDTO.setUseraddr(request.getParameter("addr"));
			useremail = request.getParameter("inputEmail") + "@" + request.getParameter("emailDomain");
			memberDTO.setUseremail(useremail);
			int Modifyresult = memberSvc.memberModify(memberDTO);
			if(Modifyresult > 0) {
				response.sendRedirect("Home.jsp");
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html; charset=UTF-8");
				out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정에 실패하였습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
			break;
		case "/logout":
			System.out.println("logout");
			session.invalidate();
			response.sendRedirect("Home.jsp");
			break;
		case "/checkUserId":
			System.out.println("checkUserId");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			String checkuserId = request.getParameter("userId");
			String resultMsg = memberSvc.checkId(checkuserId);
			System.out.println(resultMsg);
			out.print(resultMsg);
			break;
		}
	}


}
