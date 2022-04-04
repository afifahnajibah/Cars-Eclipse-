package vehicle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vehicle.Vehicle;
import vehicle.VehicleModel;

/**
 * Servlet implementation class VehicleAdd
 */
@WebServlet("/VehicleAdd")
public class VehicleAdd extends HttpServlet {
private static final long serialVersionUID = 1L;


public VehicleAdd() {
super();
 // TODO Auto-generated constructor stub
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	Vehicle vh = new Vehicle();
    vh.setCustomerid(Integer.parseInt(request.getParameter("customerid")));
	vh.setCustomername(request.getParameter("customername"));
	vh.setCustomeric(request.getParameter("customeric"));
	vh.setVehiclemodel(request.getParameter("vehiclemodel"));
	vh.setVehiclebrand(request.getParameter("vehiclebrand"));
	vh.setVehiclecolor(request.getParameter("vehiclecolor"));
	vh.setVehicleyear(request.getParameter("vehicleyear"));

	VehicleModel vm = new VehicleModel();
	try {
			vm.addVehicle(vh);
		} 				
	
	catch (SQLException | ClassNotFoundException e) {

		e.printStackTrace();
	}

	PrintWriter out = response.getWriter();
	/*out.println("<html><body><b>Successfully Added" + "</b></body></html>");

	HttpSession session = request.getSession();
	session.setAttribute("status", "loggedin");*/

	response.sendRedirect("vehicleView.jsp");


}

}