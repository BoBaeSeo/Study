package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BWriteService;

/**
 * Servlet implementation class BWriteController
 */
@WebServlet("/bWrite")
public class BWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BWriteController() {
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
		String bWriter = request.getParameter("bWriter");
		String bPw = request.getParameter("bPw");
		String bTitle = request.getParameter("bTitle");
		String bContents = request.getParameter("bContents");
		
		BoardDTO dto = new BoardDTO();
		dto.setbWriter(bWriter);
		dto.setbPassword(bPw);
		dto.setbTitle(bTitle);
		dto.setbContents(bContents);
		BWriteService bWriteSvc = new BWriteService();
		boolean result = bWriteSvc.bWriteDB(dto);
		if(result) {
			response.sendRedirect("BoardList");
		} else {
			response.sendRedirect("writeFail.jsp");
		}
	}

}
