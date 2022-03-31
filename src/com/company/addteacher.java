
package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class addteacher extends JFrame implements ActionListener{
    JButton b1,b2;
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    public  addteacher(){
        setLayout(null);
        l1=new JLabel("FACULTY ID");
        l1.setBounds(40,60,170,30);
        add(l1);

        t1=new JTextField();
        t1.setBounds(220,60,140,30);
        add(t1);

        l2=new JLabel("FACULTY NAME");
        l2.setBounds(40,110,170,30);
        add(l2);

        t2=new JTextField();
        t2.setBounds(220,110,140,30);
        add(t2);

        l3=new JLabel("PASSWORD");
        l3.setBounds(40,160,100,30);
        add(l3);

        t3=new JTextField();
        t3.setBounds(220,160,140,30);
        add(t3);

        b1=new JButton("SUBMIT");
        b1.setBounds(50,230,120,30);
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("CANCEL");
        b2.setBounds(210,230,120,30);
        b2.addActionListener(this);
        add(b2);
        setBounds(600,200,400,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
        con c1=new con();
        String id=t1.getText();
        String name=t2.getText();
        String password=t3.getText();
        String str="insert into teacher values('"+id+"','"+name+"','"+password+"')";
                c1.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"DATA UPLOADED SUCCESFULLY");
                this.setVisible(false);
            } catch (Exception e) {
            }

        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new addteacher().setVisible(true);
    }
}
