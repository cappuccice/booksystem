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
import javax.servlet.http.HttpSession;

import b.dao.DataAccessException;
import b.dao.MySQLBookDao;
import b.java.Book;

@WebServlet("/confirmBookController")
public class confirmBookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		List<String> bookId = new ArrayList<>();

		if(action.equals("bookDelete")) {
			String isbn = request.getParameter("deleteISBN");

			Book searchedbook = null;
			try {
				MySQLBookDao dao = new MySQLBookDao();
				searchedbook = dao.bookSearchByISBN(isbn);
			}catch(DataAccessException e) {
				e.printStackTrace();
			}
			HttpSession session = request.getSession(true);
			session.setAttribute("SearchedBook", searchedbook);

			try {
				MySQLBookDao dao = new MySQLBookDao();
				bookId = dao.idSearchByISBN(isbn);//isbnからidを検索
			}catch(DataAccessException e) {
				e.printStackTrace();
			}
			request.setAttribute("BookId", bookId);
			RequestDispatcher rd = request.getRequestDispatcher("/deleteBookSelectView.jsp");
			rd.forward(request, response);

		}else if(action.equals("bookUpdate")) {
			HttpSession session = request.getSession(true);

			String isbn = request.getParameter("update_isbn");
			String divCode = request.getParameter("update_divCode");
			String title = request.getParameter("update_title");
			String author = request.getParameter("update_author");
			String publisher = request.getParameter("update_publisher");
			Book updateBook = new Book(isbn, divCode, title, author, publisher);

			session.setAttribute("book", updateBook);

//			request.setAttribute("Book", updateBook);
			RequestDispatcher rd = request.getRequestDispatcher("/editBookConfirmView.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
