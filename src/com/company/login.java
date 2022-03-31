package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author SUPRATIM
 */
public class login extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4;
    public login(){


        setLayout(null);



        b1 = new JButton("TEACHER LOGIN");
        b1.setBounds(40,100,200,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("STUDENT LOGIN");
        b2.setBounds(300,100,200,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        b3=new JButton("ADMIN LOGIN");
        b3.setBounds(40,200,200,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        add(b3);

        b4=new JButton("COMPANY LOGIN");
        b4.setBounds(300,200,200,30);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.addActionListener(this);
        add(b4);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l9=new JLabel(i2);
        l9.setBounds(0,0,1550,1000);
        add(l9);

        setBounds(500,300,600,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            new studentlogin().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b1)
        {new teacherlogin().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b3){
new adminlogin().setVisible(true);
this.setVisible(false);
        }
        else if(ae.getSource()==b4){
new companylogin().setVisible(true);
this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new login().setVisible(true);
    }

}