package fr.aston.vtc;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.aston.vtc.model.User;
import fr.aston.vtc.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRessource {
	private final UserService userService;
	
	public UserRessource(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.findAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User users = userService.findUserById(id);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User newUser = userService.addUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User newUser = userService.addUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}
}
