/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.daos;

import com.banco.model.Account;

/**
 *
 * @author fedec
 */
public interface BankDAO {

    Account getAccountById(long account_ID);

    void update(Account account);

}
