package com.revature.AeyBankingAPP.Model;

import java.util.Calendar;

/**
 * This class is used to store data about a transaction.
 * Data is recorded in this object when user make a transaction.
 **/
public class Transaction
{

    // accountId is used to store sender's id
    private String accountId;
    //password is used to store transaction password of sender
    private String password;
    //creation time is the time when a transaction is made
    protected  long creationTime;
    //recipientAmout is the amount to transfer
    private  double recipientAmount;
    //string representation of transaction
    private  String transaction;
    public  Transaction()
    {
        Calendar c= Calendar.getInstance();
        creationTime=c.getTimeInMillis();
    }
    // parameterise constructor
    public Transaction(String accountId , String password , double recipientAmount)
    {
        accountId=this.accountId;
        password=this.password;
        recipientAmount=this.recipientAmount;
    }

    //setter and getters of above attributes
    public void setAccountId(String accountId)
    {
        accountId=this.accountId;
    }
    public String getAccountId()
    {
        return accountId;
    }
    public void setPassword(String password)
    {
        password=this.password;
    }
    public String getPassword()
    {
        return password;
    }
    public void setRecipientAmount(double recipientAmount)
    {
        recipientAmount=this.recipientAmount;
    }
    public double getRecipientAmount()
    {
        return  recipientAmount;
    }
    public void setCreationTime(long creationTime)
    {
        creationTime=this.creationTime;
    }
    public  long getCreationTime()
    {
        return  creationTime;
    }
    public void setTransaction(String transaction)
    {
        transaction=this.transaction;
    }
    public  String getTransaction()
    {
        return  transaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "accountId='   " + accountId + '\'' +
                ", password=   '" + password + '\'' +
                ", creationTime=  " + creationTime +
                ", recipientAmount=    " + recipientAmount +
                ", transaction='"     + transaction + '\'' +
                '}';
    }
}

