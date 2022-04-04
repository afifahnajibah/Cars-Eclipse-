package staff;

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

import staff.Staff;

public class StaffModel {

    private Statement statement;
    private PreparedStatement ps;
    private static Connection connection;


    public StaffModel() {
      
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

    public ArrayList<Staff> viewStaff() throws ClassNotFoundException, SQLException
    {
        initJDBC();

        ArrayList<Staff> stList = null;

        try {

           stList = new ArrayList<Staff>();

            Statement statement = connection.createStatement();

            // Execute a statement
            ResultSet rs = statement.executeQuery("SELECT * FROM staff");

            while(rs.next()){

                Staff st = new Staff();

                st.setStaffid(rs.getInt("staffid"));
                st.setStaffname(rs.getString("staffname"));
                st.setStaffic(rs.getString("staffic"));
                st.setStaffphone(rs.getString("staffphone"));
                st.setStaffemail(rs.getString("staffemail"));

                stList.add(st);

            }
        }

        catch (Exception ex) {

            System.out.println("viewStaff():"+ ex);
            ex.printStackTrace();
        }

        //connection.close();
        return stList;
    } 



    public Staff getStaffById(int staffid){
    	Staff stf = new Staff();
    	try{
    		this.initJDBC();
    		String query = ("SELECT * from staff WHERE  staffid = ?");
 	        PreparedStatement ps = connection.prepareStatement(query);
 	        ps.setInt(1,staffid);

 	        ResultSet rs = ps.executeQuery();

 	        while (rs.next()){
 	        	
 	        	stf.setStaffid(rs.getInt("staffid"));
 	        	stf.setStaffname(rs.getString("staffname"));
 	        	stf.setStaffic(rs.getString("staffic"));
 	        	stf.setStaffphone(rs.getString("staffphone"));
 	        	stf.setStaffemail(rs.getString("staffemail"));

 	        }
 	    }
 	    catch (Exception ex) {
 	        System.out.println(ex);
 	    }

 	return stf;
 	}



 	public void updateStaff(Staff st) throws ClassNotFoundException, SQLException{

         this.initJDBC();

         try {
             String sql = "UPDATE staff SET staffname = ?,staffic = ?,staffphone = ?,staffemail =? WHERE staffid = ?";
             ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, st.getStaffname());
             ps.setString(2, st.getStaffic());
             ps.setString(3, st.getStaffphone());
             ps.setString(4, st.getStaffemail());
             ps.setInt(5, st.getStaffid());

             ps.executeUpdate();
             System.out.println("Database updated successfully ");  
             
         }
         catch (Exception ex) {
             System.out.println("updateStaff()" + ex);
             ex.printStackTrace();
         }
     }

     public void addStaff(Staff st) throws ClassNotFoundException, SQLException{

         this.initJDBC();
         
         try {

             String sql = "INSERT into staff(staffname, staffic, staffphone, staffemail) values(?,?,?,?)";
             ps = connection.prepareStatement(sql/*, Statement.RETURN_GENERATED_KEYS*/);
             ps.setString(1, st.getStaffname());
             ps.setString(2, st.getStaffic());
             ps.setString(3, st.getStaffphone());
             ps.setString(4, st.getStaffemail());

             ps.executeUpdate();
             System.out.println("New record added successfully ");
         }
         catch (Exception ex) {
             System.out.println("addStaff()" + ex);
             ex.printStackTrace();
         }
     }

     
 }