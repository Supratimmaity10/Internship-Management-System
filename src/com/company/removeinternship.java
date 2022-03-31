package com.company;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class removeinternship  extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b1,b2,b3,b4;
    Choice c1,c2;
    public removeinternship(){
        setLayout(null);
        l1=new JLabel("USN");
        l1.setBounds(40,60,100,30);
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
        c1.setBounds(200,60,120,30);



        l2=new JLabel("NAME");
        l2.setBounds(40,110,120,30);
        add(l2);

        l3=new JLabel();
        l3.setBounds(200,110,160,30);
        add(l3);

        l4=new JLabel("INTERNSHIP ID");
        l4.setBounds(40,160,120,30);
        add(l4);

        c2=new Choice();
        c2.setBounds(200,160,120,30);
        add(c2);

        l5=new JLabel("COMPANY NAME");
        l5.setBounds(40,210,120,30);
        add(l5);

        l6=new JLabel();
        l6.setBounds(200,210,160,30);
        add(l6);

        l7=new JLabel("ROLE");
        l7.setBounds(40,270,120,30);
        add(l7);

        l8=new JLabel();
        l8.setBounds(200,270,160,30);
        add(l8);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l9=new JLabel(i2);
        l9.setBounds(0,0,1550,1000);
        add(l9);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b3 = new JButton(i6);
        b3.setBounds(350,60,20,20);
        b3.addActionListener(this);
        add(b3);

        b1=new JButton("REMOVE");
        b1.setBounds(150,390,100,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("CANCEL");
        b2.setBounds(340,390,100,30);
        b2.addActionListener(this);
        add(b2);

        b4=new JButton("LOAD DATA");
        b4.setBounds(400,60,140,30);
        b4.addActionListener(this);
        add(b4);
        setBounds(200,200,600,500);
    }
    public void actionPerformed(ActionEvent ae){
        String st=c1.getSelectedItem();
        String pt=null;
        String ptr=null;
        int dur,point;
    if(ae.getSource()==b1){
        try{
            con c4 = new con();
            ResultSet rs = c4.s.executeQuery("select * from activity where usn='"+st+"'");
            while(rs.next()){
                ptr=rs.getString("point");
            }
        }catch (Exception e2){}
        try{
            con c3= new con();
            String iddd=c2.getSelectedItem();
            ResultSet rs2 = c3.s.executeQuery("select * from interndetail where usn='"+st+"' and internshipid='"+iddd+"'");
            while(rs2.next()){
                pt= rs2.getString("duration");
            }
        }catch(Exception exx){ }

try{
    con ccc=new con();
    String id= c2.getSelectedItem();
    String str="delete from interndetail where usn='"+st+"' and internshipid='"+id+"'";
    ccc.s.executeUpdate(str);

}
catch (Exception e){}
try {con a=new con();
    dur=Integer.parseInt(pt);
    point= Integer.parseInt(ptr);
    if(dur<5){
        point=point-(dur*10);}
    else
        point=point-50;
    a.s.executeUpdate("update activity set point='"+point+"' where usn='"+st+"'");

    JOptionPane.showMessageDialog(null,"STUDENT DATA WAS DELETED");

}catch (Exception eeee){}
this.setVisible(false);
    }
    else if(ae.getSource()==b2){
this.setVisible(false);
    }
    else if (ae.getSource()==b3){
        try{
            con cc= new con();

            ResultSet rs = cc.s.executeQuery("select * from interndetail where usn='"+st+"'");
            while(rs.next()){
                c2.add(rs.getString("internshipid"));
                l3.setText(rs.getString("name"));
            }
        }catch(Exception e){ }
    }
    else if(ae.getSource()==b4){
        try{
            con cccc=new con();
            String idd=c2.getSelectedItem();
            String str="select * from interndetail where usn ='"+st+"' and internshipid ='"+idd+"'";
            ResultSet rs=cccc.s.executeQuery(str);
           while(rs.next()){
               l6.setText(rs.getString("cname"));
               l8.setText(rs.getString("role"));
           }
        }
        catch (Exception e){}


    }}
    public static void main(String[] args){
        new removeinternship().setVisible(true);
    }
}
