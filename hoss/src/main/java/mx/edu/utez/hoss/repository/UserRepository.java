package mx.edu.utez.hoss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.hoss.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
