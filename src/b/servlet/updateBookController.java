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

@WebServlet("/updateBookController")
public class updateBookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if(action.equals("bookUpdate")) {
			HttpSession session = request.getSession(false);
			Book book = (Book)session.getAttribute("book");
			try {
				MySQLBookDao dao = new MySQLBookDao();
				dao.updateByISBN(book);
			}catch(DataAccessException e) {
				e.printStackTrace();
			}
			//session.removeAttribute("book");
			//request.setAttribute("Book", book);
			RequestDispatcher rd = request.getRequestDispatcher("/editBookDoneView.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
