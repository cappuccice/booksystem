package b.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.bean.InputISBNBean;
import b.bean.NewBookBean;
import b.bean.PublisherBean;
import b.dao.DataAccessException;
import b.dao.MySQLBookDao;

@WebServlet("/DoneNewBookController")
public class DoneNewBookController extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NewBookBean newBookInfo = (NewBookBean)session.getAttribute("NewBook");
		List<PublisherBean> publisher = (List<PublisherBean>)session.getAttribute("publishInfo");
		InputISBNBean Isbn = (InputISBNBean)session.getAttribute("isbn");
//		ISBN番号の取得
		String ISBN = Isbn.getISBN();

		try {
			MySQLBookDao dao = new MySQLBookDao();
			dao.addNewBookInfo(ISBN, newBookInfo.getDivCode(), publisher.get(0).getPublisherCode(), newBookInfo.getTitle(), newBookInfo.getAuthor());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/doneNewBook.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
