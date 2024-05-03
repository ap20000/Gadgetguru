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
 * Servlet implementation class ProductChange
 */
@WebServlet("/ProductChange")
public class ProductChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     */
	private GadgetDbController dbController;
    public ProductChange() {
        super();
        this.dbController = new GadgetDbController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String deleteIdString = request.getParameter("delete_id");
        //String updateIdString = request.getParameter("updateId");

        if (deleteIdString != null && !deleteIdString.isEmpty()) {
            int deleteId = Integer.parseInt(deleteIdString);
            dbController.deletegadgetguru(deleteId);
            System.out.println("Deleted");
            
            ArrayList<ProductModeldata> prods = dbController.getAllProducts();

    		// Set the products as an attribute in the request
    		request.setAttribute("products", prods);

    		// Forward the request to the JSP file for display
    		request.getRequestDispatcher("/pages/Adminproduct.jsp").forward(request, response);
        }
	}

}
