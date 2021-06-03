package fr.aston.vtc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.aston.vtc.exception.UserNotFoundException;
import fr.aston.vtc.model.User;
import fr.aston.vtc.repo.UserRepo;

@Service
public class UserService {

	private final UserRepo userRepo;
	
	@Autowired
	public UserService(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> findAllUsers(){
		return userRepo.findAll();
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
	public User findUserById(int id){
		return userRepo.findUserById(id)
				.orElseThrow(()-> new UserNotFoundException("User by id "+id+" was not found"));
	}
	
	public void deleteUser(int id) {
		userRepo.deleteUserById(id);
	}
}