package fr.aston.vtc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aston.vtc.exception.UserNotFoundExecption;
import fr.aston.vtc.model.User;
import fr.aston.vtc.repo.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	public User findUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundExecption ("L'utilisateur avec comme id " + id + " n'est pas trouvé"));
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
