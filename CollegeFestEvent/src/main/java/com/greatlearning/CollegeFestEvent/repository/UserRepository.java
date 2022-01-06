package com.greatlearning.CollegeFestEvent.repository;

import com.greatlearning.CollegeFestEvent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User getUserByUsername(String username);
}

