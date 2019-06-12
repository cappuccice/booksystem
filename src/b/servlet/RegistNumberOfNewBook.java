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

import b.bean.BookIdBean;
import b.bean.InputISBNBean;
import b.bean.PublisherBean;
import b.dao.DataAccessException;
import b.dao.MySQLBookDao;
import b.java.Book;

@WebServlet("/RegistNumberOfNewBook")
public class RegistNumberOfNewBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		要本の情報取得処理

		HttpSession session = request.getSession();
		InputISBNBean Isbn = (InputISBNBean)session.getAttribute("isbn");
//		ISBN番号の取得
		String ISBN = Isbn.getISBN();


		Book book = new Book(ISBN, "", "", "", "");
		BookIdBean bookIdBean = new BookIdBean("", ISBN);

		List<Book> list = new ArrayList<>();
		List<BookIdBean> list2 = new ArrayList<>();
		List<PublisherBean> list3 = new ArrayList<>();

		try {
//			資料の情報を取得
			MySQLBookDao dao = new MySQLBookDao();
			list = dao.bookSearch(book);
			request.setAttribute("bookinfo", list);
			HttpSession sessionInfo = request.getSession();
			sessionInfo.setAttribute("book",list);

			MySQLBookDao dao2 = new MySQLBookDao();
			list2 = dao2.searchBookId(bookIdBean);
			request.setAttribute("bookinfoId", list2);
			HttpSession sessionId = request.getSession();
			sessionId.setAttribute("bookId", list2);

			PublisherBean publisherBean = new PublisherBean(list.get(0).getPublisher(), "");
			MySQLBookDao dao3 = new MySQLBookDao();
			list3 = dao3.searchPublisger(publisherBean);
			request.setAttribute("publishername", list3);
			HttpSession sessionPublish = request.getSession();
			sessionPublish.setAttribute("publishInfo", list3);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}

		RequestDispatcher rd = request.getRequestDispatcher("/inputNumberOfBook.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
