package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class applyinternship extends JFrame implements  ActionListener{
JLabel l1,l2,l3,l4,l5,l6;
Choice c1,c2;
String v;
JButton b1,b2,b3,b4;
    public applyinternship(String u){
v=u;
setLayout(null);

l1=new JLabel("COMPANY NAME");
l1.setBounds(40,50,140,30);
add(l1);

c1=new Choice();
try{
    con c = new con();
    ResultSet rs = c.s.executeQuery("select * from company");
    while(rs.next()){
        c1.add(rs.getString("name"));}
}catch (Exception e){}
c1.setBounds(200,50,140,30);
add(c1);

l2=new JLabel("INTERNSHIP ID");
l2.setBounds(40,120,140,30);
add(l2);

c2=new Choice();
c2.setBounds(200,120,140,30);
add(c2);

l3=new JLabel("ROLE");
l3.setBounds(40,190,100,30);
add(l3);

l4=new JLabel();
l4.setBounds(200,190,140,30);
add(l4);

l5=new JLabel("STIPEND");
l5.setBounds(40,260,140,30);
add(l5);

l6=new JLabel();
l6.setBounds(200,260,140,30);
add(l6);

b1=new JButton("APPLY INTERNSHIP");
b1.addActionListener(this);
b1.setBounds(60,330,150,30);
add(b1);

b2=new JButton("CANCEL");
b2.setBounds(270,330,100,30);
b2.addActionListener(this);
add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(370,50,20,20);
        b3.addActionListener(this);
        add(b3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b4 = new JButton(i6);
        b4.setBounds(370,120,20,20);
        b4.addActionListener(this);
        add(b4);

        setBounds(200,200,450,500);
setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String aa=c1.getSelectedItem();
        String bb;
        String name = null,sem = null;
        if(ae.getSource()==b1){
        try{bb= c2.getSelectedItem();
            con ccc=new con();
            ResultSet rs1=ccc.s.executeQuery("select * from student where usn='"+v+"'");
            while(rs1.next()){
            name=rs1.getString("name");
            sem= rs1.getString("sem");
            }
            String str="insert into availintern values('"+bb+"','"+aa+"','"+v+"','"+name+"','"+sem+"')";
            ccc.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"INTERNSHIP APPLICATION SUCCESFULL");
        }catch (Exception exx){}
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
        else if(ae.getSource()==b3){
            try{
                con c=new con();
                ResultSet rs = c.s.executeQuery("select * from offerintern where cname='"+aa+"'");
                while(rs.next()){
                    c2.add(rs.getString("internshipid"));}

            }catch (Exception e){}
        }
        else if(ae.getSource()==b4){
            try{
                con cc=new con();
                bb= c2.getSelectedItem();
                ResultSet rss = cc.s.executeQuery("select * from offerintern where internshipid = '"+bb+"' and cname='"+aa+"'");

                if(rss.next()) {
                    l4.setText(rss.getString("role"));
                    l6.setText(rss.getString("stipend"));
                }

                }catch (Exception ex){}
        }
    }

}
