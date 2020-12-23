package com.psybot.Repository;

import com.psybot.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User ,Long> {
    User findByUsername(String username);
}
