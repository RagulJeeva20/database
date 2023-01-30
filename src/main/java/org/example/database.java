package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;


public class Database
{

    public static void main(String[] args)
    {
      String dbname;
      String username;
      String pass;
      Scanner s =new Scanner(System.in);
        System.out.println("Enter the database name:");
        dbname=s.next();
        System.out.println("Enter your username:");
        username=s.next();
        System.out.println("Enter your password:");
        pass=s.next();
        Creation a1= Creation.in(dbname,username,pass);
        a1.connecting();
        a1.terminate();
    }
    public static class Creation
    {
        String dbname;
        String username;
        String pass;
        Connection conn;

        private Creation(String dbname, String username, String pass)
        {
            this.dbname = dbname;
            this.username = username;
            this.pass = pass;

        }
        public static Creation in(String dbname, String username, String pass)
        {
            return new Creation(dbname, username, pass);
        }
        void connecting()
        {
            try {
                conn = DriverManager.getConnection(dbname, username, pass);
                System.out.println("Connection has been successfully established");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        void terminate()
        {
            try {
                conn.close();
                System.out.println("Closed");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
