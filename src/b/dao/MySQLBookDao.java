package b.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import b.bean.AllIdBean;
import b.bean.BookIdBean;
import b.bean.PublisherBean;
import b.bean.RentalBookBean;
import b.bean.ReturnBookBean;
import b.java.Book;

public class MySQLBookDao extends DBManager{

	public MySQLBookDao() throws DataAccessException{
		getConnection();
	}

	public List<Book> bookSearch(Book book) throws DataAccessException{
		PreparedStatement st = null;
		ResultSet rs = null;
		if(con == null) {
			getConnection();
		}
		String sql = "SELECT * FROM BookInfo WHERE ";
		String and = " AND ";
		boolean andFlag = false;

		if(book.getIsbn() != null &&  book.getIsbn().length() > 0) {
			sql = sql + "bookinfo_isbn LIKE '%" + book.getIsbn()+ "%'";
			andFlag = true;
		}
		if(book.getDivCode() != null && book.getDivCode().length() > 0) {
			if(andFlag) {
				sql += and;
			}
			sql = sql + "category_code = " + book.getDivCode();
			andFlag = true;
		}
		if(book.getPublisher() != null && book.getPublisher().length() > 0) {
			if(andFlag) {
				sql += and;
			}
			sql = sql + "publisher_code = " + book.getPublisher();
			andFlag = true;
		}
		if(book.getTitle() != null && book.getTitle().length() > 0) {
			if(andFlag) {
				sql += and;
			}
			sql = sql + "bookinfo_name LIKE '%" + book.getTitle()+ "%'";
			andFlag = true;
		}
		if(book.getAuthor() != null && book.getAuthor().length() > 0) {
			if(andFlag) {
				sql += and;
			}
			sql = sql + "bookinfo_author LIKE '%" + book.getAuthor() + "%'";
		}

		sql += ";";
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<Book> list = new ArrayList<>();
			while(rs.next()) {
				String isbn = rs.getString("bookinfo_isbn");
				String divCode = rs.getString("category_code");
				String title = rs.getString("bookinfo_name");
				String author = rs.getString("bookinfo_author");
				String publisherCode = rs.getString("publisher_code");
				Book bookInfo = new Book(isbn, divCode, title, author, publisherCode);
				list.add(bookInfo);
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

	public int rentalBook(RentalBookBean books) throws DataAccessException{
		PreparedStatement st = null;
		int rows = 0;

		if(con == null) {
			getConnection();
		}
		List<String> temp = books.getBookStateId();
		java.util.Date date = new java.util.Date();

		System.out.println(date.toString());
		java.sql.Date today = convertToSqlDate(date);
		int hogege = Integer.parseInt(books.getUserId());

		try {
			for(String hoge:temp) {
				String sql = "INSERT INTO Rental (bookstate_id, user_id, rental_rent) VALUES(?,?,?);";
				st = con.prepareStatement(sql);
				st.setInt(1, Integer.parseInt( hoge ));
				st.setInt(2, hogege);
				st.setDate(3, today);


				System.out.println(st);

				rows = st.executeUpdate();
			}
			return rows;

		} catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの操作に失敗しました。");
		} finally {
			try {
				st.close();
				con.close();
			}catch(Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
			}
		}
	}
//////////////////////////////////////
	public List<String> idSearchByISBN(String isbn) throws DataAccessException{
		if(con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BookState WHERE bookinfo_isbn = ?";
		List<String> list = new ArrayList<>();

		try {
			st = con.prepareStatement(sql);
			st.setString(1, isbn);
			rs = st.executeQuery();

			while(rs.next()) {
				list.add(String.valueOf(rs.getInt("bookstate_id")));
				System.out.println(rs.getInt("bookstate_id"));
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

	public int idDelete(String id) throws DataAccessException{
		if(con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		try {
			String sql = "DELETE FROM BookState WHERE bookstate_id = ?";
			System.out.println("id = " + id);
			st = con.prepareStatement(sql);
			int int_id = Integer.parseInt(id);
			st.setInt(1, int_id);
			int rows = st.executeUpdate();
			return rows;

		} catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの操作に失敗しました。");
		} finally {
			try {
				st.close();
				con.close();
			}catch(Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
			}
		}
	}

	public Book bookSearchByISBN(String isbn) throws DataAccessException{
		if(con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BookInfo WHERE bookinfo_isbn = ?";

		try {
			st = con.prepareStatement(sql);
			st.setString(1, isbn);
			rs = st.executeQuery();

			if(rs.next()) {
				String bookinfo_isbn = rs.getString("bookinfo_isbn");
				String category_code = rs.getString("category_code");
				String publisher_code = rs.getString("publisher_code");
				String bookinfo_name = rs.getString("bookinfo_name");
				String bookinfo_author = rs.getString("bookinfo_author");
				Book serchedBook = new Book(bookinfo_isbn, category_code, bookinfo_name, bookinfo_author, publisher_code);
				return serchedBook;
			}else {
				return null;
			}

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

	public int updateByISBN(Book book) throws DataAccessException{
		if(con == null) {
			getConnection();
		}
		PreparedStatement st = null;
		//ResultSet rs = null;
		String sql = "UPDATE BookInfo SET category_code = ?, publisher_code = ?, bookinfo_name = ?, bookinfo_author = ? WHERE bookinfo_isbn = ?";
		//System.out.println("divCode = ");
		try {
			st = con.prepareStatement(sql);
			st.setString(1, book.getDivCode());
			st.setString(2, book.getPublisher());
			st.setString(3, book.getTitle());
			st.setString(4, book.getAuthor());
			st.setString(5, book.getIsbn());
			int rows = st.executeUpdate();
			return rows;
			//System.out.println("divCode = " + book.getDivCode());

		} catch(Exception e) {
			e.printStackTrace();
			throw new DataAccessException("レコードの操作に失敗しました。");
		} finally {
			try {
				//rs.close();
				st.close();
				con.close();
			}catch(Exception e) {
				throw new DataAccessException("リソースの開放に失敗しました。");
			}
		}
	}

		public java.sql.Date convertToSqlDate(java.util.Date utilDate){
		    return new java.sql.Date(utilDate.getTime());
		}

		public List<PublisherBean> searchPublisger(PublisherBean publisherBean) throws DataAccessException{
			PreparedStatement st = null;
			ResultSet rs = null;
			if(con == null) {
				getConnection();
			}

			String sql = "SELECT * FROM Publisher WHERE ";
			String and = " AND ";
			boolean andFlag = false;

			if(publisherBean.getPublisherCode() != null &&  publisherBean.getPublisherCode().length() > 0) {
				sql = sql + "publisher_code LIKE '%" + publisherBean.getPublisherCode()+ "%'";
				andFlag = true;
			}
			if(publisherBean.getPublisherName() != null && publisherBean.getPublisherName().length() > 0) {
				if(andFlag) {
					sql += and;
				}
				sql = sql + "publisher_name LIKE '%" + publisherBean.getPublisherName()+ "%'";
				andFlag = true;
			}

			sql += ";";

			try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<PublisherBean> list = new ArrayList<>();
			while(rs.next()) {
				String publisherCode = rs.getString("publisher_code");
				String publisherName = rs.getString("publisher_name");
				PublisherBean publisher = new PublisherBean(publisherCode, publisherName);
				list.add(publisher);
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

		public int addNewBookInfo(String isbn, String divCode, String publisher, String title, String author) throws DataAccessException{
			if (con == null) {
				getConnection();
			}

			PreparedStatement st = null;
			try {
				String sql = "INSERT INTO BookInfo VALUES(?,?,?,?,?);";
				st = con.prepareStatement(sql);
				st.setString(1, isbn);
				st.setString(2, divCode);
				st.setString(3, publisher);
				st.setString(4, title);
				st.setString(5, author);

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

		public List<AllIdBean> findAllId() throws DataAccessException{
			PreparedStatement st = null;
			ResultSet rs = null;
			if (con == null) {
				getConnection();
			}
			//ID全件取得
			try {
				String sql = "SELECT bookstate_id FROM BookState";
				st = con.prepareStatement(sql);
				rs = st.executeQuery();

				List<AllIdBean> list = new ArrayList<>();
				while (rs.next()) {
					String bookId = rs.getString("bookstate_id");
					AllIdBean AllId = new AllIdBean(bookId);
					list.add(AllId);
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

		public int addID(int bookId, String isbn) throws DataAccessException{
			if (con == null) {
				getConnection();
			}

			PreparedStatement st = null;
			try {
				String sql = "INSERT INTO bookstate VALUES(?,?);";
				st = con.prepareStatement(sql);
				st.setInt(1, bookId);
				st.setString(2, isbn);
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

		public List<BookIdBean> searchBookId(BookIdBean bookIdBean) throws DataAccessException{
			PreparedStatement st = null;
			ResultSet rs = null;
			if(con == null) {
				getConnection();
			}

			String sql = "SELECT * FROM BookState WHERE ";
			String and = " AND ";
			boolean andFlag = false;

			if(bookIdBean.getBookId() != null &&  bookIdBean.getBookId().length() > 0) {
				sql = sql + "bookstate_id LIKE '%" + bookIdBean.getBookId()+ "%'";
				andFlag = true;
			}
			if(bookIdBean.getBookIsbn() != null && bookIdBean.getBookIsbn().length() > 0) {
				if(andFlag) {
					sql += and;
				}
				sql = sql + "bookinfo_isbn LIKE '%" + bookIdBean.getBookIsbn()+ "%'";
				andFlag = true;
			}

			sql += ";";

			try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			List<BookIdBean> list = new ArrayList<>();
			while(rs.next()) {
				String bookId = rs.getString("bookstate_id");
				String bookIsbn = rs.getString("bookinfo_isbn");
				BookIdBean bookInfoId = new BookIdBean(bookId, bookIsbn);
				list.add(bookInfoId);
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

		public void returnBook(ReturnBookBean returnBookIds) throws DataAccessException{
			PreparedStatement st = null;
			if(con == null) {
				getConnection();
			}
			java.util.Date date = new java.util.Date();

			java.sql.Date today = convertToSqlDate(date);
			try {
				for(String hoge : returnBookIds.getBookStateId()) {

					String sql = "UPDATE Rental SET rental_return = ? WHERE bookstate_id = ? AND rental_return is null;";
					st = con.prepareStatement(sql);
					st.setDate(1, today);
					st.setInt(2, Integer.parseInt(hoge));
					System.out.println(st.toString());

					 st.executeUpdate();
				}

			} catch(Exception e) {
				e.printStackTrace();
				throw new DataAccessException("レコードの操作に失敗しました。");
			} finally {
				try {
					st.close();
					con.close();
				}catch(Exception e) {
					throw new DataAccessException("リソースの開放に失敗しました。");
				}
			}
		}

		public int searchRentaledBook(String userId) throws DataAccessException{
			int rentaledBookNum;
			ResultSet rs;
			PreparedStatement st = null;
			if(con == null) {
				getConnection();
			}
			try {
					String sql = "SELECT * FROM Rental WHERE user_id = ? AND rental_return is null;";
					st = con.prepareStatement(sql);
					st.setInt(1, Integer.parseInt(userId));
					rs = st.executeQuery();
					rs.last();
					rentaledBookNum = rs.getRow();
			} catch(Exception e) {
				e.printStackTrace();
				throw new DataAccessException("レコードの操作に失敗しました。");
			} finally {
				try {
					st.close();
					con.close();
				}catch(Exception e) {
					throw new DataAccessException("リソースの開放に失敗しました。");
				}
			}


			return 5 - rentaledBookNum;
		}


}
