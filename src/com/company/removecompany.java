package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class removecompany extends JFrame implements ActionListener{
Choice c1;
JLabel l1;
JButton b1,b2;
    public  removecompany(){
        setLayout(null);
        l1=new JLabel("COMPANY NAME");
        l1.setBounds(40,60,150,30);
        add(l1);

        c1=new Choice();
        try{
        con c=new con();
            ResultSet rs = c.s.executeQuery("select * from company");
            while(rs.next()){
                c1.add(rs.getString("name"));
            }
        }catch (Exception e){}
        add(c1);
        c1.setBounds(200,60,150,30);

        b1=new JButton("REMOVE");
        b1.setBounds(50,180,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("CANCEL");
        b2.setBounds(180,180,100,30);
        b2.addActionListener(this);
        add(b2);

        setBounds(200,200,400,300);
    }
    public void actionPerformed(ActionEvent ae){
if(ae.getSource()==b1){
    try{
        con c2=new con();
        String name= c1.getSelectedItem();
        String str="delete from company where name='"+name+"'";
        c2.s.executeUpdate(str);
        JOptionPane.showMessageDialog(null,"COMPANY DATA WAS DELETED");
        this.setVisible(false);
    }
    catch (Exception e){}
}
else  if(ae.getSource()==b2){

    this.setVisible(false);
}
    }
    public static void main(String[] args){
        new removecompany().setVisible(true);
    }
}
