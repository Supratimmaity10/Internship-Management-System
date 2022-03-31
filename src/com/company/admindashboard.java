package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class admindashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4,m3;
    public admindashboard(){
        setLayout(null);
        mb=new JMenuBar();
        add(mb);

        m1=new JMenu("TEACHER");
        m1.addActionListener(this);
        mb.add(m1);

        m2=new JMenu("COMPANY");
        m2.addActionListener(this);
        mb.add(m2);

        m3=new JMenuItem("LOGOUT");
        m3.addActionListener(this);
        mb.add(m3);

      i1=new JMenuItem("ADD TEACHER");
      i1.addActionListener(this);
      m1.add(i1);

      i2=new JMenuItem("REMOVE TEACHER");
      i2.addActionListener(this);
      m1.add(i2);

      i3=new JMenuItem("ADD COMPANY");
      i3.addActionListener(this);
      m2.add(i3);

      i4=new JMenuItem("REMOVE COMPANY");
      i4.addActionListener(this);
      m2.add(i4);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/dash.jpg"));
        Image i33 = ii1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(i33);
        JLabel l7=new JLabel(i22);
        l7.setBounds(0,0,1550,900);
        add(l7);

        JLabel lid = new JLabel("ADMIN DASHBOARD");
        lid.setBounds(550, 100, 800, 100);
        lid.setFont(new Font("serif", Font.PLAIN, 40));
        lid.setForeground(Color.white);
        l7.add(lid);

        mb.setBounds(0,0,250,30);
        setBounds(0,0,1950,1020);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("ADD TEACHER")){
        new addteacher().setVisible(true);


        }
        else if(e.getActionCommand().equals("REMOVE TEACHER")){
      new removeteacher().setVisible(true);
        }
        else if(e.getActionCommand().equals("ADD COMPANY")){
        new  addcompany().setVisible(true);

        }
        else if(e.getActionCommand().equals("REMOVE COMPANY")){
new removecompany().setVisible(true);

        }
        else if(e.getActionCommand().equals("LOGOUT")){
            this.setVisible(false);
            new login().setVisible(true);

        }
    }
    public static void main(String[] args){
        new admindashboard().setVisible(true);
    }

}
