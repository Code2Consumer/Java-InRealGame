package General;

public class CurrentUser {
	static public int id;
	static public String username, email, password;
	
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		User.id = id;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		User.username = username;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		User.email = email;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		User.password = password;
	}
	
	
}
