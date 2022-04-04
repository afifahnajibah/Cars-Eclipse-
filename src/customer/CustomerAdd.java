package customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.el.parser.ParseException;
 
 /* Servlet implementation class CustomerAdd
 */
 @WebServlet("/CustomerAdd")
 	public class CustomerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	public CustomerAdd() {
	super();
     // TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Customer cs = new Customer();
        //cs.setId(Integer.parseInt(request.getParameter("id")));
		cs.setCustomername(request.getParameter("customername"));
		cs.setCustomeric(request.getParameter("customeric"));
		cs.setCustomerphone(request.getParameter("customerphone"));
		cs.setCustomeraddress(request.getParameter("customeraddress"));
		cs.setCustomeremail(request.getParameter("customeremail"));
		
		CustomerModel cm = new CustomerModel();
		try {
				cm.addCustomer(cs);
			} 				
		
		catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		/*out.println("<html><body><b>Successfully Added" + "</b></body></html>");

		HttpSession session = request.getSession();
		session.setAttribute("status", "loggedin");*/

		response.sendRedirect("custView.jsp");


	}

 }