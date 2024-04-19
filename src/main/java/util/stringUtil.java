package util;

import java.io.File;

public class stringUtil {

	public static final String INSERT_User = "INSERT INTO user "
	        + "(user_name, full_name, email, phone_number, dob, address, password, gender,user_image,role)"
	        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";

	public static final String GET_LOGIN_STUDENT_INFO = "SELECT * FROM user WHERE user_name = ?";
	
	public static final String IMAGE_DIR_USER = "Users\\NITRO5\\eclipse-workspace\\GadgetGuru_Accessories\\src\\main\\webapp\\resources\\images\\user\\";
	public static final String IMAGE_DIR_SAVE_PATH = "C:" + File.separator + IMAGE_DIR_USER;
	
	
	public static final String user_name = "username";
    public static final String full_name = "fullName";
    public static final String email = "email";
    public static final String phone_number = "phoneNumber";
    public static final String dobString = "birthdate";
    public static final String address = "address";

    public static final String password = "password";
    public static final String confirm_password = "confirmpassword";
    public static final String gender = "gender";
   
 // Start: Validation Messages
 		// Register Page Messages
 	public static final String MESSAGE_SUCCESS_REGISTER = "Successfully Registered!";
 	public static final String MESSAGE_ERROR_REGISTER = "Please correct the form data.";
 	public static final String MESSAGE_ERROR_USERNAME = "Username is already registered.";
 	public static final String MESSAGE_ERROR_EMAIL = "Email is already registered.";
 	public static final String MESSAGE_ERROR_PHONE_NUMBER = "Phone number is already registered.";
 	public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password is not matched.";

 	// Login Page Messages
 	public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
 	public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
 	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Account for this username is not registered! Please create a new account.";

 	// Other Messages
 	public static final String MESSAGE_ERROR_SERVER = "An unexpected server error occurred.";
 	public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
 	public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";

 	public static final String MESSAGE_SUCCESS = "successMessage";
 	public static final String MESSAGE_ERROR = "errorMessage";
 	// End: Validation Messages
 	
 	public static final String PAGE_URL_LOGIN = "/pages/login.jsp";
	public static final String PAGE_URL_REGISTER = "/pages/register.jsp";
	public static final String PAGE_URL_WELCOME = "/pages/welcome.jsp";
	public static final String PAGE_URL_FOOTER = "pages/footer.jsp";
	public static final String PAGE_URL_HEADER = "pages/header.jsp";
	public static final String URL_LOGIN = "/login.jsp";
	public static final String URL_INDEX = "/index.jsp";
	// End: JSP Route

	// Start: Servlet Route
	public static final String SERVLET_URL_LOGIN = "/login";
	public static final String SERVLET_URL_REGISTER = "/registerstudent";
	public static final String SERVLET_URL_LOGOUT = "/logout";
	// End: Servlet Route
	
	public static final String USER = "user";
	public static final String JSESSIONID = "JSESSIONID";
	public static final String LOGIN = "Login";
	public static final String LOGOUT = "Logout";

}
