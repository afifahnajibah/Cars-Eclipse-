package vehicle;

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
@WebServlet("/VehicleUpdate")
public class VehicleUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Vehicle vh = new Vehicle ();
		
		vh.setVehicleid(Integer.parseInt(request.getParameter("vehicleid")));
		vh.setCustomerid(Integer.parseInt(request.getParameter("customerid")));
		vh.setCustomername(request.getParameter("customername"));
		vh.setCustomeric(request.getParameter("customeric"));
		vh.setVehiclemodel(request.getParameter("vehiclemodel"));
		vh.setVehiclebrand(request.getParameter("vehiclebrand"));
		vh.setVehiclecolor(request.getParameter("vehiclecolor"));
		vh.setVehicleyear(request.getParameter("vehicleyear"));
						
 
			VehicleModel vm = new VehicleModel();
			try {
					vm.updateVehicle(vh);
				} 				
			
			catch (SQLException | ClassNotFoundException e) {

				e.printStackTrace();
			}

			
			PrintWriter out = response.getWriter();
			/*out.println("<html><body><b>Successfully Updated" + "</b></body></html>");

			HttpSession session = request.getSession();
			session.setAttribute("status", "loggedin");*/

			response.sendRedirect("vehicleView.jsp");

	}

}
