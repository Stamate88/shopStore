package ro.jademy.oms.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.jademy.oms.entity.Book;
import ro.jademy.oms.entity.DVD;
import ro.jademy.oms.entity.Product;

public class OmsDaoImplMySQL implements OmsDao {

	Connection con;

	public void init() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/OMS", "root", "abc12abc");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("We can't connect to DB");
		}
	}

	public List<Book> getBooks() {
		List<Book> list = new ArrayList<>();
		String sql = "SELECT * FROM Book b, Product p WHERE b.codp = p.codp;";

		try (PreparedStatement stm = con.prepareStatement(sql); ResultSet rez = stm.executeQuery()) {
			while (rez.next()) {
				list.add(new Book(rez.getString("title"), rez.getString("category"), rez.getString("authors"),
						rez.getInt("pages"), rez.getDouble("cost"), rez.getInt("stock"), rez.getInt("p.codp")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Select not good!!");
		}
		// finally {
		// // TODO: try with resources!!!!!
		// if (rez != null) {
		// try {
		// rez.close();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// }
		// if (stm != null) {
		// try {
		// stm.close();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// }

		return null;
	}

	public List<DVD> getDVDs() {
		List<DVD> list = new ArrayList<>();
		String sql = "SELECT * FROM DVD d, Product p WHERE d.codp = p.codp;";
		PreparedStatement stm = null;
		ResultSet rez = null;
		try {
			stm = con.prepareStatement(sql);
			rez = stm.executeQuery();
			while (rez.next()) {
				list.add(new DVD(rez.getString("title"), rez.getString("category"), rez.getString("director"),
						rez.getInt("length"), rez.getDouble("cost"), rez.getInt("stock"), rez.getInt("p.codp")));
				// for (int i = 1; i < 8; i++) {
				// System.out.print(rez.getString(i) + "\t");
				// }
				// System.out.println();
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Select not good!!");
		} finally {
			// TODO: try with resources!!!!!
			if (rez != null) {
				try {
					rez.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public void addNewOrder(int userId, Product... product) {
		// System.out.println("val maxima din baza de date " + showMaxValue());
		String sql1 = "INSERT INTO ORDER_CLIENT (userId) values(?)";
		String sql2 = "INSERT INTO SALES values(?, ?)";
		try (PreparedStatement stm1 = con.prepareStatement(sql1); PreparedStatement stm2 = con.prepareStatement(sql2)) {
			stm1.setInt(1, userId);
			stm1.executeUpdate();
			for (int i = 0; i < product.length; i++) {
				stm2.setInt(1, product[i].getCode());
				stm2.setInt(2, showMaxValueForOrder()); // maximul de pe coloana
				stm2.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// TODO: check and run!!!
		// UPDATE FROM PRODUCT SET STOCK = STOCK - 1 WHERE codp =
		// product.getCode()

	}

	public int showMaxValueForOrder() {
		String sql = "Select max(codo) from order_client ";

		try (PreparedStatement stm = con.prepareStatement(sql); ResultSet rez = stm.executeQuery();) {
			if (rez.next()) {
				return rez.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// intoarcem cod de eroare
		return -1;
		// throw new RuntimeException("Blabalba...");
	}

}
