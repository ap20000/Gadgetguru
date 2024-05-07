package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.GadgetDbController;
import model.AccessoriesUserModel;

@WebServlet("/ProfileUpdateServlet")
public class ProfileUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private GadgetDbController dbController;

    public ProfileUpdateServlet() {
        super();
        this.dbController = new GadgetDbController();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user_Name = request.getParameter("username");
        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String contact_number = request.getParameter("phone_number");
        String address = request.getParameter("address");

        AccessoriesUserModel updatedUser = new AccessoriesUserModel();
        updatedUser.setUser_Name(user_Name);
        updatedUser.setFull_Name(fullName);
        updatedUser.setEmail(email);
        updatedUser.setPhone_Number(contact_number);
        updatedUser.setAddress(address);

        int result = dbController.Profileupdate(updatedUser);
        System.out.println(result);

        if (result == 1) {
            response.sendRedirect(request.getContextPath() + "/pages/Profile.jsp?success=true");
        } else {
            response.sendRedirect(request.getContextPath() + "/pages/Profile.jsp?error=true");
        }
    }

}
