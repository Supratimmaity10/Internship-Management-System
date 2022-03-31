
package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class deletecompanyinternship extends JFrame implements ActionListener {
    Choice c1;
    JLabel l1,l2,l3;
    JButton b1,b2,b3;
    String u;
    public deletecompanyinternship(String v){
setLayout(null);
u=v;

l1=new JLabel("INTERNSHIP ID");
l1.setBounds(40,60,140,30);
add(l1);

c1=new Choice();
try {
    con c=new con();
    ResultSet rs = c.s.executeQuery("select * from offerintern where cname='"+v+"'");
    while(rs.next()){
        c1.add(rs.getString("internshipid"));
    }
}catch (Exception e){}
c1.setBounds(180,60,180,30);
add(c1);

l3=new JLabel("ROLE");
l3.setBounds(40,120,120,30);
add(l3);

l2=new JLabel();
l2.setBounds(180,120,180,30);
add(l2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
          ImageIcon i6 = new ImageIcon(i5);
           b3 = new JButton(i6);
          b3.setBounds(350,60,20,20);
         b3.addActionListener(this);
         add(b3);

        b1=new JButton("REMOVE INTERNSHIP");
        b1.setBounds(50,270,170,40);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("CANCEL");
        b2.setBounds(250,270,100,40);
        b2.addActionListener(this);
        add(b2);


        setBounds(300,300,400,400);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try {
                con c2=new con();
                String id= c1.getSelectedItem();
                String str="delete from offerintern where internshipid='"+id+"'";
                c2.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"INTERNSHIP WAS DELETED");
            }catch (Exception e){}
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
        else if(ae.getSource()==b3){
          try{  con c3 = new con();
            String number=c1.getSelectedItem();
            ResultSet rs = c3.s.executeQuery("select * from offerintern where internshipid = '"+number+"'");
            if(rs.next()){
                l2.setText(rs.getString("role"));
            }
        }catch (Exception ee){}
        }
    }
}
