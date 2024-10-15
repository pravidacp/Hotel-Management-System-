package hotel.management.system1;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
    
public class ManagerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
   ManagerInfo(){
       
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel l1=new JLabel("Name ");
       l1.setBounds(40,10,100,20);
       add(l1);
       
       JLabel l2=new JLabel("Age ");
       l2.setBounds(170,10,100,20);
       add(l2);
       
       JLabel l3=new JLabel("Gender ");
       l3.setBounds(290,10,100,20);
       add(l3);
       
       JLabel l4=new JLabel("Job ");
       l4.setBounds(400,10,100,20);
       add(l4);
       
       JLabel l5=new JLabel("Salary ");
       l5.setBounds(520,10,100,20);
       add(l5);
       
      JLabel l6=new JLabel("Phone No ");
       l6.setBounds(630,10,100,20);
       add(l6);
       
       JLabel l7=new JLabel("Email ");
       l7.setBounds(760,10,100,20);
       add(l7);
       
       JLabel l8=new JLabel("Aadhar ");
       l8.setBounds(880,10,100,20);
       add(l8);
       
       
       
       table=new JTable();
       table.setBounds(0,50,1000,400);
       add(table);
       
       try{
           Conn conn=new Conn();
           ResultSet rs=conn.s.executeQuery("select * from Employee where job='Manager';");
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
       
       setBounds(250,150,1000,550);
       setVisible(true);
   }
   public void actionPerformed(ActionEvent ae){
       setVisible(false);
       new Reception();
   }
   
    public static void main(String args[]){
        new ManagerInfo();
    }
}



