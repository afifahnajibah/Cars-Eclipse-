package workorder;

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
 * Servlet implementation class WorkorderUpdate
 */
@WebServlet("/WorkorderUpdate")
public class WorkorderUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkorderUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Workorder wo = new Workorder();
		
		wo.setWorkorderid(Integer.parseInt(request.getParameter("workorderid")));
		wo.setStaffid(Integer.parseInt(request.getParameter("staffid")));
		wo.setCustomerid(Integer.parseInt(request.getParameter("customerid")));
		wo.setVehicleid(Integer.parseInt(request.getParameter("vehicleid")));
		wo.setDate(request.getParameter("date"));
		wo.setProblem(request.getParameter("problem"));
		wo.setCauses(request.getParameter("causes"));
		wo.setSolution(request.getParameter("solution"));
		wo.setSolution(request.getParameter("payment"));
	
			WorkorderModel wm = new WorkorderModel();
			try {
					wm.updateWorkorder(wo);
				} 				
			
			catch (SQLException | ClassNotFoundException e) {

				e.printStackTrace();
			}

			
			PrintWriter out = response.getWriter();
			/*out.println("<html><body><b>Successfully Updated" + "</b></body></html>");

			HttpSession session = request.getSession();
			session.setAttribute("status", "loggedin");*/

			response.sendRedirect("workView.jsp");

	}

}
