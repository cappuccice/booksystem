package b.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import b.bean.NewMemberBean;

@WebServlet("/ConfirmNewMemberController")
public class ConfirmNewMemberController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String postal = request.getParameter("postal");
		String address = request.getParameter("address");
		String tel_1 = request.getParameter("tel_1");
		String tel_2 = request.getParameter("tel_2");
		String tel_3 = request.getParameter("tel_3");
		String email_1 = request.getParameter("email_1");
		String email_2 = request.getParameter("email_2");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");

//		入力データ整理
		String tel = tel_1 + "-" + tel_2 + "-" + tel_3;
		String email = email_1 + "@" + email_2;
		String strBirthday = year + "-" + month + "-" + day;
		Date birthday = Date.valueOf(strBirthday);

		NewMemberBean newMemberInfo = new NewMemberBean(userName, postal, address, tel, email, birthday);
		HttpSession session = request.getSession();
		session.setAttribute("NewMember", newMemberInfo);

//		要エラー処理

		RequestDispatcher rd = request.getRequestDispatcher("/regisiterconfirmView.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
