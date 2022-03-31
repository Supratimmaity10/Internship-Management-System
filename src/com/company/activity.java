package com.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class activity extends JFrame implements ActionListener {
    JButton b1,b2;
    JTable table;
    JLabel l1,l2,l3;
    public activity(){
        setLayout(null);
        table=new JTable();
        table.setBounds(0,40,1000,500);
        add(table);

        l1=new JLabel("USN");
        l1.setBounds(5,10,150,30);
        add(l1);

        l2=new JLabel("STUDENT NAME");
        l2.setBounds(350,10,150,30);
        add(l2);

        l1=new JLabel("ACTIVITY POINT");
        l1.setBounds(650,10,150,30);
        add(l1);

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
                String str="select * from activity";
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
        new activity().setVisible(true);
    }
}
