package com.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class delete extends JFrame implements ActionListener {
    JTable table;
    JButton b1, b2,b3;
    JLabel l1, l2, l3;
    Choice c1;
    public delete() {
        setLayout(null);
        table=new JTable();
        table.setBounds(0,100,1000,400);
        add(table);

        l1=new JLabel("USN");
        l1.setBounds(340,35,40,30);
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
        c1.setBounds(400,35,120,30);

        b1=new JButton("DELETE DATA");
        add(b1);
        b1.setBounds(350,570,130,20);
        b1.addActionListener(this);

        b2=new JButton("BACK");
        b2.setBounds(530,570,120,20);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b3 = new JButton(i6);
        b3.setBounds(570,40,20,20);
        b3.addActionListener(this);
        add(b3);


        setBounds(450,200,1000,650);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b3){
            try{
                con c=new con();
                String s=c1.getSelectedItem();
                String str="select * from internship where usn='"+s+"'";
                ResultSet rs=c.s.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            catch (Exception e){}
        }
        else if(ae.getSource()==b2){
            new Dashboard().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b1){
            try{
                con cc=new con();
                String s1=c1.getSelectedItem();
                String str1="delete from internship where usn='"+s1+"'";
                cc.s.executeUpdate(str1);
                int a=0;
                String str2="update activity set point='"+a+"' where usn ='"+s1+"'";
                String str3="update student set cap='"+a+"' where usn ='"+s1+"'";
                cc.s.executeUpdate(str2);
                cc.s.executeUpdate(str3);
                JOptionPane.showMessageDialog(null,"Internships details are deleted");
            }catch (Exception e){
            }
        }
    }
    public static void main(String[] args){
        new delete().setVisible(true);
    }
}
