package org.techhub.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserModel {
	private int Uid;
	public int getUid() {
		return Uid;
	}
	public void setUid(int uid) {
		Uid = uid;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUemail() {
		return Uemail;
	}
	public void setUemail(String uemail) {
		Uemail = uemail;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getUphone() {
		return Uphone;
	}
	public void setUphone(int uphone) {
		Uphone = uphone;
	}
	public String getUaddress() {
		return Uaddress;
	}
	public void setUaddress(String uaddress) {
		Uaddress = uaddress;
	}
	public long getAdharNo() {
		return AdharNo;
	}
	public void setAdharNo(long adharNo) {
		AdharNo = adharNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	private String Uname;
	private String Uemail;
	private String Password;
	private int Uphone;
	private String Uaddress;
	private long AdharNo;
	private String gender;
	private List<Integer> bookIds; // List to store associated book IDs
	private Date borrowDate;
	

	
    public List<Integer> getBookIds() {
        return bookIds;
    }
    

    public void setBookIds(List<Integer> bookIds) {
        this.bookIds = bookIds;
    }
    public void setDate(Date borrowDate)
    {
    	this.borrowDate=borrowDate;
    }
    public Date getDate()
    {
    	return borrowDate;
    }
	
}
