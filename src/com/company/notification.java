package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class notification extends JFrame implements  ActionListener{
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JButton b1;
String u,d;
    public notification(String v){
        setLayout(null);
        l1=new JLabel("YOU GOT A OFFER FROM ");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l1.setBounds(10,30,280,40);
        l1.setForeground(Color.black);
        add(l1);

        u=v;

        l2=new JLabel();
        l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        l2.setBounds(300,30,130,40);
        add(l2);

        l3=new JLabel("ROLE");
        l3.setBounds(60,110,100,30);
        add(l3);

        l4=new JLabel();
        l4.setBounds(200,110,140,30);
        add(l4);

        l5=new JLabel("STIPEND");
        l5.setBounds(60,170,140,30);
        add(l5);

        l6=new JLabel();
        l6.setBounds(200,170,140,30);
        add(l6);

        l7=new JLabel("INTERNSHIP ID");
        l7.setBounds(60,230,140,30);
        add(l7);

        l8=new JLabel();
        l8.setBounds(200,230,140,30);
        add(l8);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l9=new JLabel(i2);
        l9.setBounds(0,0,1550,1000);
        add(l9);

        try{
        con c=new con();
        String st="select * from notification where usn='"+v+"'";
        ResultSet rs=c.s.executeQuery(st);
        while (rs.next()){
            l2.setText(rs.getString("cname"));
            l4.setText(rs.getString("role"));
            l6.setText(rs.getString("stipend"));
            d=rs.getString("internshipid");
            l8.setText(d);
        }
        }catch (Exception e){}

        b1=new JButton("MARK AS READ");
        b1.setBounds(300,350,150,30);
        add(b1);
        b1.addActionListener(this);

        setBounds(300,200,500,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
            con c=new con();
            c.s.executeUpdate("delete from notification where usn='"+u+"'");
            this.setVisible(false);
            }catch (Exception e){}
        }
    }


}
