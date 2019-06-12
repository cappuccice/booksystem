package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.bean.RentalBookBean;
import b.dao.DataAccessException;
import b.dao.MySQLBookDao;

/**
 * Servlet implementation class DoneRental
 */
@WebServlet("/DoneRental")
public class DoneRental extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		RentalBookBean bean = (RentalBookBean)session.getAttribute("rentalInfos");
		try {
			MySQLBookDao dao = new MySQLBookDao();
			dao.rentalBook(bean);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		request.setAttribute("result", bean);

		RequestDispatcher rd = request.getRequestDispatcher("/doneRental.jsp");
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
