package workorder;

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
 @WebServlet("/WorkorderAdd")
 	public class WorkorderAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	public WorkorderAdd() {
	super();
     // TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Workorder wo = new Workorder();
        wo.setStaffid(Integer.parseInt(request.getParameter("staffid")));
        wo.setCustomerid(Integer.parseInt(request.getParameter("customerid")));
        wo.setVehicleid(Integer.parseInt(request.getParameter("vehicleid")));
		wo.setDate(request.getParameter("date"));
		wo.setProblem(request.getParameter("problem"));
		wo.setCauses(request.getParameter("causes"));
		wo.setSolution(request.getParameter("solution"));
		wo.setPayment(Float.parseFloat(request.getParameter("payment")));
		
		WorkorderModel wm = new WorkorderModel();
		try {
				wm.addWorkorder(wo);
			} 				
		
		catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		/*out.println("<html><body><b>Successfully Added" + "</b></body></html>");

		HttpSession session = request.getSession();
		session.setAttribute("status", "loggedin");*/

		response.sendRedirect("workView.jsp");


	}

 }