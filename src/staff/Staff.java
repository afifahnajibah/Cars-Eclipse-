package staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Staff{
	
	int staffid;
	String staffname;
	String staffic;
	String staffphone;
	String staffemail;
	
	public Staff(){
	 //default constructor
	}

	public Staff(int staffid, String staffname, String staffic, String staffphone, String staffemail) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffic = staffic;
		this.staffphone = staffphone;
		this.staffemail = staffemail;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public String getStaffic() {
		return staffic;
	}

	public void setStaffic(String staffic) {
		this.staffic = staffic;
	}

	public String getStaffphone() {
		return staffphone;
	}

	public void setStaffphone(String staffphone) {
		this.staffphone = staffphone;
	}

	public String getStaffemail() {
		return staffemail;
	}

	public void setStaffemail(String staffemail) {
		this.staffemail = staffemail;
	}
	
	
}
