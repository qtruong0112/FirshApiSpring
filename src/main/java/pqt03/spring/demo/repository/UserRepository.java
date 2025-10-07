package pqt03.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pqt03.spring.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
