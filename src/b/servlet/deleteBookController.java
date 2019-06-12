package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.dao.DataAccessException;
import b.dao.MySQLBookDao;

@WebServlet("/deleteBookController")
public class deleteBookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if(action.equals("bookDelete")) {
			String ID = request.getParameter("id");
			try {
				MySQLBookDao dao = new MySQLBookDao();
				dao.idDelete(ID);//id番号から、本を削除する
			}catch(DataAccessException e) {
				e.printStackTrace();
			}

			request.setAttribute("ID", ID);
			RequestDispatcher rd = request.getRequestDispatcher("/deleteBookDoneView.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
