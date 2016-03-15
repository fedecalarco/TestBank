/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.daos;

import com.banco.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fedec
 */
@Repository
public class BankDAOImpl implements BankDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Account getAccountById(long account_ID) {
        return (Account) getCurrentSession().createQuery("FROM com.banco.model.Account WHERE accout_ID='" + account_ID + "'").uniqueResult();

    }

    @Override
    public void update(Account account) {
        getCurrentSession().update(account);
    }

}
