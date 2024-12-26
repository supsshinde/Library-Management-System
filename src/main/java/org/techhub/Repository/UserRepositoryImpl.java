package org.techhub.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.techhub.Model.CategoryModel;
import org.techhub.Model.UserModel;

public class UserRepositoryImpl extends DBConnection implements UserRepository {

	 LocalDate currentDate = LocalDate.now();
//     System.out.println("Current Date: " + currentDate);
     Date sqlDate = Date.valueOf(currentDate);

    public boolean isAddNewUser(UserModel Model1) {
       

        try {
            stmt = conn.prepareStatement(
                "INSERT INTO user (Uname, Uemail, password, Uphone, Borrow_date, Uaddress, AdharNo, gender) VALUES (?,?,?,?,?,?,?,?)"
            );


            stmt.setString(1, Model1.getUname());
            stmt.setString(2, Model1.getUemail());
            stmt.setString(3, Model1.getPassword());
            stmt.setInt(4, Model1.getUphone());
            stmt.setDate(5, sqlDate); // Use the converted sqlDate here
            stmt.setString(6, Model1.getUaddress());
            stmt.setLong(7, Model1.getAdharNo());
            stmt.setString(8, Model1.getGender());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Return true if a row was inserted
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public int getUserIdByName(String name) {
        try {
            stmt = conn.prepareStatement("SELECT Uid FROM user WHERE Uname = ?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("Uid"); 
            } else {
                return 0; // User not found
            }
        } catch (Exception ex) {
            System.out.println("Error is " + ex);
            return -1; // Error occurred
        }
    }
    public boolean addBooksToUser(int userId, List<Integer> bookIds) {
        try {
            stmt = conn.prepareStatement("INSERT INTO user_books (Uid, Bid) VALUES (?, ?)");
            for (int bookId : bookIds) {
                stmt.setInt(1, userId);
                stmt.setInt(2, bookId);
                stmt.addBatch(); // Add the statement to the batch
            }
            
            int[] rowsAffected = stmt.executeBatch(); // Execute the batch
            return rowsAffected.length == bookIds.size(); // Return true if all inserts succeeded
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false if an error occurs
        }
    }
	public List<String> getBooksByUser(int userId) {
		 List<String> bookNames = new ArrayList<String>();
	        try {
	            stmt = conn.prepareStatement("SELECT b.Bname FROM user_books ub JOIN book b ON ub.Bid = b.Bid WHERE ub.Uid = ?");
	            stmt.setInt(1, userId);
	            rs = stmt.executeQuery();
	            while (rs.next()) {
	                bookNames.add(rs.getString("Bname")); 
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return bookNames;	
	}

	public boolean checkUserLogin(String username, String pass) {
        try {
        	

        	stmt = conn.prepareStatement(" select uemail, password from user where uemail=? && password=?");
        	
            stmt.setString(1, username);
            stmt.setString(2, pass);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                return true; 
            }
            else
            {
            	return false;
            }
        }
        catch(Exception ex) 
        {
        	System.out.println("Error is " +ex);
        	return false;
        }
		
	}

	public String getUnameByEmail(String email) {
     
		try {
        	stmt = conn.prepareStatement(" select uname from user where uemail=?");
        	
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            if(rs.next())
            {
                return rs.getString("Uname"); 
            }
            else
            {
            	return null;
            }
        }
        catch(Exception ex) 
        {
        	System.out.println("Error is " +ex);
        	return null;
        }
		
	}

	public List<UserModel> ViewAllUser() {
		
		try {
			List<UserModel> list=new ArrayList<UserModel>();
	        stmt = conn.prepareStatement("Select uid,uname,uemail,uaddress,uphone,Borrow_date,gender from user");
	        rs=stmt.executeQuery();
	        while(rs.next()) {
	        	UserModel model=new UserModel();
	        	model.setUid(rs.getInt(1));
	        	model.setUname(rs.getString(2));
	        	model.setUemail(rs.getString(3));
//	        	model.setPassword(rs.getString(4));
	        	model.setUaddress(rs.getString(4));
	        	model.setUphone(rs.getInt(5));
	          //  Date sqlDate = Date.valueOf(currentDate);
	            model.setDate(rs.getDate(6));
	            model.setGender(rs.getString(7));
	        	list.add(model);
	        
	        }
return list;
	        
	        
	    } catch (Exception ex) {
	        System.out.println("Error is: " + ex);
	        return null;	
	    }
	}

	
}


