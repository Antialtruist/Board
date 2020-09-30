package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Util.dbConnection;
import model.User;

public class UserDAO {

	private Connection connection;

	public UserDAO() {
		connection = dbConnection.getConnection();
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(fullname, email, phone) values (?, ?, ?)");
			preparedStatement.setString(1, user.getFullName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(3, user.getPhone());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int ID) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id = ?");
			preparedStatement.setInt(1, ID);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set fullname = ?, email = ?, phone = ?" + "where id = ?");
			preparedStatement.setString(1, user.getFullName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(3, user.getPhone());
			preparedStatement.setInt(4, user.getID());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				User user = new User();
				user.setID(rs.getInt("id"));
				user.setFullName(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getInt("phone"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User getUserById(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setID(rs.getInt("id"));
				user.setFullName(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getInt("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
