
package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class companydashboard extends JFrame implements ActionListener{
    JMenuBar mb;

    JMenuItem m1,m2,m3,m4,m5;
    String v;
    public companydashboard(String u){
        setLayout(null);
mb=new JMenuBar();
mb.setBounds(0,0,650,30);
add(mb);

v=u;

m1=new JMenuItem("CREATE INTERNSHIP");
mb.add(m1);
m1.addActionListener(this);

m2=new JMenuItem("APPLIED STUDENTS");
mb.add(m2);
m2.addActionListener(this);

m3=new JMenuItem("HIRING INTERN");
mb.add(m3);
m3.addActionListener(this);

m5=new JMenuItem("DELETE INTERNSHIP");
mb.add(m5);
m5.addActionListener(this);

m4=new JMenuItem("LOGOUT");
mb.add(m4);
m4.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/cmp.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l7=new JLabel(i2);
        l7.setBounds(0,0,1550,1000);
        add(l7);

setVisible(true);
setBounds(0,0,1950,1020);
    }
public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("CREATE INTERNSHIP")){
new createinternship(v).setVisible(true);
        }
        else if(ae.getActionCommand().equals("APPLIED STUDENTS")){
new availinternhsip(v).setVisible(true);
        }
        else if(ae.getActionCommand().equals("HIRING INTERN")){
new hiringinternoffer(v).setVisible(true);
        }
        else if(ae.getActionCommand().equals("LOGOUT")){
            new login().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getActionCommand().equals("DELETE INTERNSHIP")){
            new deletecompanyinternship(v).setVisible(true);
        }
}

}
