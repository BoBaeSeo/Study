package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberModifyService;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/memberDetail")
public class MemberDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String userId = request.getParameter("userId");
		MemberModifyService memberModifysvc = new MemberModifyService();
		MemberDTO member = new MemberDTO();
		member = memberModifysvc.modifyMember(userId);
		PrintWriter out = response.getWriter();
		out.println("<h2>상세조회</h2><table>\r\n" + 
				"<tr><td>아이디</td><td>비밀번호</td><td>이름</td><td>생년월일</td>\r\n" + 
				"<td>성별</td><td>이메일</td><td>뒤로가기</td></tr>"
				+ "<tr><td>"+member.getUserId()+"</td><td>"+member.getUserPw()+
				"</td><td>"+member.getUserName()+"</td><td>"+member.getUserBirth()+"</td>\r\n"+
				"<td>"+member.getUserGender()+"</td><td>"+member.getUserEmail()+"</td>\r\n" + 
				"<td><a href='memberList'>뒤로가기</a></td></tr></table>"); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
