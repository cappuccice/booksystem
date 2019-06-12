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

import b.bean.ReturnBookBean;

/**
 * Servlet implementation class confirmReturn
 */
@WebServlet("/ConfirmReturn")
public class ConfirmReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> idList = new ArrayList<>();
		idList.add(request.getParameter("Id1"));
		idList.add(request.getParameter("Id2"));
		idList.add(request.getParameter("Id3"));
		idList.add(request.getParameter("Id4"));
		idList.add(request.getParameter("Id5"));
		ReturnBookBean bean = new ReturnBookBean(idList);
		HttpSession session = request.getSession();
		session.setAttribute("idNum", bean);

		RequestDispatcher rd = request.getRequestDispatcher("/confirmReturn.jsp");
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
