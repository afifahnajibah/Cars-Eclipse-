package customer;

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

import customer.Customer;

public class CustomerModel {

    private Statement statement;
    private PreparedStatement ps;
    private static Connection connection;


    public CustomerModel() {
      
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

    public ArrayList<Customer> viewCustomer() throws ClassNotFoundException, SQLException
    {
        initJDBC();

        ArrayList<Customer> csList = null;

        try {


           csList = new ArrayList<Customer>();

            Statement statement = connection.createStatement();

            // Execute a statement
            ResultSet rs = statement.executeQuery("SELECT * FROM customer");

            while(rs.next()){

                Customer cs = new Customer();

                cs.setCustomerid(rs.getInt("customerid"));
                cs.setCustomername(rs.getString("customername"));
                cs.setCustomeric(rs.getString("customeric"));
                cs.setCustomerphone(rs.getString("customerphone"));
                cs.setCustomeraddress(rs.getString("customeraddress"));
                cs.setCustomeremail(rs.getString("customeremail"));

                csList.add(cs);

            }
        }

        catch (Exception ex) {

            System.out.println("viewCustomer():"+ ex);
            ex.printStackTrace();
        }

        //connection.close();
        return csList;
    } 



    public Customer getCustomerById(int customerid){
    	Customer cust = new Customer();
    	try{
    		this.initJDBC();
    		String query = ("SELECT * from customer WHERE  customerid = ?");
 	        PreparedStatement ps = connection.prepareStatement(query);
 	        ps.setInt(1,customerid);

 	        ResultSet rs = ps.executeQuery();

 	        while (rs.next()){
 	        	
 	        	cust.setCustomerid(rs.getInt("customerid"));
                cust.setCustomername(rs.getString("customername"));
                cust.setCustomeric(rs.getString("customeric"));
                cust.setCustomerphone(rs.getString("customerphone"));
                cust.setCustomeraddress(rs.getString("customeraddress"));
                cust.setCustomeremail(rs.getString("customeremail"));

 	        }
 	    }
 	    catch (Exception ex) {
 	        System.out.println(ex);
 	    }



 	return cust;
 	}



 	public void updateCustomer(Customer cs) throws ClassNotFoundException, SQLException{

         this.initJDBC();

         try {

             String sql = "UPDATE customer SET customername = ?,customeric = ?,customerphone = ?,customeraddress = ?,customeremail =? WHERE customerid = ?";
             ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, cs.getCustomername());
             ps.setString(2, cs.getCustomeric());
             ps.setString(3, cs.getCustomerphone());
             ps.setString(4, cs.getCustomeraddress());
             ps.setString(5, cs.getCustomeremail());
             ps.setInt(6, cs.getCustomerid());

          
             ps.executeUpdate();
             System.out.println("Database updated successfully ");  
             
         }
         catch (Exception ex) {
             System.out.println("updateCustomer()" + ex);
             ex.printStackTrace();
         }
     }

     public void deleteCustomerById(int id)  throws ClassNotFoundException, SQLException{

         try {

             this.initJDBC();
             String sql = ("DELETE from customer WHERE  customerid = ?");
             PreparedStatement ps = connection.prepareStatement(sql);
             ps.setInt(1, id);

             ps.executeUpdate();
             System.out.println("Record deleted successfully");
         }
         catch (Exception ex) {
             System.out.println("deleteCustomerById(): "+ ex);
             ex.printStackTrace();
         }
     }
 	
         
     public void addCustomer(Customer cs) throws ClassNotFoundException, SQLException{

         this.initJDBC();
         
         try {

             String sql = "INSERT into customer(customername, customeric, customerphone, customeraddress, customeremail) values(?,?,?,?,?)";
             ps = connection.prepareStatement(sql/*, Statement.RETURN_GENERATED_KEYS*/);
             ps.setString(1, cs.getCustomername());
             ps.setString(2, cs.getCustomeric());
             ps.setString(3, cs.getCustomerphone());
             ps.setString(4, cs.getCustomeraddress());
             ps.setString(5, cs.getCustomeremail());

             ps.executeUpdate();
             System.out.println("New record added successfully ");
         }
         catch (Exception ex) {
             System.out.println("addCustomer()" + ex);
             ex.printStackTrace();
         }
     }

     
 }