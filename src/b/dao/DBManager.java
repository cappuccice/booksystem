package b.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager{

	public Connection con;

	public void getConnection() throws DataAccessException{
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql:webbook";
			String user = "webbook";
			String pass = "webbook";
			con = DriverManager.getConnection(url, user, pass);
		}catch(Exception e) {
			throw new DataAccessException("接続に失敗しました。");
		}
	}
}
