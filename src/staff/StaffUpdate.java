package staff;

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
 * Servlet implementation class StaffUpdate
 */
@WebServlet("/StaffUpdate")
public class StaffUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Staff st = new Staff();
		
		st.setStaffid(Integer.parseInt(request.getParameter("staffid")));
		st.setStaffname(request.getParameter("staffname"));
		st.setStaffic(request.getParameter("staffic"));
		st.setStaffphone(request.getParameter("staffphone"));
		st.setStaffemail(request.getParameter("staffemail"));
 
			StaffModel sm = new StaffModel();
			try {
					sm.updateStaff(st);
				} 				
			
			catch (SQLException | ClassNotFoundException e) {

				e.printStackTrace();
			}

			
			PrintWriter out = response.getWriter();
			/*out.println("<html><body><b>Successfully Updated" + "</b></body></html>");

			HttpSession session = request.getSession();
			session.setAttribute("status", "loggedin");*/

			response.sendRedirect("staffView.jsp");

	}

}
