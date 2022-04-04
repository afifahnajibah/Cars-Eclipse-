package workorder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Workorder{
	
	int workorderid;
	int staffid;
	int customerid;
	int vehicleid;
	String date;
	String problem;
	String causes;
	String solution;
	Float payment;
	
	public Workorder(){
		//default constructor
	}

	public Workorder(int workorderid, int staffid, int customerid, int vehicleid, String date, String problem,
			String causes, String solution, Float payment) {
		super();
		this.workorderid = workorderid;
		this.staffid = staffid;
		this.customerid = customerid;
		this.vehicleid = vehicleid;
		this.date = date;
		this.problem = problem;
		this.causes = causes;
		this.solution = solution;
		this.payment = payment;
	}


	public int getWorkorderid() {
		return workorderid;
	}

	public void setWorkorderid(int workorderid) {
		this.workorderid = workorderid;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getCauses() {
		return causes;
	}

	public void setCauses(String causes) {
		this.causes = causes;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Float getPayment() {
		return payment;
	}

	public void setPayment(Float payment) {
		this.payment = payment;
	}
	
	
	
}