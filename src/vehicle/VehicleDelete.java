package vehicle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vehicle.VehicleModel;

/**
 * Servlet implementation class VehicleDelete
 */
@WebServlet("/VehicleDelete")
public class VehicleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleDelete() {
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

    VehicleModel vm = new VehicleModel();
    try {
   	 vm.deleteVehicleById(id);
    	 } catch (SQLException | ClassNotFoundException e) {

    e.printStackTrace();
    	 }


    PrintWriter out = response.getWriter();
    /*out.println("<html><body><b>Successfully Deleted" + "</b></body></html>");

    HttpSession session = request.getSession();
    session.setAttribute("status", "loggedin");*/

    response.sendRedirect("vehicleView.jsp");
	 }

}