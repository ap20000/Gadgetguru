package util;

import java.io.File;

public class stringUtil {

	public static final String INSERT_User = "INSERT INTO user "
	        + "(user_Name, full_Name, email, phone_Number, dob, address, password, gender,user_Image,role)"
	        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
	 public static final String INSERT_Product = "INSERT INTO computer (computer_name, price, brand, product_image) VALUES (?, ?, ?, ?)";

	public static final String GET_LOGIN_STUDENT_INFO = "SELECT * FROM user WHERE user_Name = ?";
	
	
	
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
    public static final String role = "role";
    
   
 // Start: Validation Messages
 		// Register Page Messages
 	public static final String SUCCESS_MESSAGE_REGISTER = "Successfully Registered!";
 	public static final String ERROR_MESSAGE_REGISTER = "Please correct the form data.";
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
 	
 	public static final String URL_PAGE_LOGIN = "/pages/login.jsp";
	public static final String URL_PAGE_REGISTER = "/pages/register.jsp";
	public static final String URL_PAGE_HOME = "/pages/.jsp";
	public static final String URL_PAGE_FOOTER = "pages/footer.jsp";
	public static final String URL_PAGE_HEADER = "pages/header.jsp";
	public static final String URL_PAGE_FORGETPASSWORD = "pages/header.jsp";
	public static final String URL_PAGE_CONTACT = "pages/header.jsp";
	public static final String URL_PAGE_ABOUT = "pages/header.jsp";
	public static final String URL_LANDINGPAGE = "/landingpage.jsp";
	public static final String PAGE_URL_DASHBOARD = "/pages/Dashboard.jsp";
	public static final String PAGE_URL_ADMINPRODUCT = "/pages/Dashboard.jsp";
	public static final String PAGE_URL_USERPRODUCT = "/pages/Dashboard.jsp";
	public static final String PAGE_URL_UPDATEPRODUCT = "/pages/Dashboard.jsp";
	public static final String PAGE_URL_UPDATEPROFILE = "/pages/Dashboard.jsp";
	public static final String PAGE_URL_PROFILE = "/pages/Dashboard.jsp";
	// End: JSP Route

	// Start: Servlet Route
	public static final String SERVLET_URL_LOGIN = "/LoginServlet";
	public static final String SERVLET_URL_REGISTER = "/RegisterServlet";
	public static final String SERVLET_URL_LOGOUT = "/LogoutServlet";
	// End: Servlet Route
	
	public static final String USER = "user";
	public static final String JSESSIONID = "JSESSIONID";
	public static final String LOGIN = "Login";
	public static final String LOGOUT = "Logout";

}
