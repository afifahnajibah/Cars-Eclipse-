package customer;

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

/**
 * Servlet implementation class CustomerUpdate
 */
@WebServlet("/CustomerUpdate")
public class CustomerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Customer cs = new Customer();
		cs.setCustomerid(Integer.parseInt(request.getParameter("customerid")));
		cs.setCustomername(request.getParameter("customername"));
		cs.setCustomeric(request.getParameter("customeric"));
		cs.setCustomerphone(request.getParameter("customerphone"));
		cs.setCustomeraddress(request.getParameter("customeraddress"));
		cs.setCustomeremail(request.getParameter("customeremail"));
						
 
			CustomerModel cm = new CustomerModel();
			try {
					cm.updateCustomer(cs);
				} 				
			
			catch (SQLException | ClassNotFoundException e) {

				e.printStackTrace();
			}

			
			PrintWriter out = response.getWriter();
			/*out.println("<html><body><b>Successfully Updated" + "</b></body></html>");

			HttpSession session = request.getSession();
			session.setAttribute("status", "loggedin");*/

			response.sendRedirect("custView.jsp");

	}

}
