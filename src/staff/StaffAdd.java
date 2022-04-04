package staff;

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

 /* Servlet implementation class StaffAdd
 */
 @WebServlet("/StaffAdd")
 	public class StaffAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	public StaffAdd() {
	super();
     // TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Staff st = new Staff();
        //st.setStaffid(Integer.parseInt(request.getParameter("id")));
		st.setStaffname(request.getParameter("staffname"));
		st.setStaffic(request.getParameter("staffic"));
		st.setStaffphone(request.getParameter("staffphone"));
		st.setStaffemail(request.getParameter("staffemail"));
		
		StaffModel sm = new StaffModel();
		try {
				sm.addStaff(st);
			} 				
		
		catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		/*out.println("<html><body><b>Successfully Added" + "</b></body></html>");

		HttpSession session = request.getSession();
		session.setAttribute("status", "loggedin");*/

		response.sendRedirect("staffView.jsp");


	}

 }