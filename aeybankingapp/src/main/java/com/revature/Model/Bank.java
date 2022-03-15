package com.revature.Model;

import java.util.ArrayList;

/**
 * This class will used to store all information related to bank
 */
public class Bank
{
    //attributes

    //this attribute store a unique bank id
    private  String BankId;
    //this attribute store bank's address
    private String BankAddres;
    //one dimensional array used to store All bank accounts
    Account accountlist[]= new Account[50];

    //this will used to store current index of above array
    int index=0;

    //this will store all customers in organization
    ArrayList<Customer> customerList = new ArrayList<Customer>();




    // this function update a customer data in customerlist
    public void updateCustomer(Customer customer)
    {
        for (int i=0;i< customerList.size();i++)
        {
            if(customerList.get(i).getUniqueCustomerId().equalsIgnoreCase(customer.getUniqueCustomerId()))
            {
                customerList.remove(i);
                customerList.add(i,customer);
            }
        }

    }


    //getters setters for above attributes
    public String getBankId() {
        return BankId;
    }

    public void setBankId(String bankId) {
        BankId = bankId;
    }



    public String getBankAddres() {
        return BankAddres;
    }

    public void setBankAddres(String bankAddres) {
        BankAddres = bankAddres;
    }







    public Account[] getAccountlist() {
        return accountlist;
    }




    ArrayList<Transaction>  transactionlist = new ArrayList<Transaction>();


    public void addCustomer(Customer customer)
    {
        customerList.add(customer);
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    public void addAccount(Account account)
    {
        if(index<49) {
            accountlist[index] = account;
            index++;
        }
        else
        {
            System.out.println("Accounts are full");
        }
    }


    public  Customer getCustomerByID(String custId)
    {

        for (int i=0;i<customerList.size();i++)
        {
            if(customerList.get(i).getUniqueCustomerId().equalsIgnoreCase(custId))
                return customerList.get(i);
        }
        return null;
    }



}

