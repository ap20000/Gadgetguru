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
import model.UserModel;
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
		String user_name = request.getParameter(stringUtil.user_name);
		System.out.println("username"+user_name);
		String full_name = request.getParameter(stringUtil.full_name);
		String email = request.getParameter(stringUtil.email);
		String phone_number = request.getParameter(stringUtil.phone_number);
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
		String address = request.getParameter(stringUtil.address);
		String password = request.getParameter(stringUtil.password);
		String gender = request.getParameter(stringUtil.gender);

		Part user_image = request.getPart("user_image");

		UserModel user = new UserModel(user_name, full_name, email, phone_number, dob, address, password, gender,
				user_image,
				"user");

		String savePath = stringUtil.IMAGE_DIR_SAVE_PATH;
		String fileName = user.getUserImageUrl();
		if (!fileName.isEmpty() && fileName != null)
			user_image.write(savePath + fileName);

		System.out.println(user.getUserImageUrl());
		int result = dbController.addUser(user);

		if (result == 1) {
			request.setAttribute(stringUtil.MESSAGE_SUCCESS_REGISTER, stringUtil.MESSAGE_SUCCESS_REGISTER);
			response.sendRedirect(request.getContextPath() + stringUtil.PAGE_URL_LOGIN);
		} else if (result == 0) {
			// No rows affected
			request.setAttribute(stringUtil.MESSAGE_ERROR, "Registration failed. Please try again.");
			request.getRequestDispatcher(stringUtil.PAGE_URL_REGISTER).forward(request, response);
		} else if (result == -1) {
			// Error occurred
			request.setAttribute(stringUtil.MESSAGE_ERROR, "An unexpected error occurred. Please try again later.");
			request.getRequestDispatcher(stringUtil.PAGE_URL_REGISTER).forward(request, response);
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
