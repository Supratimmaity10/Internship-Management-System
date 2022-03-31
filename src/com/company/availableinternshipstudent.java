package com.company;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class availableinternshipstudent extends JFrame {
    JTable t1;
    JLabel l1,l2,l3,l4,l5;
    public  availableinternshipstudent(){
        setLayout(null);
        t1=new JTable();
        t1.setBounds(0,30,750,360);
        add(t1);
        try{
            con c=new con();
            String str="select * from offerintern";
            ResultSet rs=c.s.executeQuery(str);
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){}

        l1=new JLabel("INTERNSHIP ID");
        l1.setBounds(5,5,120,25);
        add(l1);

        l2=new JLabel("COMPANY NAME");
        l2.setBounds(160,5,120,25);
        add(l2);

        l3=new JLabel("ROLE");
        l3.setBounds(305,5,100,25);
        add(l3);

        l4=new JLabel("DURATION(MONTHS)");
        l4.setBounds(460,5,140,25);
        add(l4);

        l5=new JLabel("STIPEND");
        l5.setBounds(600,5,120,25);
        add(l5);

        setBounds(200,200,750,400);
        setVisible(true);
    }
}
