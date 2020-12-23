package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberDeleteService;

/**
 * Servlet implementation class MemberDeletController
 */
@WebServlet("/MemberDelete")
public class MemberDeletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeletController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	System.out.println("DELEㅆ");

    	HttpSession session = request.getSession();
    	String idCode = (String) session.getAttribute("idCode");
    	System.out.println(idCode);
    	MemberDeleteService MemberDelsvs = new MemberDeleteService();
    	int result = MemberDelsvs.MemberDelete(idCode);
    	
    	if(result>0) {
    		session.invalidate();
    		response.sendRedirect("Main.jsp");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
