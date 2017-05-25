package ro.jademy.oms.data;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ro.jademy.oms.entity.Book;
import ro.jademy.oms.entity.DVD;
import ro.jademy.oms.entity.Product;

public interface OmsDao {
	void init();

	List<Book> getBooks();

	List<DVD> getDVDs();

	void addNewOrder(int userId, Product... product);

	int showMaxValueForOrder();
}
