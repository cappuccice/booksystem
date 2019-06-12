package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectBookController")
public class selectBookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if(action.equals("bookDelete")) {
			//削除したいIDを取得
			String bookId = request.getParameter("deleteBookId");

			//確認画面で本の情報を表示する
			request.setAttribute("BookId", bookId);
			RequestDispatcher rd = request.getRequestDispatcher("/deleteBookConfirmView.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
