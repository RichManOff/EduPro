package com.example.diplomaproject.repository;

import com.example.diplomaproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // find account by id
    Optional<User> findById(Long id);

    // find account by username

    // find account by email
    User findByEmail(String email);

    Optional<User> findUserByEmail(String email);
    // save account
    User findByUsername(String username);
    // delete account

}
