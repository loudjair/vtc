package fr.aston.vtc.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.User;

public interface UserRepo extends JpaRepository<User, Long>{
	/*
	 * Annotation importante pour supprimer l'entité
	 */
	@Transactional
	void deleteUserById(int id);
	Optional<User> findUserById(int id);
}
