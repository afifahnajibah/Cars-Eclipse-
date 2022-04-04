package workorder;

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

import workorder.Workorder;

public class WorkorderModel {

    private Statement statement;
    private PreparedStatement ps;
    private static Connection connection;


    public WorkorderModel() {
      
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

    public ArrayList<Workorder> viewWorkorder() throws ClassNotFoundException, SQLException
    {
        initJDBC();

        ArrayList<Workorder> woList = null;

        try {


           woList = new ArrayList<Workorder>();

            Statement statement = connection.createStatement();

            // Execute a statement
            ResultSet rs = statement.executeQuery("SELECT * FROM workorder");

            while(rs.next()){

                Workorder wo = new Workorder();
                
                wo.setWorkorderid(rs.getInt("workorderid"));
                wo.setStaffid(rs.getInt("staffid"));
                wo.setCustomerid(rs.getInt("customerid"));
                wo.setVehicleid(rs.getInt("vehicleid"));
                wo.setDate(rs.getString("date"));
                wo.setProblem(rs.getString("problem"));
                wo.setCauses(rs.getString("causes"));
                wo.setSolution(rs.getString("solution"));
                wo.setPayment(rs.getFloat("payment"));
                
                woList.add(wo);

            }
        }

        catch (Exception ex) {

            System.out.println("viewWorkorder():"+ ex);
            ex.printStackTrace();
        }

        //connection.close();
        return woList;
    } 

    
    
    public Workorder getWorkorderById(int workorderid){
    	Workorder work = new Workorder();
    	try{
    		this.initJDBC();
    		String query = ("SELECT * from workorder WHERE  workorderid = ?");
 	        PreparedStatement ps = connection.prepareStatement(query);
 	        ps.setInt(1,workorderid);
 
 	        ResultSet rs = ps.executeQuery();

 	        while (rs.next()){
 	            
 	        	work.setWorkorderid(rs.getInt("workorderid"));
 	        	work.setStaffid(rs.getInt("staffid"));
 	        	work.setCustomerid(rs.getInt("customerid"));
 	        	work.setVehicleid(rs.getInt("vehicleid"));
 	        	work.setDate(rs.getString("date"));
 	        	work.setProblem(rs.getString("problem"));
 	        	work.setCauses(rs.getString("causes"));
 	        	work.setSolution(rs.getString("solution"));
                work.setPayment(rs.getFloat("payment"));
 	        }
 	    }
 	    catch (Exception ex) {
 	        System.out.println(ex);
 	    }



 	return work;
 	}



 	public void updateWorkorder(Workorder wo) throws ClassNotFoundException, SQLException{

         this.initJDBC();

         try {

             String sql = "UPDATE workorder SET staffid = ?,customerid = ?,vehicleid = ?,date = ?,problem =?, causes=?, solution=?, payment=? WHERE workorderid = ?";
             ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, wo.getStaffid());
             ps.setInt(2, wo.getCustomerid());
             ps.setInt(3, wo.getVehicleid());
             ps.setString(4, wo.getDate());
             ps.setString(5, wo.getProblem());
             ps.setString(6, wo.getCauses());
             ps.setString(7, wo.getSolution());
             ps.setFloat(8, wo.getPayment());
             ps.setInt(9, wo.getWorkorderid());

             ps.executeUpdate();
             System.out.println("Database updated successfully ");  
             
         }
         catch (Exception ex) {
             System.out.println("updateWorkorder()" + ex);
             ex.printStackTrace();
         }
     }

         
     public void addWorkorder(Workorder wo) throws ClassNotFoundException, SQLException{

         this.initJDBC();
         
         try {

             String sql = "INSERT into workorder(staffid, customerid , vehicleid, date, problem, causes, solution, payment) values(?,?,?,?,?,?,?,?)";
             ps = connection.prepareStatement(sql/*, Statement.RETURN_GENERATED_KEYS*/);
             ps.setInt(1, wo.getStaffid());
             ps.setInt(2, wo.getCustomerid());
             ps.setInt(3, wo.getVehicleid());
             ps.setString(4, wo.getDate());
             ps.setString(5, wo.getProblem());
             ps.setString(6, wo.getCauses());
             ps.setString(7, wo.getSolution());
             ps.setFloat(8, wo.getPayment());
  
             ps.executeUpdate();
             System.out.println("New record added successfully ");
         }
         catch (Exception ex) {
             System.out.println("addWorkorder()" + ex);
             ex.printStackTrace();
         }
     }

     
 }