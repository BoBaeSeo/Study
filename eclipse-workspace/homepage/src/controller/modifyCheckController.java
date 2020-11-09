package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberModifyService;

/**
 * Servlet implementation class modifyCheckController
 */
@WebServlet("/modifyCheck")
public class modifyCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyCheckController() {
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
		response.setContentType("text/html; charset=UTF-8");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		MemberModifyService memberModifysvc = new MemberModifyService();
		Boolean pwResult = memberModifysvc.checkUserPw(userPw);
		PrintWriter out = response.getWriter();
		if(pwResult) {
			boolean updateResult = memberModifysvc.modifyInfo(userName, userEmail, userPw);
			if(updateResult) {
				response.sendRedirect("ModifySuccess.jsp");
			} else {
				response.sendRedirect("ModifyFail.jsp");
			}
		} else {
			response.sendRedirect("PwCheckFail.jsp");
		}
		
	}

}
