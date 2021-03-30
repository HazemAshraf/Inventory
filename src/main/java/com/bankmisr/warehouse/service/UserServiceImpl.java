package com.bankmisr.warehouse.service;

import com.bankmisr.warehouse.dao.UserRepo;
import com.bankmisr.warehouse.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepo userDAO;
//public void saveUser(User u){
//    userRepo.save(u);
//}


//    public List<ItemMaster> findAll() {
//        return masterDAO.findAll();
//    }

    public User findByUserName(String userName) {
        return userDAO.findUserByUsername(userName);
    }
    public User findByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }
    public User findByUsernameOrEmail(String userName,String email) {
        return userDAO.findByUsernameOrEmail(userName,email);
    }
    public void saveUser(User u){
        userDAO.save(u);
    }

}
