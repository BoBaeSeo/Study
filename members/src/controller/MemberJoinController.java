package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberJoinService;

/**
 * Servlet implementation class MemberJoinController
 */
@WebServlet("/memberJoin")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinController() {
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
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userBirth = request.getParameter("userBirth");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		MemberDTO member = new MemberDTO();
		member.setUserId(userId);
		member.setUserPw(userPw);
		member.setUserName(userName);
		member.setUserBirth(userBirth);
		member.setUserGender(userGender);
		member.setUserEmail(userEmail);
		System.out.println(member);
		
		MemberJoinService memberjoinsvc = new MemberJoinService();
		boolean result = memberjoinsvc.memberJoin(member);
		
		if(result) {
			response.sendRedirect("LoginForm.jsp");
		} else {
			response.sendRedirect("JoinFail.jsp");
		}
		
		
	}
}
