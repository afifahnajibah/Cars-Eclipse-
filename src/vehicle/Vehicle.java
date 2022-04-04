package vehicle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Vehicle{
	 
	int vehicleid;
	int customerid;
	String customername;
	String customeric;
	String vehiclemodel;
	String vehiclebrand;
	String vehiclecolor;
	String vehicleyear;
	
	public Vehicle(){
		//default constructor
	}
 
	public Vehicle(int vehicleid, int customerid, String customername, String customeric, String vehiclemodel,
			String vehiclebrand, String vehiclecolor, String vehicleyear) {
		super();
		this.vehicleid = vehicleid;
		this.customerid = customerid;
		this.customername = customername;
		this.customeric = customeric;
		this.vehiclemodel = vehiclemodel;
		this.vehiclebrand = vehiclebrand;
		this.vehiclecolor = vehiclecolor;
		this.vehicleyear = vehicleyear;
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
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

	public String getVehiclemodel() {
		return vehiclemodel;
	}

	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}

	public String getVehiclebrand() {
		return vehiclebrand;
	}

	public void setVehiclebrand(String vehiclebrand) {
		this.vehiclebrand = vehiclebrand;
	}

	public String getVehiclecolor() {
		return vehiclecolor;
	}

	public void setVehiclecolor(String vehiclecolor) {
		this.vehiclecolor = vehiclecolor;
	}

	public String getVehicleyear() {
		return vehicleyear;
	}

	public void setVehicleyear(String vehicleyear) {
		this.vehicleyear = vehicleyear;
	}
	
	
}