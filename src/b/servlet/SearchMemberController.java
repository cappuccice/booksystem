package b.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.dao.DataAccessException;
import b.dao.MySQLMemberDao;
import b.java.Member;


@WebServlet("/SearchMemberController")
public class SearchMemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");

			MySQLMemberDao dao;
			List<Member> Members = new ArrayList<>();

			if(action.equals("search")) {
				//String memberId = request.getParameter("memberId");
				String userId = request.getParameter("userId");
				String userName = request.getParameter("userName");
				String address = request.getParameter("address");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				//String publicationDate = request.getParameter("publicationDate");

				Member serchedMember = new Member(userId, userName, address, tel, email,"","");
				try {
					dao = new MySQLMemberDao();
					Members = dao.memberSearch(serchedMember);
				}catch (DataAccessException e) {
					e.printStackTrace();
				}




				request.setAttribute("Member",Members);
				RequestDispatcher rd = request.getRequestDispatcher("/searchMemberView.jsp");
				rd.forward(request,response);

			}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}



