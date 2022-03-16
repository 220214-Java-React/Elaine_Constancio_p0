package com.revature.AeyBankingAPP.Model;

/**
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 *
 */

public class Connect
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://java-react.cacx9fu3do3p.us-east-1.rds.amazonaws.com:5432/postgres?currentSchema=BANK";

    public static String success="database_cnt_error.Proceeding in Offline Mode";

    static final String USER = "postgres";
    static final String PASS = "Pace20222#";

    public static void main(String[] args)
    {
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            success="Connected to database successfully";//used for offline mode detection
            System.out.println("Connected to database successfully...");
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(conn!=null)
                    conn.close();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
        }
    }
}

