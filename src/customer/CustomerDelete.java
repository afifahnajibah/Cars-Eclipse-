package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.CustomerModel;

/**
 * Servlet implementation class CustomerDelete
 */
@WebServlet("/CustomerDelete")
public class CustomerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {


    int id = Integer.parseInt(request.getParameter("id"));

    CustomerModel im = new CustomerModel();
    try {
   	 im.deleteCustomerById(id);
    	 } catch (SQLException | ClassNotFoundException e) {

    e.printStackTrace();
    	 }


    PrintWriter out = response.getWriter();
    /*out.println("<html><body><b>Successfully Deleted" + "</b></body></html>");

    HttpSession session = request.getSession();
    session.setAttribute("status", "loggedin");*/

    response.sendRedirect("custView.jsp");
	 }

}