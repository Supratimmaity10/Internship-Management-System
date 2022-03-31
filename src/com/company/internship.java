package com.company;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class internship extends JFrame implements ActionListener{
JTable table;
JButton b1,b2;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    public internship(){
        setLayout(null);
        table=new JTable();
        table.setBounds(0,40,1000,500);
       add(table);

       l1=new JLabel("USN");
       l1.setBounds(5,10,100,30);
       add(l1);

       l2=new JLabel("INTERNSHIPID");
       l2.setBounds(110,10,120,30);
       add(l2);

       l3=new JLabel("NAME");
       l3.setBounds(230,10,100,30);
       add(l3);

       l4=new JLabel("SEMESTER");
       l4.setBounds(330,10,120,30);
       add(l4);

       l5=new JLabel("EMAIL");
       l5.setBounds(460,10,100,30);
       add(l5);

       l6=new JLabel("COMPANY");
       l6.setBounds(570,10,120,30);
       add(l6);

       l7=new JLabel("ROLE");
       l7.setBounds(670,10,100,30);
       add(l7);

       l8=new JLabel("DURATION");
       l8.setBounds(790,10,120,30);
       add(l8);

       l9=new JLabel("STIPEND");
       l9.setBounds(890,10,100,30);
       add(l9);

        b1=new JButton("LOAD DATA");
        add(b1);
        b1.setBounds(350,570,130,20);
        b1.addActionListener(this);

        b2=new JButton("BACK");
        b2.setBounds(530,570,120,20);
        b2.addActionListener(this);
        add(b2);

        setBounds(450,200,1000,650);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
        try{
            con c=new con();
            String str="select * from interndetail";
            ResultSet rs=c.s.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception e){}
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new internship().setVisible(true);
    }
}
