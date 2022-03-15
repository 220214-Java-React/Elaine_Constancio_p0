package com.revature.Model;

import java.util.ArrayList;
import java.util.Calendar;
/**
 * This class is used to store Account info for customer
 */
public class Account{

    //Stores a list of transactions made by a specific account
    ArrayList<Transaction> transactionlist= new ArrayList<>();
    //Stores account creation time in milliseconds
    public long creationTime;
    //Stores Account ID
    private String uniqueAccountId;
    //Stores customer's name that holds that account
    private String accountUserName;
    //Stores current balance in the account
    private double balance;
    //Stores account password
    private String accountPassword;


    //no argument constructor (it will automatically set current time when account is created)

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
        this.getBalance();

    }

    // This function is used to display account information on the screen

    public void info()
    {
        System.out.println("**Account Details**");
        System.out.println("\tOwner Name is :" + accountUserName);
        System.out.println("\tAccount Id  is :" +uniqueAccountId);
        System.out.println("Your balance is : " + balance);
        System.out.println("Aey, Hola, Oi!\n" +
                "How may we brighten your day today?\n\n" +
                "Please choose options between 1-5\n" +
                " 1 -- Register new user account.\n" +
                " 2 -- Login into your account.\n" + accountUserName + uniqueAccountId+
                " 3 -- Deposit funds into your account?\n" +
                " 4 -- Withdraw funds from your account?\n" +
                " 5 -- Your balance is: \n" + balance+
                " 6 -- Exit the application, thank you for your business");


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
