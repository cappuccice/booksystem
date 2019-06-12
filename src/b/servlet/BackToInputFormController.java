package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BackToInputFormController")
public class BackToInputFormController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd;
		String action = request.getParameter("action");
		if(action.equals("bookUpdate")) {
			rd = request.getRequestDispatcher("/editBookInputView.jsp");
			rd.forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.invalidate();
			rd = request.getRequestDispatcher("/registerinputView.jsp");
			rd.forward(request, response);
		}
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

}
