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
import b.dao.MySQLBookDao;
import b.java.Book;

@WebServlet("/searchBookController")
public class searchBookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		MySQLBookDao dao;
		List<Book> Books = new ArrayList<>();

		if(action.equals("bookSearch")) {
			//String bookId = request.getParameter("bookId");
			String isbn = request.getParameter("isbn");
			String divCode = request.getParameter("divCode");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String publisher = request.getParameter("publicasher");
			//System.out.println(divCode);
			//System.out.println(publisher);
			//String publicationDate = request.getParameter("publicationDate");

			Book serchedBook = new Book(isbn, divCode, title, author, publisher);
			try {
				dao = new MySQLBookDao();
				Books = dao.bookSearch(serchedBook);
			}catch (DataAccessException e) {
				e.printStackTrace();
			}
			request.setAttribute("Book", Books);
			RequestDispatcher rd1 = request.getRequestDispatcher("/searchBookView.jsp");
			rd1.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
