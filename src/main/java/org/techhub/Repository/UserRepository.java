package org.techhub.Repository;

import java.util.List;

import org.techhub.Model.UserModel;

public interface UserRepository {
	public boolean isAddNewUser(UserModel Model1);
	public int getUserIdByName(String name);

	  boolean addBooksToUser(int userId, List<Integer> bookIds);
	    List<String> getBooksByUser(int userId);
	    
	    public boolean checkUserLogin(String username, String pass);
	    
	    public String getUnameByEmail(String email);
	    
		public List<UserModel> ViewAllUser();
}