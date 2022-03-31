package com.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class delparticular extends JFrame implements ActionListener {
    JTable table;
    JLabel l1,l2;
    Choice c1;
    JButton b1,b2,b3,b4;
    JTextField t1;
    public delparticular(){
        setLayout(null);
        table=new JTable();
        table.setBounds(0,100,1000,500);
        add(table);

        c1=new Choice();
        try{
            con c = new con();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                c1.add(rs.getString("usn"));
            }
        }catch(Exception e){ }
        add(c1);
        c1.setBounds(150,15,120,20);
        l1=new JLabel("USN");
        l1.setBounds(40,15,60,20);
        add(l1);

      //  ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        //Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
      //  ImageIcon i6 = new ImageIcon(i5);
     //   b3 = new JButton(i6);
      //  b3.setBounds(240,15,20,20);
       // b3.addActionListener(this);
       // add(b3);

        b4=new JButton("SHOW DATA");
        b4.setBounds(300,50,130,20);
        b4.addActionListener(this);
        add(b4);

        l2=new JLabel("INTERNSHIP NO");
        l2.setBounds(40,50,150,20);
        add(l2);
        t1=new JTextField();
        t1.setBounds(180,50,120,20);
        add(t1);

        b1=new JButton("LOAD DATA");
        add(b1);
        b1.setBounds(350,570,130,20);
        b1.addActionListener(this);

        b2=new JButton("BACK");
        b2.setBounds(530,570,120,20);
        b2.addActionListener(this);
        add(b2);

        setBounds(450,200,1000,650);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
        try{
            con c=new con();
            String usn=c1.getSelectedItem();
            String n=t1.getText();
            c.s.executeUpdate("delete from internship where usn='"+usn+"' and sno='"+n+"'");
        }
        catch(Exception e){}
        }
        else if(ae.getSource()==b2){
            new Dashboard().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b4){
            try{
                con c=new con();
                String u=c1.getSelectedItem();
                String str="select * from internship where usn ='"+u+"'";
                ResultSet rs=c.s.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            catch (Exception e){}
        }
    }
    public static void main(String[] args){
        new delparticular().setVisible(true);

    }
}
