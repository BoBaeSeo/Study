package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberModifyService;

/**
 * Servlet implementation class modifyUser
 */
@WebServlet("/modifyUser")
public class modifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyUser() {
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
		String userId = (String) session.getAttribute("loginId");
		String checkPw = request.getParameter("checkPw");
		String newName = request.getParameter("newName");
		String newEmail = request.getParameter("newEmail");
		MemberModifyService memberModifySvc = new MemberModifyService();
		System.out.println(userId);
		String checkUserId = memberModifySvc.checkPw(userId, checkPw);
		if(checkUserId == null) {
			response.sendRedirect("CheckPwFail.jsp");
		} else {
			boolean result = memberModifySvc.updateMember(newName, newEmail, checkUserId);
			if(result) {
				response.sendRedirect("ModifySuccess.jsp");
			} else {
				response.sendRedirect("ModifyFail.jsp");
			}
		}
		
	}

}
