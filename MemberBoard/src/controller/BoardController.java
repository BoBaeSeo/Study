package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;
import service.BoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet(value={"/board/boardList", "/board/boardWrite", "/board/userWrite", "/board/boardView", "/board/boardDel", "/board/boardModify", "/board/boardUpdate"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		BoardService boardService = new BoardService();
		switch (request.getServletPath()) {
		case "/board/boardList":
			System.out.println("/board/boardList");
			String userId = (String) session.getAttribute("checkId");
			ArrayList<BoardDTO> boardList = boardService.boardList();
			request.setAttribute("boardList", boardList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/board/BoardList.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "/board/boardWrite":
			System.out.println("/board/boardWrite");
			BoardDTO contents =  new BoardDTO();
			int size = 10*1024*1024;
			String savePath = "C:/Users/1/git/repository/MemberBoard/WebContent/fileupload";
			MultipartRequest multi = new MultipartRequest (
					request,
					savePath,
					size,
					"UTF-8",
					new DefaultFileRenamePolicy()
					);
			contents.setbWriter(multi.getParameter("bWriter"));
			contents.setbPassword(multi.getParameter("bPassword"));
			contents.setbTitle(multi.getParameter("bTitle"));
			contents.setbContents(multi.getParameter("bContents"));
			String bFile = multi.getParameter("bFile");
			bFile = multi.getOriginalFileName((String)multi.getFileNames().nextElement());
			contents.setbFile(bFile);
			System.out.println(contents.getbContents());
			int result = boardService.boardWriteDB(contents);
			if(result > 0) {
				response.sendRedirect("boardList");
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호가 맞지 않습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
			break;
		case "/board/userWrite":
			System.out.println("/board/userWrite");
			userId = (String) session.getAttribute("checkId");
			ArrayList<BoardDTO> writeList = boardService.getWriteList(userId);
			request.setAttribute("boardList", writeList);
			request.setAttribute("back", "myList");
			dispatcher = request.getRequestDispatcher("/board/BoardList.jsp");
			dispatcher.forward(request, response);
			break;
		case "/board/boardView":
			System.out.println("/board/boardView");
			String getNum = (String) request.getParameter("bNumber");
			int bNumber = Integer.parseInt(getNum);
			BoardDTO boardView = boardService.boardView(bNumber);
			request.setAttribute("boardView", boardView);
			dispatcher = request.getRequestDispatcher("BoardView.jsp");
			dispatcher.forward(request, response);
			break;
		case "/board/boardDel":
			System.out.println("/board/boardDel");
			getNum = (String) request.getParameter("bNumber");
			bNumber = Integer.parseInt(getNum);
			int delResult = boardService.boardDel(bNumber);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(delResult > 0) {
				out.println("<script>");
				out.println("alert('삭제가 완료되었습니다.')");
				out.println("location.href='/MemberBoard/board/boardList'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('삭제에 실패하였습니다.')");
				out.println("location.href='/MemberBoard/board/boardList'");
				out.println("</script>");
			}
			break;
		case "/board/boardModify":
			System.out.println("/board/boardModify");
			getNum = (String) request.getParameter("bNumber");
			bNumber = Integer.parseInt(getNum);
			BoardDTO modifyDTO = boardService.boardModify(bNumber);
			request.setAttribute("userDTO", modifyDTO);
			dispatcher = request.getRequestDispatcher("boardModify.jsp");
			dispatcher.forward(request, response);
			break;
		case "/board/boardUpdate":
			System.out.println("/board/boardUpdate");
			BoardDTO changeDTO = new BoardDTO();
			changeDTO.setbNumber(Integer.parseInt((String) request.getParameter("bNumber")));
			changeDTO.setbTitle((String) request.getParameter("bTitle"));
			changeDTO.setbContents((String) request.getParameter("bContents"));
			int updateResult = boardService.boardUpdate(changeDTO);
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			if(updateResult > 0) {
				out.println("<script>");
				out.println("alert('수정이 완료되었습니다.')");
				out.println("location.href='/MemberBoard/board/boardList'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('수정에 실패하였습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
		}
		
	}

}
