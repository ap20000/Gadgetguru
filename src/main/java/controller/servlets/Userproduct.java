package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.GadgetDbController;
import model.ProductModeldata;

/**
 * Servlet implementation class Userproduct
 */
@WebServlet("/Userproduct")
public class Userproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private GadgetDbController dbController;
    public Userproduct() {
    	super();
		this.dbController = new GadgetDbController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ProductModeldata> prods = dbController.getAllProducts();

		// Set the products as an attribute in the request
		request.setAttribute("products", prods);

		// Forward the request to the JSP file for display
		request.getRequestDispatcher("${pageContext.request.contextPath}/pages/userproduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
