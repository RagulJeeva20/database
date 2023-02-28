package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database
{

    public static void main(String[] args)
    {
      String dbname;
      String username;
      String pass;
      Scanner s =new Scanner(System.in);
        Logger l=Logger.getLogger("tyler");
        l.info("Enter the database name:");
        dbname=s.next();
        l.info("Enter your username:");
        username=s.next();
        l.info("Enter your password:");
        pass=s.next();
        Creation a1= Creation.in(dbname,username,pass);
        a1.connecting();
        a1.terminate();
    }
}
