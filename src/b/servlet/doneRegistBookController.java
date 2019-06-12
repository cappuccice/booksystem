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

import b.bean.AllIdBean;
import b.bean.InputNumberBean;
import b.dao.DataAccessException;
import b.dao.MySQLBookDao;
import b.java.Book;

@WebServlet("/doneRegistBookController")
public class doneRegistBookController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		最新のIDを取得し、それに1を足したものを追加した資料のIDとする。
//		これを追加した分だけ行う。
		HttpSession session = request.getSession();
		InputNumberBean data = (InputNumberBean)session.getAttribute("numberOfBook");

		@SuppressWarnings("unchecked")
		List<Book> bookInfo = (List<Book>)session.getAttribute("book");

//		ISBN番号の取得
		String ISBN = bookInfo.get(0).getIsbn();

		ArrayList<Integer> IDlist = new ArrayList<Integer>();
		List<AllIdBean> list = new ArrayList<>();
		try {
		MySQLBookDao dao = new MySQLBookDao();
		list = dao.findAllId();
		request.setAttribute("allId", list);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

//		最新のIDの取得処理
		int numberOfID = list.size();
		int ID = 99+numberOfID;

		for(int i=0; i<data.getNumberOfBook(); i++) {
			try {
				MySQLBookDao dao2 = new MySQLBookDao();
			ID = ID + 1;
//			String ID = String.valueOf(intID);
			IDlist.add(ID);
			dao2.addID(ID, ISBN);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		}

	request.setAttribute("ID",IDlist);
	RequestDispatcher rd = request.getRequestDispatcher("/doneRegistBook.jsp");
	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
