package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.database.GadgetDbController;
import model.ProductModel;
import model.ProductModeldata;
import util.stringUtil;

/**
 * Servlet implementation class Addproduct
 */
@WebServlet("/Addproduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50)
public class Addproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private GadgetDbController dbController;

	public Addproduct() {
		super();
		this.dbController = new GadgetDbController();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ProductModeldata> prods = dbController.getAllProducts();

		// Set the products as an attribute in the request
		request.setAttribute("products", prods);

		// Forward the request to the JSP file for display
		request.getRequestDispatcher("/pages/Adminproduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    System.out.println("1234");
	    

	    String computerName = request.getParameter("product_name");
	    double price = 0.0; // Default value in case of null
	    String priceParam = request.getParameter("product_price");
	    if (priceParam != null && !priceParam.trim().isEmpty()) {
	        try {
	            price = Double.parseDouble(priceParam);
	        } catch (NumberFormatException e) {
	            // Handle parsing error
	            e.printStackTrace();
	        }
	    }

	    Part product_image = request.getPart("product_image");
	    System.out.println("image" + product_image);
	    if (product_image != null) {
	        ProductModel productModel = new ProductModel(computerName, price, product_image);

	        String savePath = stringUtil.IMAGE_DIR_SAVE_PATH;
	        String fileName = productModel.getUserImageUrl();
	        if (!fileName.isEmpty() && fileName != null)
	            product_image.write(savePath + fileName);

	        int result = dbController.addProduct(productModel);

	        if (result > 0) {
	            // Product added successfully, redirect to admin page
	        	ArrayList<ProductModeldata> prods = dbController.getAllProducts();

	    		// Set the products as an attribute in the request
	    		request.setAttribute("products", prods);

	    		// Forward the request to the JSP file for display
	    		request.getRequestDispatcher("/pages/Adminproduct.jsp").forward(request, response);

	        } else {
	            // Error adding product, handle accordingly
	        }

	    } else {
	        // Handle the case when user_image is null
	        System.out.println("user_image is null");
	    }
	    

	}


}
