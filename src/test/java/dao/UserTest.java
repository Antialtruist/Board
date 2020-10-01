package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.UserDAO;
import model.User;

class UserTest {
	
//	private UserDAO userDAO;
	
//	@BeforeAll
//	drop base data
	
	@Test
	void addUserTest() throws SQLException {
		UserDAO userDAO = new UserDAO();
		User expected = new User();
		expected.setID(5);
		expected.setFullName("Marshal");
		expected.setEmail("mandm@qwe.qwe");
		expected.setPhone(245822777);
        userDAO.addUser(expected);
        
        User actual = userDAO.getUserById(5);
        
        Assertions.assertEquals(expected, actual);
	}
	
//	@Test
//	public void deleteUserTest() {
//		Assertions.assertTrue(userDAO.deleteUser(1));
//	}
	
//	private List<User> addUsersToDB() {
//        User user1 = new User();
//        user1.setFullName("Ivan");
//		user1.setEmail("ivan@qwe.qwe");
//		user1.setPhone(9379992);
//        userDAO.addUser(user1);
//
//        User user2 = new User();
//        user2.setFullName("Sam");
//		user2.setEmail("sam@qwe.qwe");
//		user2.setPhone(585515);
//        userDAO.addUser(user2);
//        
//        User user3 = new User();
//        user3.setFullName("Dean");
//		user3.setEmail("dean@qwe.qwe");
//		user3.setPhone(515555);
//        userDAO.addUser(user3);
//
//        return new ArrayList<User>() {{
//            add(user1);
//            add(user2);
//            add(user3);
//        }};
//    }
//	
//	@Test
//	void deleteUserTest() throws SQLException {
//		List<User> usersList = addUsersToDB();
//		userDAO.deleteUser(1);
//		
//		List<User> expected = usersList.subList(0, 2);
//		List<User> actual = userDAO.getAllUsers();
//		
//		Assertions.assertEquals(expected, actual);
//	}
//	
//	@Test
//	void getAllUsersTest() throws SQLException {
//		List<User> expected = addUsersToDB();
//		List<User> actual = userDAO.getAllUsers();
//		Assertions.assertEquals(expected, actual);
//	}
//	
//	@Test
//	void getAllUserByIdTest() throws SQLException {
//		User expected = addUsersToDB().get(0);
//		User actual = userDAO.getUserById(1);
//		Assertions.assertEquals(expected, actual);
//	}
}
