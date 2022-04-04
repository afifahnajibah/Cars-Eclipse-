package customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Customer{
	
	int customerid;
	String customername;
	String customeric;
	String customerphone;
	String customeraddress;
	String customeremail;
	
	public Customer(){
		// default constructor	
	}
	
	public Customer(int customerid, String customername, String customeric, String customerphone,
			String customeraddress, String customeremail) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.customeric = customeric;
		this.customerphone = customerphone;
		this.customeraddress = customeraddress;
		this.customeremail = customeremail;
	}

	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeric() {
		return customeric;
	}
	public void setCustomeric(String customeric) {
		this.customeric = customeric;
	}
	public String getCustomerphone() {
		return customerphone;
	}
	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	
	
}