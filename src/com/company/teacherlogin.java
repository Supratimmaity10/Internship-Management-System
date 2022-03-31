package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class teacherlogin extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    public teacherlogin(){
        setLayout(null);

        l1 = new JLabel("ID");
        l1.setBounds(40,20,100,30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);

        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        setBounds(600,350,600,300);

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(this);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l9=new JLabel(i2);
        l9.setBounds(0,0,1550,1000);
        add(l9);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                con c1 = new con();
                String u = t1.getText();
                String v = t2.getText();

                String q = "select * from teacher where id='"+u+"' and password='"+v+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    new Dashboard().setVisible(true);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==b2){
                System.exit(0);


            }

        }
        public static void main(String[] args){
        new teacherlogin().setVisible(true);
    }
}
