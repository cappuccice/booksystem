package b.servlet;
/*package b.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.dao.MySQLBookDao;
import b.java.Book;

@WebServlet("/confirmBookController")
public class editConfirmView extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if(action.equals("bookDelete")) {
			String isbn = request.getParameter("isbn");
			MySQLBookDao dao = new MySQLBookDao();
			//Book book2 = dao.bookSearch(isbn);//isbnからid番号を検索する

			request.setAttribute("Book", book2);
			RequestDispatcher rd = request.getRequestDispatcher("/deleteBookSelectView.jsp");
			rd.forward(request, response);

		}else if(action.equals("bookUpdate")) {
			String bookId = request.getParameter("bookId");
			String isbn = request.getParameter("isbn");
			String divCode = request.getParameter("divCode");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String publisher = request.getParameter("publisher");
			String publicationDate = request.getParameter("publicationDate");

			Book book1 = new Book(bookId, isbn, divCode, title, author, publisher, publicationDate);
			MySQLBookDao dao = new MySQLBookDao();
			List<Book> book2 = dao.bookSearch(book1);

			request.setAttribute("Book", book2);
			RequestDispatcher rd = request.getRequestDispatcher("/editBookConfirmView.jsp");
			rd.forward(request, response);
		}

	}
}
*/