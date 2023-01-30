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
    public static class Creation
    {
        String dbname;
        String username;
        String pass;
        Connection conn;
        Logger l=Logger.getLogger("tyler");
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
                l.info("Connection has been successfully established");
            } catch (Exception e) {
                l.log(Level.INFO,() -> String.valueOf(e));
            }
        }
        void terminate()
        {
            try {
                conn.close();
                l.info("Closed");
            }
            catch(Exception e)
            {
                l.log(Level.INFO,() -> String.valueOf(e));
            }
        }
    }
}
