package b.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import b.bean.AllMemberIdBean;
import b.java.Member;

public class MySQLMemberDao extends DBManager{

	public MySQLMemberDao() throws DataAccessException{
		getConnection();
	}

	public List<Member> memberSearch(Member member) throws DataAccessException{
		if (con == null) {
			getConnection();
		}

		PreparedStatement st = null;
		ResultSet rs = null;
		String sql;

		//検索文作成
		sql = "SELECT * FROM Member WHERE ";
		String and = " AND ";
		boolean andFlag = false;

		if(member.getUserId() != null && member.getUserId().length() > 0) {
			sql = sql + "user_id LIKE '%" + member.getUserId() + "%'";
			andFlag = true;
		}

		if (member.getUserName() != null && member.getUserName().length() > 0) {
			if(andFlag) {
				sql += and;
			}
			sql = sql + "user_name LIKE '%" + member.getUserName() + "%'";
			andFlag = true;
		}

		if(member.getAddress() != null && member.getAddress().length() > 0) {
			if(andFlag) {
				sql += and;
			}
			sql = sql + "user_address LIKE '%" + member.getAddress() + "%'";
			andFlag = true;
		}

		if(member.getTel() != null && member.getTel().length() > 0) {
			if(andFlag) {
				sql += and;
			}
			sql = sql + "user_tel LIKE '%" + member.getTel() + "%'";
			andFlag = true;
		}

		if(member.getEmail() != null && member.getEmail().length() > 0) {
			if(andFlag) {
				sql += and;
			}
			sql = sql + "user_email LIKE '%" + member.getEmail() + "%'";
			andFlag = true;
		}

		if(member.getPostal() != null && member.getPostal().length() > 0) {
			if(andFlag) {
				sql += and;
			}
			sql = sql + "user_postal LIKE '%" + member.getPostal() + "%'";
			andFlag = true;
		}

		if(member.getBirthday() != null && member.getBirthday().length() > 0) {
			if(andFlag) {
				sql += and;
			}
			sql = sql + "user_birthday LIKE '%" + member.getBirthday() + "%'";
			andFlag = true;
		}

		sql += ";";
		System.out.print(sql);
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<Member> list = new ArrayList<Member>();
			while (rs.next()) {
				String userId = String.valueOf(rs.getInt("user_id"));
				String userName = rs.getString("user_name");
				String address = rs.getString("user_address");
				String tel = rs.getString("user_tel");
				String email = rs.getString("user_email");
				String postal = rs.getString("user_postal");
				String birthday = String.valueOf(rs.getDate("user_birthday"));
				System.out.println(userName);

				Member User = new Member(userId, userName, address,
											tel, email, postal, birthday);
				list.add(User);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの取得に失敗しました");
		}finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
				con.close();
			}catch (Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
			}
		}
	}

	public int idDelete(String id) throws DataAccessException {
		if (con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		try {

			String sql = "DELETE FROM Member WHERE user_id = ?";
			st = con.prepareStatement(sql);
			int int_id = Integer.parseInt(id);
			st.setInt(1, int_id);
			int rows = st.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの操作に失敗しました。");
		} finally {
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
			}
		}
	}

	public Member memberSearchByuserId(String userId) throws DataAccessException {
		if (con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Member WHERE user_Id = ?";

		try {
			st = con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(userId));
			rs = st.executeQuery();

			if (rs.next()) {
				String user_id = String.valueOf(rs.getInt("user_id"));
				String user_name = rs.getString("user_name");
				String user_address = rs.getString("user_address");
				String user_tel = rs.getString("user_tel");
				String user_email = rs.getString("user_email");
				String user_postal = rs.getString("user_postal");
				String birthday = String.valueOf(rs.getDate("user_birthday"));
				Member serchedMember = new Member(user_id, user_name, user_address, user_tel, user_email, user_postal,
						birthday);
				return serchedMember;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの操作に失敗しました。");
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
			}
		}
	}

	public int addNewMembetr(int userId, String userName, String postal, String address, String tel, String email, Date birthday,String password, String userRole) throws DataAccessException{
		if (con == null) {
			getConnection();
		}

		PreparedStatement st = null;
		try {
			String sql = "INSERT INTO Member VALUES(?,?,?,?,?,?,?,?,?);";
			st = con.prepareStatement(sql);
			st.setInt(1, userId);
			st.setString(2, userName);
			st.setString(3, postal);
			st.setString(4, address);
			st.setString(5, tel);
			st.setString(6, email);
			st.setDate(7, birthday);
			st.setString(8, password);
			st.setString(9, userRole);

			int rows = st.executeUpdate();
			return rows;
		}catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの操作に失敗しました。");
		}finally {
			try {
				st.close();
				con.close();
			}catch(Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
		}
	}
	}

	public List<AllMemberIdBean> findAllMemberId() throws DataAccessException{
		PreparedStatement st = null;
		ResultSet rs = null;
		if (con == null) {
			getConnection();
		}
		//ID全件取得
		try {
			String sql = "SELECT user_id FROM Member";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			List<AllMemberIdBean> list = new ArrayList<>();
			while (rs.next()) {
				String userId = rs.getString("user_id");
				AllMemberIdBean AllMemberId = new AllMemberIdBean(userId);
				list.add(AllMemberId);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの操作に失敗しました。");
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			}catch(Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
		}
		}
	}


}
