/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author fedec
 */
@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long Account_ID;
    private double balance;
    
        @OneToOne(cascade = {CascadeType.ALL})
        private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Movements> movs = new ArrayList<Movements>();

    public Account() {
    }

    public Account(long Account_ID, double balance, Customer customer) {
        this.Account_ID = Account_ID;
        this.balance = balance;
        this.customer = customer;
    }

    public long getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(long Account_ID) {
        this.Account_ID = Account_ID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Movements> getMovs() {
        return movs;
    }

    public void setMovs(List<Movements> movs) {
        this.movs = movs;
    }
    
            public void addMovements(Movements mov){
        this.movs.add(mov);
    }

            
   

}
