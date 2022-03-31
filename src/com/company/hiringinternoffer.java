package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class hiringinternoffer extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4;
    Choice c1,c2;
    JLabel l1,l2,l3,l4,l5,l6;
    String u,role,stipend;
    public hiringinternoffer(String v){
        setLayout(null);
        l1=new JLabel("INTERNSHIP ID");
        l1.setBounds(40,50,150,30);
        add(l1);
u=v;//u-companyname
        c1=new Choice();
        c2=new Choice();
        try{
            con c = new con();
            ResultSet rs = c.s.executeQuery("select * from offerintern where cname='"+v+"'");
            while(rs.next()){
                c1.add(rs.getString("internshipid"));
            }
        }catch (Exception e){}
        c1.setBounds(200,50,150,30);
        add(c1);

        l2=new JLabel("STUDENT NAME");
        l2.setBounds(40,110,150,30);
        add(l2);

        c2.setBounds(200,110,150,30);
        add(c2);

        l3=new JLabel("USN");
        l3.setBounds(40,170,100,30);
        add(l3);

        l4=new JLabel();
        l4.setBounds(200,170,140,30);
        add(l4);

        l5=new JLabel("SEMESTER");
        l5.setBounds(40,240,140,30);
        add(l5);

        l6=new JLabel();
        l6.setBounds(200,240,140,30);
        add(l6);

        b1=new JButton("HIRE");
        b1.setBounds(60,300,140,30);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("CANCEL");
        b2.setBounds(260,300,140,30);
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
        b4.setBounds(370,110,20,20);
        b4.addActionListener(this);
        add(b4);

        setBounds(200,200,500,450);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String aa=c1.getSelectedItem();
        String bb,usn = null,sem = null;
        if(ae.getSource()==b1){
try {
    bb= c2.getSelectedItem();
    con ccc=new con();
    ResultSet rs2 = ccc.s.executeQuery("select * from student where name = '"+bb+"'");
    while(rs2.next()){

    usn= rs2.getString("usn");
    sem=rs2.getString("sem");}
    String str="insert into hiringoffer values('"+aa+"','"+bb+"','"+usn+"','"+sem+"')";
    ccc.s.executeUpdate(str);
    ccc.s.executeUpdate("insert into notification values('"+usn+"','"+aa+"','"+u+"','"+role+"','"+stipend+"')");

}catch (Exception exx){}

            try{
                con c4=new con();
                aa= c1.getSelectedItem();
                ResultSet rsss = c4.s.executeQuery("select * from offerintern where internshipid = '"+aa+"'");

                while(rsss.next()){
                    role=rsss.getString("role");
                    stipend=rsss.getString("stipend");
                }
                c4.s.executeUpdate("insert into notification values('"+usn+"','"+aa+"','"+u+"','"+role+"','"+stipend+"')");
                JOptionPane.showMessageDialog(null,"OFFER SEND SUCCESFULL");

            }catch (Exception e2){}

        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
        else if(ae.getSource()==b3){
            try{
                con c=new con();
                ResultSet rs = c.s.executeQuery("select * from availintern where internshipid='"+aa+"'");
                while(rs.next()){
                    c2.add(rs.getString("sname"));}

            }catch (Exception e){}
        }
        else if(ae.getSource()==b4){
            try{
                con cc=new con();
                bb= c2.getSelectedItem();
                ResultSet rss = cc.s.executeQuery("select * from student where name = '"+bb+"'");

                while(rss.next()){
                    l4.setText(rss.getString("usn"));
                    l6.setText(rss.getString("sem"));
                }

            }catch (Exception ex){}
        }
    }
}
