package controller.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.GadgetDbController;

/**
 * Servlet implementation class EditAccessoriesServlet
 */
@WebServlet("/EditAccessoriesServlet")
public class EditAccessoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GadgetDbController dbController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccessoriesServlet() {
        super();
        this.dbController = new GadgetDbController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("computer_Id");
        String productName = request.getParameter("computer_Name");
        String price = request.getParameter("price");
     

        // Set attributes to forward to the JSP
        request.setAttribute("computer_Id", productId);
        request.setAttribute("computer_Name", productName);
        request.setAttribute("price", price);
       

        // Forward to the JSP for editing
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/Updateproduct.jsp");
        dispatcher.forward(request, response);
	}

}
