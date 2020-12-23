package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.CommentsDTO;
import dto.DramaDTO;
import service.service;

/**
 * Servlet implementation class DramaView
 */
@WebServlet({"/DramaView","/Comments"})
public class DramaView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DramaView() {
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
		service sv = new service();
		
		switch (request.getServletPath()) {
		case "/DramaView":
			String mcode = (String) session.getAttribute("idCode");
			System.out.println("DramaView"); // DramaView컨트롤러 넘어왔는지 확인
			System.out.println("mcode: "+mcode); // 확인
			
			String dcode = request.getParameter("dcode"); // dcode 저장
			System.out.println("dcode: "+dcode); // 확인
			DramaDTO DramaDTO = new DramaDTO();
			
			DramaDTO = sv.DramaView(dcode); // 영화정보리스트 
			System.out.println(DramaDTO); // 정보를 가져옴
			ArrayList<CommentsDTO> commentsList = new ArrayList<CommentsDTO>();
			commentsList = sv.commentsList(dcode); // 댓글리스트
			for (int i = 0; i < commentsList.size(); i++) {
				System.out.println(commentsList.get(i));
			}
			float grade = sv.grade(dcode);//평균평점을 가져옴.
			System.out.println("평균평점 : " + grade);
			// 넘겨야 할 정보 : DramaDTO -> 영화정보  commentsList -> 댓글리스트  평균평점 -> grade
			RequestDispatcher dispatcher = request.getRequestDispatcher("DramaView.jsp");
			request.setAttribute("dramaInfo", DramaDTO);
			request.setAttribute("commentsList", commentsList);
			request.setAttribute("grade", grade);
			dispatcher.forward(request, response);
			break;
			
		case "/Comments" :
			System.out.println("Comments");
			CommentsDTO CommentsDTO = new CommentsDTO();
			dcode= request.getParameter("c_dcode");
			System.out.println("댓글 : " + dcode);
			CommentsDTO.setC_dcode(dcode);
			CommentsDTO.setC_mcode((String) session.getAttribute("idCode"));
			CommentsDTO.setComments(request.getParameter("comments"));
			CommentsDTO.setCpw(request.getParameter("cpw"));
			CommentsDTO.setGrade(Float.valueOf(request.getParameter("grade")));
			boolean result = sv.Comments(CommentsDTO);
			System.out.println("댓글2 : " + dcode);
			if(result) {
				System.out.println("댓글달기성공");
				response.sendRedirect("DramaView?dcode="+dcode);
			}else {
				System.out.println("댓글달기실패");
			}
			break;
			
		default:
			break;
		}
		
	}
}
