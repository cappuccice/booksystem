package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.dao.DataAccessException;
import b.dao.MySQLBookDao;
import b.java.Book;

@WebServlet("/showBookInputFormController")
public class showBookInputFormController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		Book book = null;

		if(action.equals("bookUpdate")) {

			String isbn = request.getParameter("updateISBN");
			try {
				MySQLBookDao dao = new MySQLBookDao();
				book = dao.bookSearchByISBN(isbn);
			}catch (DataAccessException e) {
				e.printStackTrace();
			}
			HttpSession session = request.getSession(true);
			session.setAttribute("Book", book);
			RequestDispatcher rd = request.getRequestDispatcher("/editBookInputView.jsp");
			rd.forward(request, response);
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
