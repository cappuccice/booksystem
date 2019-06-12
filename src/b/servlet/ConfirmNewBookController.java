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

import b.bean.NewBookBean;
import b.bean.PublisherBean;
import b.dao.DataAccessException;
import b.dao.MySQLBookDao;

@WebServlet("/ConfirmNewBookController")
public class ConfirmNewBookController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String divCode = request.getParameter("divCode");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisherName = request.getParameter("publisherName");
//		String publicationDate = request.getParameter("publicationDate");

		if(divCode == null || divCode.length() == 0 ||
				title == null || title.length() == 0 ||
				author == null || author.length() == 0 ||
				publisherName == null || publisherName.length() == 0 ) {
			request.setAttribute("message", "情報をすべて入力してください。");
			RequestDispatcher rd = request.getRequestDispatcher("/ValidationErrors");
			rd.forward(request, response);
			return;
		}

//		int numberOfBook;
//	try {
//		numberOfBook = Integer.parseInt(strNumberOfBook);
//	}catch (NumberFormatException e) {
//		request.setAttribute("message", "冊数は数値を入力してください。");
//		RequestDispatcher rd = request.getRequestDispatcher("/ValidationErrors");
//		rd.forward(request, response);
//		return;
//	}

	NewBookBean newBookInfo = new NewBookBean(divCode, title, author, publisherName);
	HttpSession session = request.getSession();
	session.setAttribute("NewBook", newBookInfo);


	List<PublisherBean> list = new ArrayList<>();
	PublisherBean publisherBean = new PublisherBean("" , publisherName);
	try {
	MySQLBookDao dao = new MySQLBookDao();
	list = dao.searchPublisger(publisherBean);
	request.setAttribute("publishername", list);
	HttpSession sessionPublish = request.getSession();
	sessionPublish.setAttribute("publishInfo", list);
	}catch (DataAccessException e) {
		e.printStackTrace();
	}


//	要本の追加情報をBookに記録する処理?
	RequestDispatcher rd = request.getRequestDispatcher("/confirmNewBook.jsp");
	rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
