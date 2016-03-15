package com.banco.model;

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

@Entity
public class Customer implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long customer_ID;
    private String fistname;
    private String lastname;
    private String dni;
    private String phone;


    @OneToOne(cascade = {CascadeType.ALL})
    private User user;

    @OneToOne(cascade = {CascadeType.ALL})
    private Branch branch;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Account> accounts = new ArrayList<Account>();

    public Customer() {
    }

    public Customer(long customer_ID, String fistname, String lastname, String dni, String phone, User user, Branch branch) {
        this.customer_ID = customer_ID;
        this.fistname = fistname;
        this.lastname = lastname;
        this.dni = dni;
        this.phone = phone;
        this.user = user;
        this.branch = branch;
    }

    public long getCustomer_ID() {
        return customer_ID;
    }

    public void setCustomer_ID(long customer_ID) {
        this.customer_ID = customer_ID;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
                public void addAccount(Account acc){
        this.accounts.add(acc);
    }

    


}
