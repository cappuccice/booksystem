package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.bean.ReturnBookBean;
import b.dao.DataAccessException;
import b.dao.MySQLBookDao;

/**
 * Servlet implementation class DoneReturn
 */
@WebServlet("/DoneReturn")
public class DoneReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println("aaa");

		try {
			MySQLBookDao dao = new MySQLBookDao();
			ReturnBookBean bean = (ReturnBookBean)session.getAttribute("idNum");
			System.out.println(bean.getBookStateId().get(0));
			dao.returnBook(bean);
		} catch (DataAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/doneReturn.jsp");
		rd.forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
