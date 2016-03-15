/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.service;

import com.banco.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banco.daos.UserDAO;
import com.banco.model.Account;
import com.banco.model.Customer;
import com.banco.model.User_Role;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fedec
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;
    
    private void newAccount(){
        
    }

    @Override
    public void create(User user) {

        Account acc = new Account();
        acc.setBalance(2000);
        

        Customer customer = user.getCustomer();
        customer.setUser(user);
        customer.addAccount(acc);
        
        acc.setCustomer(customer);

        user.setCustomer(user.getCustomer());

        user.setRole(User_Role.ROLE_USER);
        userDao.create(user);
    }

    @Override
    public User getUserByUsername(String username) {

        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

}
