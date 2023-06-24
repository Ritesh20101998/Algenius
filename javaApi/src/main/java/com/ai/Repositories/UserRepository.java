package com.ai.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ai.EntityClasses.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods if needed
}
