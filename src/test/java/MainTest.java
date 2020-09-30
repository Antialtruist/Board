import dao.UserDAO;
import model.User;

public class MainTest {
	
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		user.setFullName("Ivan");
		user.setEmail("qwe@qwe.qwe");
		user.setPhone(20202002);
		userDAO.addUser(user);
		
//		userDAO.deleteUser(3);
	}
}
