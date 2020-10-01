package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Util.dbConnection;
import model.Advertisement;

public class AdvertisementDAO {

	private Connection connection;

	public AdvertisementDAO() {
		connection = dbConnection.getConnection();
	}

	public void addAdvertisement(Advertisement adv) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into advertisement(title, description, created, user_id) values (?, ?, ?, ?)");
			preparedStatement.setString(1, adv.getTitle());
			preparedStatement.setString(2, adv.getDescription());
			preparedStatement.setDate(3, new Date(adv.getCreated().getTime()));
			preparedStatement.setInt(4, adv.getUserID());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAdvertisement(int advID) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from advertisement where adv_id = ?");
			preparedStatement.setInt(1, advID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateAdvertisement(Advertisement adv) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update advertisement set title = ?, description = ?, edited = ?" + "where user_id = ?");
			preparedStatement.setString(1, adv.getTitle());
			preparedStatement.setString(2, adv.getDescription());
			preparedStatement.setDate(3, new Date(adv.getEdited().getTime()));
			preparedStatement.setInt(4, adv.getUserID());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Advertisement> getAllAdvertisements() {
		List<Advertisement> advs = new ArrayList<Advertisement>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from advertisement");
			while (rs.next()) {
				Advertisement adv = new Advertisement();
				adv.setAdvID(rs.getInt("adv_id"));
				adv.setTitle(rs.getString("title"));
				adv.setDescription(rs.getString("description"));
				adv.setCreated(rs.getDate("created"));
				adv.setEdited(rs.getDate("edited"));
				adv.setUserID(rs.getInt("user_id"));
				advs.add(adv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return advs;
	}

	public Advertisement getAdvertisementByUserID(int userID) {
		Advertisement adv = new Advertisement();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from advertisement where user_id = ?");
			preparedStatement.setInt(1, userID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				adv.setAdvID(rs.getInt("adv_id"));
				adv.setTitle(rs.getString("title"));
				adv.setDescription(rs.getString("description"));
				adv.setCreated(rs.getDate("created"));
				adv.setEdited(rs.getDate("edited"));
				adv.setUserID(rs.getInt("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adv;
	}
}