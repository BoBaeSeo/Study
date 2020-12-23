package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MembersDTO;
import service.ModifyService;

/**
 * Servlet implementation class ModifyProcesser
 */
@WebServlet("/ModifyProcesser")
public class ModifyProcesser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyProcesser() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		Date birth = Date.valueOf(request.getParameter("birth"));
		
		HttpSession session = request.getSession();
		String sId = (String) session.getAttribute("idCheck");
		System.out.println(sId);
		MembersDTO dto = new MembersDTO();
		dto.setName(name);
		dto.setId(id);
		dto.setPw(pw);
		dto.setPhone(phone);
		dto.setBirth(birth);
		
		ModifyService Modifysvc = new ModifyService();
		int result = Modifysvc.ModifyProcess(dto,sId);
		if(result > 0) {
			if(id == sId) {
				response.sendRedirect("Modify");
			}else {
				session.removeAttribute("idCheck");
				session.setAttribute("idCheck", id);
				response.sendRedirect("Modify");
			}
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
