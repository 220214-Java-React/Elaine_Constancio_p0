package com.revature.AeyBankingAPP.Model;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * This class is used to store an Account related information of a customer
 */
public class Account{
//attributes

    //this attributed is used to store a list of transactions made by a specific account
    ArrayList<Transaction> transactionlist= new ArrayList<Transaction>();
    //this attributed is used to store account creation time in milliseconds
    public long creationTime;
    //this attributed is used to store Account ID
    private String uniqueAccountId;
    //this attributed is used to store customer's name that holds that account
    private String accountUserName;
    //this attributed is used to store current balance in the account
    private double balance;
    //this attributed is used to store account password
    private String accountPassword;


    //no argument constructor (it willl automatically set current time when account is created)
    public Account()
    {
        Calendar c= Calendar.getInstance();
        creationTime= c.getTimeInMillis();
    }

    //parametrized constructor
    public Account(String uniqueAccountId, String accountUserName, double balance, String accountPassword) {
        this.uniqueAccountId = uniqueAccountId;
        this.accountUserName = accountUserName;
        this.balance = balance;
        this.accountPassword = accountPassword;
    }

    // this function is used to display account information on the screen
    public void info()
    {
        System.out.println("**Account Details**");
        System.out.println("\tOwner Name is :" + accountUserName);
        System.out.println("\tAccount Id  is :" +uniqueAccountId);
        System.out.println("\tYour balance is : " + balance);

    }


    // Following are the getters and setters of above attributes

    public long getCreationTime() {
        return creationTime;
    }



    public String getUniqueAccountId() {
        return uniqueAccountId;
    }

    public void setUniqueAccountId(String uniqueAccountId) {
        this.uniqueAccountId = uniqueAccountId;
    }



    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public String getAccountUserName() {
        return accountUserName;
    }

    public void setAccountUserName(String accountUserName) {
        this.accountUserName = accountUserName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }




    public ArrayList<Transaction> getTransactionlist() {
        return transactionlist;
    }

    public void addTransaction(Transaction transaction)
    {
        transactionlist.add(transaction);
    }

    public String TranstionHistory()
    {


        for(int i=0 ; i< transactionlist.size() ; i++)
        {
            Transaction transaction =transactionlist.get(i);

            return transaction.toString();

        }

        return "No Record Found!";

    }
    {

    }


}

