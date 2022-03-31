package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Dashboard extends JFrame implements ActionListener{
    JLabel l1;
    JMenuBar mb;
    JMenu m1,m4;
    JMenuItem i1,i2,i3,i4,m5,m3,m2;
    public Dashboard(){
        setLayout(null);
     mb=new JMenuBar();
     add(mb);

     m1=new JMenu("INTERNSHIP DETAILS");
     mb.add(m1);

     m2=new JMenuItem("ACTIVITY POINTS");
     m2.addActionListener(this);
     mb.add(m2);

     m3=new JMenuItem("ADD STUDENT");
     m3.addActionListener(this);
     mb.add(m3);

     m4=new JMenu("REMOVE");
     mb.add(m4);

     m5=new JMenuItem("LOGOUT");
     m5.addActionListener(this);
     mb.add(m5);

     i1=new JMenuItem("ALL DETAILS");
     i1.addActionListener(this);
     m1.add(i1);

     i2=new JMenuItem("PARTICULAR DETAILS");
     i2.addActionListener(this);
     m1.add(i2);

     i3=new JMenuItem("REMOVE STUDENT");
     i3.addActionListener(this);
     m4.add(i3);

     i4= new JMenuItem("INTERNSHIP DETAILS");
     i4.addActionListener(this);
     m4.add(i4);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l7=new JLabel(i2);
        l7.setBounds(0,0,1950,1000);
        add(l7);


    mb.setBounds(0,0,540,30);
        setBounds(0,0,1950,1020);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
if(ae.getActionCommand().equals("ALL DETAILS")){
new internship().setVisible(true);

}
else if(ae.getActionCommand().equals("ACTIVITY POINTS")){
new activity().setVisible(true);
}
else if(ae.getActionCommand().equals("ADD STUDENT")) {
    new addstudent().setVisible(true);
}
else if(ae.getActionCommand().equals("PARTICULAR DETAILS")){
new searchintern().setVisible(true);
}
else if(ae.getActionCommand().equals("LOGOUT")){
    new login().setVisible(true);
    this.setVisible(false);
}
else if(ae.getActionCommand().equals("REMOVE STUDENT")){
new removestudent().setVisible(true);
}
else if(ae.getActionCommand().equals("INTERNSHIP DETAILS")){
new removeinternship().setVisible(true);
}
}

    public static void main(String[] args){
        new Dashboard().setVisible(true);
    }
}
