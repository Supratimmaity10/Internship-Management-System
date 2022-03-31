package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class removestudent extends JFrame implements ActionListener{

    Choice c1;
    JLabel l1,l2,l3,l4,l5;
    String str,str1;
    JButton b3,b1,b2;
    public removestudent(){
        setLayout(null);
        l1=new JLabel("STUDENT USN");
        l1.setBounds(40,60,150,30);
        add(l1);

        c1=new Choice();
        try{
            con c = new con();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                c1.add(rs.getString("usn"));
            }
        }catch(Exception e){ }
        add(c1);
        c1.setBounds(250,60,120,30);



        l2=new JLabel("STUDENT NAME");
        l2.setBounds(40,110,150,30);
        add(l2);

        l3=new JLabel(str);
        l3.setBounds(250,110,150,30);
        add(l3);

        l4=new JLabel("SEMESTER");
        l4.setBounds(40,160,150,30);
        add(l4);

        l5=new JLabel(str1);
        l5.setBounds(250,160,150,30);
        add(l5);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b3 = new JButton(i6);
        b3.setBounds(370,60,20,20);
        b3.addActionListener(this);
        add(b3);

        b1=new JButton("REMOVE");
        b1.setBounds(60,220,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("CANCEL");
        b2.setBounds(280,220,100,30);
        b2.addActionListener(this);
        add(b2);

        setBounds(600,200,500,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b3){
            try{

                con c = new con();
                String number = c1.getSelectedItem();
                ResultSet rs = c.s.executeQuery("select * from student where usn = '"+number+"'");

                if(rs.next()){
                    str=rs.getString("name");
                    l3.setText(str);
                    l5.setText(rs.getString("sem"));

                }}
            catch(Exception e){}
        }
        else if(ae.getSource()==b1){
            try {
                con cc=new con();
                String id=c1.getSelectedItem();
                cc.s.executeUpdate("delete from student where usn='"+id+"'");
                JOptionPane.showMessageDialog(null,"STUDENT DATA DELETED");
                this.setVisible(false);
            }catch (Exception e){}
        }
        else if(ae.getSource()==b2){

            this.setVisible(false);
        }
    }

    public static void main(String[] args){
        new removestudent().setVisible(true);
    }
}
