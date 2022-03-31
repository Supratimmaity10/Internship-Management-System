package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class createinternship extends JFrame implements ActionListener{
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4;
    String v;
    public createinternship(String u){
        setLayout(null);
        l1=new JLabel("COMPANY NAME");
        l1.setBounds(40,60,100,30);
        add(l1);

        v=u;

        l2=new JLabel(u);
        l2.setBounds(210,60,100,30);
        add(l2);

        l3=new JLabel("INTERNSHIP ID");
        l3.setBounds(40,110,120,30);
        add(l3);

        t1=new JTextField();
        t1.setBounds(210,110,120,30);
        add(t1);

        l4=new JLabel("ROLE");
        l4.setBounds(40,160,120,30);
        add(l4);

        t2=new JTextField();
        t2.setBounds(210,160,120,30);
        add(t2);

        l5=new JLabel("DURATION(MONTHS)");
        l5.setBounds(40,210,140,30);
        add(l5);

        t3=new JTextField();
        t3.setBounds(210,210,120,30);
        add(t3);

        l6=new JLabel("STIPEND");
        l6.setBounds(40,260,120,30);
        add(l6);

        t4=new JTextField();
        t4.setBounds(210,260,120,30);
        add(t4);

        b1=new JButton("SUBMIT");
        b1.setBounds(50,320,100,40);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("CANCEL");
        b2.setBounds(200,320,100,40);
        b2.addActionListener(this);
        add(b2);
        setBounds(300,300,500,500);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try {
                con c=new con();
                String id=t1.getText();
                String role=t2.getText();
                String dur=t3.getText();
                String stipend=t4.getText();
                String str="insert into offerintern values('"+id+"','"+v+"','"+role+"','"+dur+"','"+stipend+"')";

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"INTERNSHIP WAS CREATED" );
                this.setVisible(false);
            }catch (Exception e){}
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
}
