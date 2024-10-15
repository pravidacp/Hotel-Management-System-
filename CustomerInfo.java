package hotel.management.system1;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
    
public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
   CustomerInfo(){
       
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel l1=new JLabel("Document Type ");
       l1.setBounds(10,10,100,20);
       add(l1);
       
       JLabel l2=new JLabel("Number ");
       l2.setBounds(160,10,100,20);
       add(l2);
       
       JLabel l3=new JLabel("Name ");
       l3.setBounds(270,10,100,20);
       add(l3);
       
       JLabel l4=new JLabel("Gender ");
       l4.setBounds(400,10,100,20);
       add(l4);
       
       JLabel l5=new JLabel("Country ");
       l5.setBounds(520,10,100,20);
       add(l5);
       
      JLabel l6=new JLabel("Room No ");
       l6.setBounds(630,10,100,20);
       add(l6);
       
       JLabel l7=new JLabel("Checkin time ");
       l7.setBounds(760,10,100,20);
       add(l7);
       
       JLabel l8=new JLabel("Deposite ");
       l8.setBounds(880,10,100,20);
       add(l8);
       
       
       
       table=new JTable();
       table.setBounds(0,50,1000,400);
       add(table);
       
       try{
           Conn conn=new Conn();
           ResultSet rs=conn.s.executeQuery("select * from customer;");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       back=new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(380,450,120,30);
       back.addActionListener(this);
       add(back);
       
       setBounds(200,100,1000,550);
       setVisible(true);
   }
   public void actionPerformed(ActionEvent ae){
       setVisible(false);
       new Reception();
   }
   
    public static void main(String args[]){
        new CustomerInfo();
    }
}



