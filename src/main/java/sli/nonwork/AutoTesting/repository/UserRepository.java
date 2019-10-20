package sli.nonwork.AutoTesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sli.nonwork.AutoTesting.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
