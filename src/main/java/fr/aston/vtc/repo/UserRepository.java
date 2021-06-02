package fr.aston.vtc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.aston.vtc.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
