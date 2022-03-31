package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class addstudent extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;

    public addstudent(){
        setLayout(null);
        l1=new JLabel("USN");
        l1.setBounds(30,40,150,20);
        add(l1);

        t1=new JTextField();
        t1.setBounds(180,40,150,20);
        add(t1);

        l2=new JLabel("NAME");
        l2.setBounds(30,80,150,20);
        add(l2);

        t2=new JTextField();
        t2.setBounds(180,80,150,20);
        add(t2);
        l3=new JLabel("PASSWORD");
        l3.setBounds(30,120,150,20);
        add(l3);

        t3=new JTextField();
        t3.setBounds(180,120,150,20);
        add(t3);
        l4=new JLabel("SEMESTER");
        l4.setBounds(30,160,150,20);
        add(l4);

        t4=new JTextField();
        t4.setBounds(180,160,150,20);
        add(t4);
        l5=new JLabel("EMAIL");
        l5.setBounds(30,200,150,20);
        add(l5);

        t5=new JTextField();
        t5.setBounds(180,200,150,20);
        add(t5);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l20=new JLabel(i6);
        l20.setBounds(0,0,1550,1000);
        add(l20);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/student.png"));
        Image i3 = i1.getImage().getScaledInstance(200, 290,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(250,20,400,300);
        add(image);

        b1=new JButton("SUBMIT");
        b1.setBounds(60,250,100,20);
        add(b1);
        b1.addActionListener(this);

        b2=new JButton("CANCEL");
        b2.setBounds(180,250,100,20);
        add(b2);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setBounds(250,250,600,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                con c=new con();
                String usn=t1.getText();
                String name=t2.getText();
                String password=t3.getText();
                String sem=t4.getText();
                String email=t5.getText();
                int no=0;
                int cap=0;
                String str="insert into student values('"+usn+"','"+name+"','"+sem+"','"+email+"','"+no+"','"+password+"')";
                c.s.executeUpdate(str);
                String str1="insert into activity values('"+usn+"','"+name+"','"+cap+"')";
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"DATA UPLOADED SUCCESFULLY");
                this.setVisible(false);
            }
            catch (Exception e){}
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }

    }
    public static void main(String[] args){
        new addstudent().setVisible(true);
    }

}
