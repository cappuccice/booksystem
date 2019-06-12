package b.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import b.dao.DataAccessException;
import b.dao.MySQLMemberDao;
import b.java.Member;

@WebServlet("/ConfirmMemberController")
public class ConfirmMemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		Member searchedMember = null;
		if (action.equals("userDelete")) {
			String userId = request.getParameter("deleteuserID");
			try {
				MySQLMemberDao dao = new MySQLMemberDao();
				searchedMember = dao.memberSearchByuserId(userId);//会員IDから検索
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			request.setAttribute("member", searchedMember);
			RequestDispatcher rd = request.getRequestDispatcher("/deleteconfirmMemberView.jsp");
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

//		}else if(action.equals("memberUpdate")) {
//			String userId = request.getParameter("update_userId");
//			String userName = request.getParameter("update_userName");
//			String address = request.getParameter("update_address");
//			String tel = request.getParameter("update_tel");
//			String email = request.getParameter("update_email");
//			Member updateMember = new Member(userId,userName, address, tel, email,"","");
//
//			try {
//				MySQLMemberDao dao = new MySQLMemberDao();
//				dao.updateByuserId(updateMember);//会員IDから更新
//			}catch(DataAccessException e) {
//				e.printStackTrace();
//			}
//			request.setAttribute("MemberId", memberId);
//			RequestDispatcher rd = request.getRequestDispatcher("/deleteconfirmmemberView.jsp");
//			rd.forward(request, response);
//		}
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//}