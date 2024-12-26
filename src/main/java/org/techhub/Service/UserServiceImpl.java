package org.techhub.Service;

import java.util.List;

import org.techhub.Model.UserModel;
import org.techhub.Repository.UserRepository;
import org.techhub.Repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService{
	UserRepository userRepo=new UserRepositoryImpl();
	
	public boolean isAddNewUser(UserModel Model1) {
		
		return userRepo.isAddNewUser(Model1);
	}

	public boolean addBooksToUser(int userId, List<Integer> bookIds) {
		return userRepo.addBooksToUser(userId, bookIds);
	}

	public List<String> getBooksByUser(int userId) {
		return userRepo.getBooksByUser(userId);
	}

	public int getUserIdByName(String name)
	{
		
		return userRepo.getUserIdByName(name);
	}

	public boolean checkUserLogin(String username, String pass) {
		
		return userRepo.checkUserLogin(username, pass);
	}

	public String getUnameByEmail(String email) {
		return userRepo.getUnameByEmail(email);
	}

	public List<UserModel> ViewAllUser() {
		return userRepo.ViewAllUser();
	}	
}
