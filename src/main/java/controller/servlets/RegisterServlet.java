// RegisterServlet.java
package controller.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.GadgetDbController;
import model.AccessoriesUserModel;
import util.stringUtil;

@WebServlet(urlPatterns = "/RegisterServlet")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GadgetDbController dbController;

	public RegisterServlet() {
		super();
		dbController = new GadgetDbController();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().println("GET request received");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_Name = request.getParameter(stringUtil.user_name);
		if (user_Name.length() <= 6) {
     
            request.setAttribute( "errorMessage",stringUtil.MESSAGE_ERROR_USERNAME_INVALID);
            request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
            return;
        }

        if (!user_Name.matches("^[a-zA-Z0-9]{6,}$")) {

            request.setAttribute("errorMessage",stringUtil.MESSAGE_ERROR_USERNAME_INVALID_LENGTH );
            request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
            return;
        }
        if (dbController.UsernameExists(user_Name)) {
   
            request.setAttribute("errorMessage",stringUtil.MESSAGE_ERROR_USERNAME_EXISTS );
            request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
            return;
        }
		System.out.println("username"+user_Name);
		String full_Name = request.getParameter(stringUtil.full_name);
		if (!isValidName(full_Name)) {

            request.setAttribute("errorMessage",stringUtil.MESSAGE_ERROR_FULLNAME_SYMBOL );
            request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
            return;
        }
		String email = request.getParameter(stringUtil.email);
		if (dbController.EmailExists(email)) {
        
            request.setAttribute("errorMessage",stringUtil.MESSAGE_ERROR_EMAIL_VALID );
            request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
            return;
        }
		String phone_Number = request.getParameter(stringUtil.phone_number);
		if (phone_Number.length() != 10) {
            request.setAttribute( "errorMessage",stringUtil.MESSAGE_ERROR_PHONE_NUMBER_LENGHT);
            request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
            return;
        }
		if (dbController.PhoneNumberExists(phone_Number)) {
            
            request.setAttribute(" errorMessage",stringUtil.MESSAGE_ERROR_PHONE_NUMBER_VALID);
            request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
            return;
        }
		String dobString = request.getParameter(stringUtil.dobString);
		
	     // Initialize dob variable
	     // Initialize dob variable
	        LocalDate dob;

	        // Check if dobString is null or empty
	        if (dobString == null || dobString.isEmpty()) {
	            System.out.println("Date of birth is null or empty");
	            response.sendRedirect(request.getContextPath() + "/pages/register.html?error=invalid_date_format");
	            return; // Exit the method to prevent further processing
	        }

	        // Define the date format using DateTimeFormatter
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        try {
	            // Parse the dobString into a LocalDate object using the specified formatter
	            dob = LocalDate.parse(dobString, formatter);
	        } catch (DateTimeParseException e) {
	            // Handle invalid date format
	            System.out.println("Error parsing date: " + e.getMessage());
	            response.sendRedirect(request.getContextPath() + "/pages/register.html?error=invalid_date_format");
	            return; // Exit the method to prevent further processing
	        }
	        if (dob.isAfter(LocalDate.now())) {
	            request.setAttribute("error message",stringUtil.MESSAGE_ERROR_BIRTHDATE_VALID );
	            request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
	            return;
	        }
		String address = request.getParameter(stringUtil.address);
		String password = request.getParameter(stringUtil.password);
		if (!password.matches("^(?=.*[a-z])(?=.*\\d).{5,}$")) {
            request.setAttribute("errorMessage ",stringUtil.MESSAGE_ERROR_PASSWORD_LENGTH
                    );
            request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
            return;
        }


        if (password.length() <= 6) {
            
            request.setAttribute("errorMessage",stringUtil.MESSAGE_ERROR );
            request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
            return;
        }
		String gender = request.getParameter(stringUtil.gender);

		Part user_image = request.getPart("user_image");
	
        String confirmPassword = request.getParameter("confirmpassword");
        if (!password.equals(confirmPassword)) { 
           
         request.setAttribute( "errorMessage",stringUtil.MESSAGE_ERROR_PASSWORD_UNMATCHED);
         request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request,
         response); return; }
         
        
        
  
        

		AccessoriesUserModel user = new AccessoriesUserModel(user_Name, full_Name, email, phone_Number, dob, address, password, gender,
				user_image,
				"user");

		String savePath = stringUtil.IMAGE_DIR_SAVE_PATH;
		String fileName = user.getUserImageUrl();
		if (!fileName.isEmpty() && fileName != null)
			user_image.write(savePath + fileName);

		System.out.println(user.getUserImageUrl());
		int result = dbController.AddUserNew(user);

		if (result == 1) {
			request.setAttribute(stringUtil.SUCCESS_MESSAGE_REGISTER, stringUtil.SUCCESS_MESSAGE_REGISTER);
			response.sendRedirect(request.getContextPath() + stringUtil.URL_PAGE_LOGIN);
		} else if (result == 0) {
			// No rows affected
			request.setAttribute( "errorMessage",stringUtil.ERROR_MESSAGE_REGISTER);
			request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
		} else if (result == -1) {
			// Error occurred
			request.setAttribute("errorMessage",stringUtil.MESSAGE_ERROR );
			request.getRequestDispatcher(stringUtil.URL_PAGE_REGISTER).forward(request, response);
		}

	}

	
	private boolean isValidName(String name) {
		for (char c : name.toCharArray()) {
			if (!Character.isLetter(c) && c != ' ') {
				return false;
			}
		}
		return true;
	}
}