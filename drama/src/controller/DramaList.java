package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.DramaDTO;
import service.DramaListService;


/**
 * Servlet implementation class DramaList
 */
@WebServlet({"/DramaList"})
public class DramaList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DramaList() {
        // TODO Auto-generated constructor stub
    }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		DramaListService dramalistsvc = new DramaListService();
		
		switch (request.getServletPath()) {
		case "/DramaList":
			System.out.println("/DramaList");
			ArrayList<DramaDTO> DramaList = new ArrayList<DramaDTO>();
			DramaList = dramalistsvc.DramaList();
			request.setAttribute("DramaList", DramaList);

			response.setContentType("text/html; charset=UTF-8");
			
			RequestDispatcher dispatcher
			= request.getRequestDispatcher("DramaList.jsp");
			dispatcher.forward(request, response);
			
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
