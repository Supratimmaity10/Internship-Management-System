package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class studentdashboard extends JFrame implements ActionListener {
    JMenuBar mb;
    JLabel l1;
    JMenuItem m1, m2, m3, m4, m5;
    String v, name;

    public studentdashboard(String u) {
        setLayout(null);
        mb = new JMenuBar();
        add(mb);
        v = u;
        try {
            con c = new con();
            String str = "select * from student where usn='" + u + "'";
            ResultSet rs = c.s.executeQuery(str);
            while (rs.next()) {
                name = rs.getString("name");
            }
        } catch (Exception e) {
        }
        l1 = new JLabel("WELCOME  " + name);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 40));
        l1.setBounds(500, 80, 500, 50);
        l1.setForeground(Color.red);
        add(l1);

        m1 = new JMenuItem("FILL INTERNSHIP DETAILS");
        m1.addActionListener(this);
        mb.add(m1);

        m2 = new JMenuItem("AVAILABLE INTERNSHIP");
        m2.addActionListener(this);
        mb.add(m2);

        m5 = new JMenuItem("APPLY INTERNSHIP");
        m5.addActionListener(this);
        mb.add(m5);

        m3 = new JMenuItem("NOTIFICATION");

        mb.add(m3);

        m4 = new JMenuItem("LOGOUT");
        m4.addActionListener(this);
        mb.add(m4);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/clg1.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l7 = new JLabel(i2);
        l7.setBounds(0, 0, 1550, 1000);
        add(l7);

        setNotification();

        mb.setBounds(0, 0, 750, 30);
        setBounds(0, 0, 1950, 1020);
        setVisible(true);

    }

    Boolean checkNotification() {
        Boolean checkNoti = false;
        try {
            String str = "select count(internshipid) from notification where usn='" + v + "'";
            con checkQuery = new con();
            ResultSet rs2 = checkQuery.s.executeQuery(str);
            if (rs2.next()) {
                String s = rs2.getString(1);
                int count = Integer.parseInt(s);
                if (count > 0) {
                    checkNoti = true;
                }
            }
        } catch (Exception exx) {
        }
        return checkNoti;
    }

    void setNotification() {
        System.out.println(checkNotification());
        if (checkNotification()) {
            m3.setForeground(Color.red);
            m3.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("FILL INTERNSHIP DETAILS")) {
            new fillingdetail(v).setVisible(true);
        } else if (e.getActionCommand().equals("LOGOUT")) {
            new login().setVisible(true);
            this.setVisible(false);
        } else if (e.getActionCommand().equals("AVAILABLE INTERNSHIP")) {
            new availableinternshipstudent().setVisible(true);
        } else if (e.getActionCommand().equals("NOTIFICATION")) {
            System.out.println("CLicked");
            new notification(v).setVisible(true);
        } else if (e.getActionCommand().equals("APPLY INTERNSHIP")) {
            new applyinternship(v).setVisible(true);
        }
    }


}
