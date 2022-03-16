package com.revature.AeyBankingAPP.Model;

import java.util.ArrayList;

/**
 * This class will store information about a bank's customer (Account Holder)
 *This class will be used in MyApplication.java
 */
public class Customer {

    //used to store customer's name
    private String name;
    //used to store customer's date of birth
    private String dateOfBirth;
    //used to store customer's bank's ID
    private String uniqueCustomerId;
    //used to store how many accounts specific customer has
    private int numberOfAccount;
    //used to store customer's password for login
    private String password;
    //used to store customer's Accounts information
    ArrayList<Account> accountList = new ArrayList<Account>();

    //empty constructor
    public Customer() {
        numberOfAccount = 0;
    }

    //this function will add a new account to account list
    public void addAccount(Account account) {
        accountList.add(account);
    }


    //this method will return a string representation of Customer
    @Override
    public String toString() {
        return "\n\tCustomer Name: " + this.name + "\n\tCustomer ID: " + this.uniqueCustomerId + "\n\tDOB: " + dateOfBirth + "\n\tNumber of accounts: " + numberOfAccount;
    }

    //following are the list of getter setters for above class attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String getUniqueCustomerId() {
        return uniqueCustomerId;
    }

    public void setUniqueCustomerId(String uniqueCustomerId) {
        this.uniqueCustomerId = uniqueCustomerId;
    }


    public int getNumberOfAccount() {
        return numberOfAccount;
    }

    public void setNumberOfAccount(int numberOfAccount) {
        this.numberOfAccount = numberOfAccount;
    }


    public void setAccountList(ArrayList<Account> accountList) {
        this.accountList = accountList;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void updateAccount(Account acnt) {

        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUniqueAccountId().equalsIgnoreCase(acnt.getUniqueAccountId())) {
                accountList.add(i, acnt);
            }
        }
    }

    public Account getAccountById(String acntId) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUniqueAccountId().equals(acntId)) {
                return accountList.get(i);
            }
        }
        return null;
    }
}