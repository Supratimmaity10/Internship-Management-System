package com.company;

import java.sql.*;

public class con{
    Connection c;
    Statement s;
    public con(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql:///ims","root","supratim");

            s =c.createStatement();


        }catch(Exception e){
            System.out.println(e);
        }
    }
}