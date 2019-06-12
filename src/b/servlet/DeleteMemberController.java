package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.dao.DataAccessException;
import b.dao.MySQLMemberDao;


@WebServlet("/DeleteMemberController")
public class DeleteMemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if(action.equals("delete")) {
			String ID = request.getParameter("id");
			try  {
				MySQLMemberDao dao = new MySQLMemberDao();
				dao.idDelete(ID);//id番号から、会員を削除する
			}catch(DataAccessException e) {
				e.printStackTrace();
			}

			request.setAttribute("ID", ID);
			RequestDispatcher rd = request.getRequestDispatcher("/deleteMemberView.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
