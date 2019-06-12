package b.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.bean.RentalBookBean;

/**
 * Servlet implementation class ConfirmRental
 */
@WebServlet("/ConfirmRental")
public class ConfirmRental extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		ArrayList<String> rentalBook = new ArrayList<>();
		rentalBook.add(request.getParameter("ISBN1"));
		rentalBook.add(request.getParameter("ISBN2"));
		rentalBook.add(request.getParameter("ISBN3"));
		rentalBook.add(request.getParameter("ISBN4"));
		rentalBook.add(request.getParameter("ISBN5"));

		HttpSession session = request.getSession();

		RentalBookBean bean  = new RentalBookBean(userId,rentalBook);
		session.setAttribute("rentalInfos", bean);

		RequestDispatcher rd = request.getRequestDispatcher("/confirmRental.jsp");
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
