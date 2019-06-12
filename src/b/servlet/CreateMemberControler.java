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

import b.bean.AllMemberIdBean;
import b.bean.NewMemberBean;
import b.dao.DataAccessException;
import b.dao.MySQLMemberDao;

@WebServlet("/CreateMemberControler")
public class CreateMemberControler extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NewMemberBean newMemberInfo = (NewMemberBean)session.getAttribute("NewMember");


//		固定入力データ
		String password = "himitu";
		String userRole = "1";

//		既存会員ID取得処理
		ArrayList<Integer> IDlist = new ArrayList<Integer>();
		List<AllMemberIdBean> list = new ArrayList<>();
		try {
		MySQLMemberDao dao = new MySQLMemberDao();
		list = dao.findAllMemberId();
		request.setAttribute("allMemberId", list);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

//		最新のIDの取得 & 新規IDの設定
		int numberOfID = list.size();
		int latestID = numberOfID;
		int userId = latestID + 1;
		IDlist.add(userId);

		try {
			MySQLMemberDao dao = new MySQLMemberDao();
			dao.addNewMembetr(userId, newMemberInfo.getUserName(), newMemberInfo.getPostal(),
					newMemberInfo.getAddress(), newMemberInfo.getTel(), newMemberInfo.getEmail(), newMemberInfo.getBirthday(), password, userRole);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/registerdoneView.jsp");
		rd.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
