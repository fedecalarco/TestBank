package com.banco.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long user_ID;
    private String username;
    private String password;
    private String email;
    @OneToOne(cascade = {CascadeType.ALL})
    private Customer customer;

    // Spring security: ROLES
    @Enumerated(EnumType.STRING)
    private User_Role role;

    public User() {
    }

    public User(String username, String password, String email, Customer customer, User_Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.customer = customer;
        this.role = role;
    }

    public long getUser_ID() {
        return user_ID;
    }

//    public void setUser_ID(long user_ID) {
//        this.user_ID = user_ID;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User_Role getRole() {
        return role;
    }

    public void setRole(User_Role role) {
        this.role = role;
    }
    

    
    
}
