package vehicle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vehicle.Vehicle;

public class VehicleModel {

    private Statement statement;
    private PreparedStatement ps;
    private static Connection connection;


    public VehicleModel() {
      
    }

    public static void initJDBC() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        // Connect to a database
       connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/cars" , "root", "");
        System.out.println("Database connected");
    }

    public ArrayList<Vehicle> viewVehicle() throws ClassNotFoundException, SQLException
    {
        initJDBC();

        ArrayList<Vehicle> vhList = null;

        try {


           vhList = new ArrayList<Vehicle>();

            Statement statement = connection.createStatement();

            // Execute a statement
            ResultSet rs = statement.executeQuery("SELECT * FROM vehicle");

            while(rs.next()){

                Vehicle vh = new Vehicle();

                vh.setVehicleid(rs.getInt("vehicleid"));
                vh.setCustomerid(rs.getInt("customerid"));
                vh.setCustomername(rs.getString("customername"));
                vh.setCustomeric(rs.getString("customeric"));
                vh.setVehiclemodel(rs.getString("vehiclemodel"));
                vh.setVehiclebrand(rs.getString("vehiclebrand"));
                vh.setVehiclecolor(rs.getString("vehiclecolor"));
                vh.setVehicleyear(rs.getString("vehicleyear"));
             
                vhList.add(vh);

            }
        }

        catch (Exception ex) {

            System.out.println("viewVehicle():"+ ex);
            ex.printStackTrace();
        }

        //connection.close();
        return vhList;
    } 



    public Vehicle getVehicleById(int id){
    	Vehicle vehi = new Vehicle();
    	try{
    		this.initJDBC();
    		String query = ("SELECT * from vehicle WHERE  vehicleid = ?");
 	        PreparedStatement ps = connection.prepareStatement(query);
 	        ps.setInt(1,id);

 	        ResultSet rs = ps.executeQuery();

 	        while (rs.next()){
 	        	vehi.setVehicleid(rs.getInt("vehicleid"));
 	        	vehi.setCustomerid(rs.getInt("customerid"));
                vehi.setCustomername(rs.getString("customername"));
                vehi.setCustomeric(rs.getString("customeric"));
                vehi.setVehiclemodel(rs.getString("vehiclemodel"));
                vehi.setVehiclebrand(rs.getString("vehiclebrand"));
                vehi.setVehiclecolor(rs.getString("vehiclecolor"));
                vehi.setVehicleyear(rs.getString("vehicleyear"));
      
 	        }
 	    }
 	    catch (Exception ex) {
 	        System.out.println(ex);
 	    }



 	return vehi;
 	}



 	public void updateVehicle(Vehicle vh) throws ClassNotFoundException, SQLException{

         this.initJDBC();

         try {

             String sql = "UPDATE vehicle SET  = customerid = ?,customername = ?,customeric = ?,vehiclemodel = ?,vehiclebrand = ?,vehiclecolor =?, vehicleyear WHERE vehicleid = ?";
             ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, vh.getCustomerid());
             ps.setString(2, vh.getCustomername());
             ps.setString(3, vh.getCustomeric());
             ps.setString(4, vh.getVehiclemodel());
             ps.setString(5, vh.getVehiclebrand());
             ps.setString(6, vh.getVehiclecolor());
             ps.setString(7, vh.getVehicleyear());
             ps.setInt(8, vh.getVehicleid());

             ps.executeUpdate();
             System.out.println("Database updated successfully ");  
             
         }
         catch (Exception ex) {
             System.out.println("updateVehicle()" + ex);
             ex.printStackTrace();
         }
     }

     public void deleteVehicleById(int vehicleid)  throws ClassNotFoundException, SQLException{

         try {

             this.initJDBC();
             String sql = ("DELETE from vehicle WHERE  vehicleid = ?");
             PreparedStatement ps = connection.prepareStatement(sql);
             ps.setInt(1, vehicleid);
 
             ps.executeUpdate();
             System.out.println("Record deleted successfully");
         }
         catch (Exception ex) {
             System.out.println("deleteVehicleById(): "+ ex);
             ex.printStackTrace();
         }
     }
 	
         
     public void addVehicle(Vehicle vh) throws ClassNotFoundException, SQLException{

         this.initJDBC();
         
         try {

             String sql = "INSERT into vehicle(customerid, customername, customeric, vehiclemodel, vehiclebrand, vehiclecolor, vehicleyear) values(?,?,?,?,?,?,?)";
             ps = connection.prepareStatement(sql/*, Statement.RETURN_GENERATED_KEYS*/);
             ps.setInt(1, vh.getCustomerid());
             ps.setString(2, vh.getCustomername());
             ps.setString(3, vh.getCustomeric());
             ps.setString(4, vh.getVehiclemodel());
             ps.setString(5, vh.getVehiclebrand());
             ps.setString(6, vh.getVehiclecolor());
             ps.setString(7, vh.getVehicleyear());

             ps.executeUpdate();
             System.out.println("New record added successfully ");
         }
         catch (Exception ex) {
             System.out.println("addVehicle()" + ex);
             ex.printStackTrace();
         }
     }

     
 }