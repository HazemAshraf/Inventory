package com.bankmisr.warehouse.dao;

import com.bankmisr.warehouse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    public User findUserByUsername(String username);
    public User findUserByEmail(String email);
    public User findByUsernameOrEmail(String username,String email);
}
