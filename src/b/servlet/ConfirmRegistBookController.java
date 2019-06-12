package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.bean.InputNumberBean;

@WebServlet("/ConfirmRegistBookController")
public class ConfirmRegistBookController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		HttpSession sessionInfo = request.getSession();
//		Book bookInfo = (Book)sessionInfo.getAttribute("book");
//
//		HttpSession sessionId = request.getSession();
//		BookIdBean bookId = (BookIdBean)sessionId.getAttribute("bookId");
//
//		HttpSession sessionPublish = request.getSession();
//		PublisherBean publish = (PublisherBean)sessionPublish.getAttribute("publishInfo");



		String strNumberOfBook = request.getParameter("numberOfBook");
		if(strNumberOfBook == null || strNumberOfBook.length() == 0) {
			request.setAttribute("message", "冊数を入力してください。");
			RequestDispatcher rd = request.getRequestDispatcher("/ValidationErrors");
			rd.forward(request, response);
			return;
		}

		int numberOfBook;
	try {
		numberOfBook = Integer.parseInt(strNumberOfBook);
	}catch (NumberFormatException e) {
		request.setAttribute("message", "冊数は数値を入力してください。");
		RequestDispatcher rd = request.getRequestDispatcher("/ValidationErrors");
		rd.forward(request, response);
		return;
	}

	InputNumberBean no = new InputNumberBean(numberOfBook);
	request.setAttribute("NumberOfBook", no);
//	(要本の追加情報をBookに記録する処理)?
	HttpSession session = request.getSession();
	session.setAttribute("numberOfBook", no);
	RequestDispatcher rd = request.getRequestDispatcher("/confirmRegistBook.jsp");
	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
