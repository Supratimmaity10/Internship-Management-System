package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class fillingdetail extends JFrame implements ActionListener{
String v;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,t1,t2,t3,t8,l10;
    JTextField t4,t5,t6,t9,t10;
    JButton b1,b2;
    String name,sem,email,cap;
    int point;
    public fillingdetail(String u){
        setLayout(null);
        l1=new JLabel("INTERNSHIP DETAILS");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        l1.setBounds(20,5,180,20);
        l1.setForeground(Color.blue);
        add(l1);

        v=u;
        l2=new JLabel("USN");
        l2.setBounds(40,50,100,30);
        add(l2);


        t8=new JLabel(u);
        t8.setBounds(240,50,140,30);
        add(t8);

        l3=new JLabel("NAME");
        l3.setBounds(40,100,100,30);
        add(l3);

        t1=new JLabel();
        t1.setBounds(240,100,150,30);
        add(t1);

        l4=new JLabel("SEMESTER");
        l4.setBounds(40,150,100,30);
        add(l4);

        t2=new JLabel();
        t2.setBounds(240,150,150,30);
        add(t2);
        //.......................................................................................
        l5=new JLabel("EMAIL");
        l5.setBounds(40,200,90,30);
        add(l5);

        t3=new JLabel();
        t3.setBounds(240,200,150,30);
        add(t3);

        l6=new JLabel("ORGANISATION");
        l6.setBounds(40,250,120,30);
        add(l6);

        t4=new JTextField();
        t4.setBounds(240,250,150,30);
        add(t4);

        l7=new JLabel("ROLE");
        l7.setBounds(40,300,70,30);
        add(l7);

        t5=new JTextField();
        t5.setBounds(240,300,150,30);
        add(t5);

        l8=new JLabel("DURATION[MONTHS]");
        l8.setBounds(40,350,180,30);
        add(l8);

        t6=new JTextField();
        t6.setBounds(240,350,150,30);
        add(t6);

        l9=new JLabel("INTERNSHIP ID");
        l9.setBounds(40,400,180,30);
        add(l9);


        t9=new JTextField();
        t9.setBounds(240,400,150,30);
        add(t9);

        l10=new JLabel("STIPEND");
        l10.setBounds(40,450,120,30);
        add(l10);

        t10=new JTextField();
        t10.setBounds(240,450,150,30);
        add(t10);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l20=new JLabel(i2);
        l20.setBounds(0,0,1550,1000);
        add(l20);
        try{

            con c = new con();
            ResultSet rs = c.s.executeQuery("select * from student where usn = '"+v+"'");

            if(rs.next()){
                name=rs.getString("name");
                sem=rs.getString("sem");
                email=rs.getString("email");
                t1.setText(name);
                t2.setText(sem);
                t3.setText(email);
            }

        }catch(Exception e){ }

        try{con cc=new con();
            ResultSet rs1= cc.s.executeQuery("select * from activity where usn ='"+v+"'");
            if (rs1.next())
                cap=rs1.getString("point");

        }catch(Exception ex){}
         point=Integer.parseInt(cap);
        b1=new JButton("SUBMIT");
        b1.setBounds(100,530,100,40);
       b1.addActionListener(this);
       b1.setForeground(Color.white);
       b1.setBackground(Color.black);
        add(b1);

        b2=new JButton("CANCEL");
        b2.setBounds(300,530,100,40);
        b2.addActionListener(this);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        add(b2);

        setBounds(200,60,600,650);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b1){
        try{
            con c2=new con();

            String organisation=t4.getText();
            String role=t5.getText();
            String duration=t6.getText();
            String inid=t9.getText();
            int dur1=Integer.parseInt(duration);
            String stipend=t10.getText();

            if(dur1<=4)
            {dur1=dur1*10;
                point=dur1+point;
            }
            else
                point=point+50;

            if(point>=100)
                point=100;
          String str1="UPDATE activity SET POINT ='"+point+"' WHERE USN='"+v+"'";
            String str="insert into interndetail values('"+v+"','"+inid+"','"+name+"','"+sem+"','"+email+"','"+organisation+"','"+role+"','"+duration+"','"+stipend+"')";
            c2.s.executeUpdate(str);
    c2.s.executeUpdate(str1);
            JOptionPane.showMessageDialog(null,"DATA UPLOADED SUCCESFULLY");
this.setVisible(false);

        }
        catch (Exception ee){
        }

    }
    else if(ae.getSource()==b2){
        this.setVisible(false);



    }


}}




