
package com.company;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class availinternhsip extends JFrame implements ActionListener{
    JTable t1;
    JButton b1,b2;
    Choice c1;
    JLabel l1,l2,l3,l4,l5;
    String u;
    public availinternhsip(String v){
        setLayout(null);
        t1=new JTable();
        t1.setBounds(0,150,600,200);
        add(t1);
        l1=new JLabel("INTERNSHIP ID");
        l1.setBounds(40,50,150,30);
        add(l1);

        u=v;

        c1=new Choice();
        try {
            con c=new con();
            ResultSet rs = c.s.executeQuery("select * from offerintern where cname='"+v+"'");
            while(rs.next()){
                c1.add(rs.getString("internshipid"));
            }
        }catch (Exception e){}
        c1.setBounds(190,50,170,30);
        add(c1);

        l2=new JLabel("USN");
        l2.setBounds(5, 120,150,30);
        add(l2);
        l3=new JLabel("STUDENT NAME");
        l3.setBounds(210,120,150,30);
        add(l3);
        l4=new JLabel("SEMESTER");
        l4.setBounds(410,120,150,30);
        add(l4);

        b1=new JButton("LOAD DATA");
        b1.setBounds(50,400,140,40);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("CANCEL");
        b2.setBounds(320,400,140,40);
        b2.addActionListener(this);
        add(b2);


        setBounds(300,300,600,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                con cc=new con();
                String s=c1.getSelectedItem();
                String str="select usn,sname,sem from availintern where internshipid='"+s+"' and cname='"+u+"'";
                ResultSet rs=cc.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){}
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
}
