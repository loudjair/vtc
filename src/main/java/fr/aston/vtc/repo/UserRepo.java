package fr.aston.vtc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

	void deleteUserById(int id);
	Optional<User> findUserById(int id);
}
