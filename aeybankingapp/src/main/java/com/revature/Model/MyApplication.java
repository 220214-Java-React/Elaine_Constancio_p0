package com.revature.Model;


import java.sql.DriverManager;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
/**
 * This is main class that contains main function and will create objects of all classes used in this project
 * This will allow user to do bank related tasks.
 * User can create a account
 * User can update its information
 * User can do a transaction
 * Each change will be updated to bank's object
 */
public class MyApplication {

    static final String DB_URL = "jdbc:postgresql://java-react.cacx9fu3do3p.us-east-1.rds.amazonaws.com:5432/postgres?currentSchema=BANK";
    static final String USER = "abc";
    static final String PASS = "123";


    public static void signUp(Customer customer)
    {

        Wrapper conn = null;

        String name=customer.getName();
        String dOB=customer.getDateOfBirth();
        String pasword=customer.getPassword();
        String custId=customer.getUniqueCustomerId();


        try {
            String IQuery = "INSERT INTO `bank`.`customer`(`custId`,`name`,`password`,`DOB`) VALUES('"+custId+"','"+name+"','"+pasword+"', '"+dOB+"')";
            System.out.println("Connecting to  bank database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            ((Connection)conn).createStatement().execute(IQuery);
            String SMessage = "Record added for "+name;

            System.out.println(SMessage);
            ((java.sql.Connection)conn).close();

        }

        catch(Exception e )
        {
            System.err.println(e.getMessage());
        }



    }

    public static void createAccount(Account account , String custId )
    {

        Wrapper conn = null;
        String acntId=account.getUniqueAccountId();
        long time=account.getCreationTime();
        double balance =account.getBalance();

        try {
            String IQuery = "INSERT INTO `bank`.`accounts`(`custId`,`acntId`,`ctime`,`balance`) VALUES('"+custId+"','"+acntId+"','"+time+"', '"+balance+"')";
            System.out.println("Connecting to  bank database...");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            ((Connection)conn).createStatement().execute(IQuery);
            String SMessage = "Record added! ";

            System.out.println(SMessage);
            ((java.sql.Connection)conn).close();

        }

        catch(Exception e )
        {
            System.err.println(e.getMessage());
        }
    }


    protected static final String String = null;

    public static void main(String[] args) {

        //create a bank object
        Bank bank = new Bank();
        bank.setBankId("xyz");
        bank.setBankAddres("ABC");




        Transaction transaction = new Transaction();
        Customer customerobj = new Customer();
        int numberOfAccount = 0;


        //Scanner is used for the commandline input
        Scanner s = new Scanner(System.in);

        int option;


        while (true) {
            System.out.println(" 1 = Customer Registration ");
            System.out.println(" 2 = Existing Customer");
            System.out.println(" 3 = Create a Bank Account");
            System.out.println(" 4 = Show All Customer");
            System.out.println(" 5 =  Show transaction History ");

            option = s.nextInt();


            if (option == 1) {
                // create a new customer
                Customer customer=new Customer();

                String names;
                String dateOfBirth;
                String customerID;
                String password;

                System.out.println("Welcome Here!");
                System.out.println("Please Enter your Detail Here for Registeration ");

                System.out.println("Enter your name  :");
                names = s.next();

                System.out.println("Enter your date Of Birth :");
                dateOfBirth = s.next();

                System.out.println("Enter the password: ");
                password=s.next();

                // create unique customer id by combining customer name with currentmilli seconds time
                customerID = names+System.currentTimeMillis();

                //set all attributes to customer object
                customer.setDateOfBirth(dateOfBirth);
                customer.setName(names);
                customer.setUniqueCustomerId(customerID);
                customer.setPassword(password);
                signUp(customer);

                // add newly created customer to bank's customerList
                bank.addCustomer(customer);

                System.out.println("*****Customer Created****\n"+customer.toString());
                System.out.println("Type ok to continue:");
                String ch=s.next();
                if(ch.equalsIgnoreCase("ok"))
                    continue;
            }


            else if (option == 2)
            {

                System.out.println("Please Enter your Customer ID: ");
                String cstId=s.next();
                System.out.println("Please Enter your Password ");
                String pass=s.next();

                Customer customer=bank.getCustomerByID(cstId);
                if(customer!=null)
                    if(pass.equals(customer.getPassword())) {

                        System.out.println("Welcome There! ");
                        System.out.println("What Operation Do you want to perform");
                        System.out.println("1 = Create a new Account");
                        System.out.println("2 = Transaction");
                        System.out.println("3 = Check your Current balance");
                        System.out.println("4 = Check All Transaction History");
                        int opt;
                        opt = s.nextInt();
                        ArrayList<Transaction> translist;

                        switch (opt) {
                            case 1: {

                                if (numberOfAccount < 3) {
                                    Account acnt=new Account();
                                    acnt.setAccountUserName(customer.getName());
                                    acnt.setUniqueAccountId(bank.getBankId()+System.currentTimeMillis()); // unique accountID
                                    System.out.println("Account Created Sucessfully....");
                                    createAccount(acnt,customer.getUniqueCustomerId());

                                    acnt.info();
                                    customer.addAccount(acnt);
                                    bank.addAccount(acnt);
                                    bank.updateCustomer(customer);

                                } else {
                                    System.out.println("Sorry! you already have 3 Accounts");
                                }
                                break;
                            }


                            case 2: {
                                String acc;
                                System.out.println("What kind of Transaction Do you Perform");

                                String pas;

                                String acntId;
                                System.out.println("for This Operation Please Give Some Information Related to your Account");

                                System.out.println("Enter your Account Number:");
                                acntId = s.next();
                                Account account=customer.getAccountById(acntId);
                                if (acntId.equals(account.getUniqueAccountId()) ) {

                                    System.out.println("1 = Withdraw ");
                                    System.out.println("2 = Diposite ");
                                    System.out.println("3 = Sent ");
                                    int choice;
                                    choice = s.nextInt();

                                    double balance=account.getBalance();
                                    if (choice == 1) {

                                        double withdraw;
                                        System.out.println("How much amount you want to Withdraw");
                                        withdraw = s.nextInt();


                                        if (withdraw != 0 || withdraw > 0) {


                                            if (withdraw < balance) {


                                                double total = balance - withdraw;

                                                System.out.println("your Current balance is " + total);
                                                account.addTransaction(transaction);
                                                account.setBalance(total);

                                            } else {
                                                System.out.println("Sorry! you don't have Enough Balance");
                                            }
                                        } else {
                                            System.out.println("Sorry! You Enter 0 or negative ammount ");
                                            System.out.println("this is invalid amount");
                                        }
                                    } else if (choice == 2) {
                                        double deposite;
                                        System.out.println("Enter how much amount you to Deposite");
                                        deposite = s.nextInt();
                                        if (deposite != 0 || deposite > 0) {


                                            double totalAmount = balance + deposite;
                                            System.out.println("Now your Balance is" + totalAmount);
                                            account.setBalance(totalAmount);
                                            transaction.getCreationTime();
                                            account.addTransaction(transaction);
                                            continue;

                                        } else {
                                            System.out.println("Sorry! You Enter 0 or negative ammount ");
                                            System.out.println("this is invalid amount");
                                        }
                                    } else if (choice == 3) {
                                        double sent;
                                        System.out.println("Enter how much amount you want to sent ");
                                        sent = s.nextInt();
                                        if (sent != 0 || sent > 0) {

                                            if (sent < balance) {

                                                transaction.setRecipientAmount(sent);
                                                double totl = balance - sent;
                                                System.out.println("Now your Ammount is " + totl);
                                                account.setBalance(totl);
                                                transaction.getCreationTime();
                                                account.addTransaction(transaction);

                                            } else {
                                                System.out.println("Sorry! you have not Sufficient balance");
                                            }
                                        } else {
                                            System.out.println("Sorry! You Enter 0 or negative ammount ");
                                            System.out.println("this is invalid amount");
                                        }

                                    } else {
                                        System.out.println("    Enter valid Choice     ");
                                    }


                                } else {

                                    System.out.println("Invalid Password or UserName");
                                    System.out.println("Please enter correct id and password ");

                                }
                                customer.updateAccount(account);
                                bank.updateCustomer(customer);
                                break;


                            }


                            case 3: {
                                System.out.println("Enter your Account Number:");
                                String acntId = s.next();
                                Account account=customer.getAccountById(acntId);
                                System.out.println(account.getBalance());
                                break;
                            }


                            case 4: {
                                System.out.println("Enter your Account Number:");
                                String acntId = s.next();
                                Account account=customer.getAccountById(acntId);
                                ArrayList<Transaction> transaclist = account.getTransactionlist();

                                for (int i = 0; i < transaclist.size(); i++) {

                                    Transaction transaction1 = transaclist.get(i);


                                }
                                break;
                            }

                        }

                    }
                    else
                        System.out.println("Invalid details.....");
                else
                    System.out.println("Invalid details.....");
            }

            else if(option==3)
            {
                System.out.println("***Please Enter details to craete a bank account***\n ");
                System.out.println("Enter your customer Id: ");
                String custId=s.next();
                Customer customer=bank.getCustomerByID(custId);
                if(customer!=null)
                {
                    System.out.println("Enter your Password: ");
                    String pass=s.next();
                    if(pass.equals(customer.getPassword()))
                    {
                        Account acnt=new Account();
                        acnt.setAccountUserName(customer.getName());
                        acnt.setUniqueAccountId(bank.getBankId()+System.currentTimeMillis()); // unique accountID
                        createAccount(acnt,customer.getUniqueCustomerId());
                        System.out.println("Account Created Sucessfully....");
                        acnt.info();
                        customer.addAccount(acnt);
                        bank.updateCustomer(customer);
                    }

                }
                else
                {
                    System.out.println("InValid ID");
                }

            }
            else if (option == 4)
            {
                ArrayList<Customer> custList = bank.getCustomerList();

                for (int i = 0; i < custList.size(); i++)
                {
                    Customer customer = custList.get(i);

                    System.out.println("Name:      " + customer.getName() + "DOB:      " + customer.getDateOfBirth() + "ID:       " + customer.getUniqueCustomerId());
                }
            }
            else if(option==5)
            {
                System.out.println("Enter your customer Id: ");
                String custId=s.next();
                Customer customer=bank.getCustomerByID(custId);
                System.out.println(" Enter account id: ");
                String id=s.next();
                Account account=customer.getAccountById(id);
                System.out.println(account.TranstionHistory());




            }

        }//end of while
    }
}




