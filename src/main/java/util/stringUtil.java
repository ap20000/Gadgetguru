package util;

import java.io.File;

public class stringUtil {

	public static final String INSERT_NEW_User = "INSERT INTO user "
	        + "(user_Name, full_Name, email, phone_Number, dob, address, password, gender,user_Image,role)"
	        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
	 public static final String INSERT_Product = "INSERT INTO computer (computer_name, price, brand, product_image) VALUES (?, ?, ?, ?)";

	public static final String GET_LOGIN_USER_INFO = "SELECT * FROM user WHERE user_Name = ?";
	
	public static final String GET_PROFILE_USER_INFO = "SELECT * FROM user WHERE user_Name = ?";
	public static final String UPDATE_PROFILE_USER_INFO ="UPDATE user SET full_Name=?, email=?, phone_Number=?, address=? WHERE user_Name=?";
	public static final String UPDATE_USER_PASSWORD_INFO="UPDATE user SET password = ? WHERE user_Name = ?";
	public static final String DELETE_PRODUCT_INFO="DELETE FROM computer WHERE computer_Id = ?";
	public static final String IMAGE_DIR_USER = "Users\\NITRO5\\eclipse-workspace\\GadgetGuru_Accessories\\src\\main\\webapp\\resources\\images\\user\\";
	public static final String IMAGE_DIR_SAVE_PATH = "C:" + File.separator + IMAGE_DIR_USER;
	public static final String INSERT_PRODUCT_INFO="INSERT INTO computer (computer_name, price,  product_image) VALUES (?, ?,  ?)";
	public static final String GET_ALLPRODUCT_INFO="SELECT * FROM computer";
	public static final String UPDATE_ALLPRODUCT_INFO="UPDATE computer SET computer_name = ?, price = ? WHERE computer_Id = ?";
	public static final String GET_USER_PHONE_INFO="SELECT COUNT(*) FROM user WHERE phone_Number = ?";
	public static final String GET_USER_EMAIL_INFO="SELECT COUNT(*) FROM user WHERE email = ?";
	public static final String GET_USER_USERNAME_INFO="SELECT COUNT(*) FROM user WHERE user_Name = ?";

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

    public static final String confirm_new_password = "confirmnewpassword";
    
    
   

 		// Register Page Messages
 	public static final String SUCCESS_MESSAGE_REGISTER = "Successfully Registered!";
 	public static final String ERROR_MESSAGE_REGISTER = "Please correct the form data.";

 	public static final String MESSAGE_ERROR_EMAIL_VALID = "Email is already in usage. Kindly send emails from a different address.";
 	public static final String MESSAGE_ERROR_PHONE_NUMBER_LENGHT = "Unvalid phone number. The phone number has to have ten characters.";
 	public static final String MESSAGE_ERROR_PHONE_NUMBER_VALID = "Number is already in place. Kindly call from a different number.";
 	public static final String MESSAGE_ERROR_PASSWORD_VALID = "Password not valid. A minimum of one lowercase letter and one digit are required in the password.";
 	public static final String MESSAGE_ERROR_PASSWORD_LENGTH = "Invalid Password. Please type more than six words.";
 	public static final String MESSAGE_ERROR_PASSWORD_UNMATCHED = "Password and Confirm The passwords don't match.";
 	public static final String MESSAGE_ERROR_USERNAME_INVALID = "Unvalid username. Please enter more than six characters.";
 	public static final String MESSAGE_ERROR_USERNAME_INVALID_LENGTH = "Unvalid username. Please enter more than six characters.";
 	public static final String MESSAGE_ERROR_USERNAME_EXISTS = "Username is already in use. Kindly select an other username.";
 	public static final String MESSAGE_ERROR_FULLNAME_SYMBOL = "Not Valid full  name. Please refrain from entering numbers and symbols.";
 	public static final String MESSAGE_ERROR_BIRTHDATE_VALID = "Invalid birthday date.";
 	
 	
 	
 	// Login Page Messages
 	public static final String MESSAGE_SUCCESS_LOGIN = "Successfully LoggedIn!";
 	public static final String MESSAGE_ERROR_LOGIN = "Either username or password is not correct!";
 	public static final String MESSAGE_ERROR_CREATE_ACCOUNT = "Username not found. Please register.";
 	public static final String MESSAGE_ERROR_USERNAME_LENGTH = "Invalid User name. Please enter more than 6 characters";
 	public static final String MESSAGE_ERROR_USERNAME_INVALIDL = "Invalid User name. Please don't enter symbols.";
 	
 	
 	//AdminAddproduct
 	public static final String MESSAGE_COMPUTERNAME_INVALID = "Invalid product name. Product name should only contain letters and spaces.";
 	public static final String MESSAGE_PRICE_INVALID = "Invalid price. Price should be a number.";
 	public static final String MESSAGE_PRICE = "Price is required.";
 	public static final String MESSAGE_ADDPRODUCT_SUCCESS = "Product Add successfully.";
 	public static final String MESSAGE_ADDPRODUCT_ERROR = "Product Add successfully.";
 	public static final String MESSAGE_EDITPRODUCT_SUCCESS = "Product edit successfully.";
 	public static final String MESSAGE_EDITPRODUCT_ERROR = "Product edit unsuccessfully.";
	public static final String MESSAGE_DELETEPRODUCT_SUCCESS = "Product Delete successfully.";
 	
 	// Other Messages
 	public static final String MESSAGE_ERROR_SERVER = "An unexpected error occurred. Please try again later.";
 	public static final String MESSAGE_SUCCESS_DELETE = "Successfully Deleted!";
 	public static final String MESSAGE_ERROR_DELETE = "Cannot delete the user!";

 	public static final String MESSAGE_SUCCESS = "successMessage";
 	public static final String MESSAGE_ERROR = "errorMessage";
 	// End: Validation Messages
 	
 	public static final String URL_PAGE_LOGIN = "/pages/login.jsp";
	public static final String URL_PAGE_REGISTER = "/pages/register.jsp";
	public static final String URL_PAGE_HOME = "/pages/home.jsp";
	public static final String URL_PAGE_FOOTER = "pages/footer.jsp";
	public static final String URL_PAGE_HEADER = "pages/header.jsp";
	public static final String URL_PAGE_FORGETPASSWORD = "pages/header.jsp";
	public static final String URL_PAGE_CONTACT = "pages/header.jsp";
	public static final String URL_PAGE_ABOUT = "pages/header.jsp";
	public static final String URL_LANDINGPAGE = "/landingpage.jsp";
	public static final String PAGE_URL_DASHBOARD = "/pages/Dashboard.jsp";
	public static final String PAGE_URL_ADMINPRODUCT = "/pages/adminproduct.jsp";
	public static final String PAGE_URL_UPDATEPRODUCT = "/pages/upadteproduct.jsp";
//	public static final String PAGE_URL_UPDATEPRODUCT = "/pages/Dashboard.jsp";
//	public static final String PAGE_URL_UPDATEPROFILE = "/pages/Dashboard.jsp";
//	public static final String PAGE_URL_PROFILE = "/pages/Dashboard.jsp";
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
