package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.GadgetDbController;
import model.ProductModeldata;
import util.stringUtil;

/**
 * Servlet implementation class UpdateAccessoriesServlet
 */
@WebServlet("/UpdateAccessoriesServlet")
public class UpdateAccessoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private GadgetDbController dbController;
    public UpdateAccessoriesServlet() {
        super();
        this.dbController = new GadgetDbController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("computer_Id");
        String productName = request.getParameter("computer_Name");
        String pricea = request.getParameter("price");
        

        // Parse price from string to double
        double price = 0.0;
        try {
            if (pricea != null && !pricea.isEmpty()) {
                price = Double.parseDouble(pricea);
            }
        } catch (NumberFormatException e) {
            // Handle the case where price is not a valid double
            e.printStackTrace(); // Log the exception
            response.sendRedirect(request.getContextPath() + stringUtil.PAGE_URL_ADMINPRODUCT);
            return; // Exit the method to avoid further processing
        }

        
        if (productId == null || productId.isEmpty()) {
            // Handle the case where helmetId is null or empty
            response.sendRedirect(request.getContextPath() + stringUtil.PAGE_URL_ADMINPRODUCT);
            return; // Exit the method to avoid further processing
        }

        // Update the database with the new values
        int result = dbController.updateAccessories(
                new ProductModeldata(Integer.parseInt(productId), productName, price,null));

        // Redirect back to the original JSP page with success or error message
        if (result == 1) {
            request.setAttribute("errorMessage",stringUtil.MESSAGE_EDITPRODUCT_SUCCESS );
            response.sendRedirect(request.getContextPath()+stringUtil.PAGE_URL_ADMINPRODUCT);
        } else {
        	 request.setAttribute("errorMessage",stringUtil.MESSAGE_EDITPRODUCT_ERROR );
        	 request.getRequestDispatcher(stringUtil.PAGE_URL_UPDATEPRODUCT).forward(request, response);
        }
	}

}
