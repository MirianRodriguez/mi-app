package com.epidata.miApp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epidata.miApp.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
    
    public User findByUsername(String username);

}
