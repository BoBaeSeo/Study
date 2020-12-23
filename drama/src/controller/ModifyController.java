package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MembersDTO;
import service.ModifyService;

/**
 * Servlet implementation class Modify
 */
@WebServlet("/Modify")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		
    	HttpSession session = request.getSession();
    	
    	String id = (String)session.getAttribute("idCheck");
		
		ModifyService Modifysvs = new ModifyService();
		MembersDTO dto = Modifysvs.Modify(id);
		
		System.out.println(dto);
		request.setAttribute("Modify", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MemberView.jsp");
		dispatcher.forward(request, response);	
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
