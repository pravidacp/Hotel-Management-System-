package hotel.management.system1;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
    
public class Department extends JFrame implements ActionListener{
    JTable table;
    JButton back;
   Department(){
       
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel l1=new JLabel("Deparment ");
       l1.setBounds(180,10,100,20);
       add(l1);
       
       JLabel l2=new JLabel("Budget ");
       l2.setBounds(370,10,100,20);
       add(l2);
       
       
       
       table=new JTable();
       table.setBounds(0,50,700,350);
       add(table);
       
       try{
           Conn conn=new Conn();
           ResultSet rs=conn.s.executeQuery("select * from department;");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       back=new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(280,400,120,30);
       back.addActionListener(this);
       add(back);
       
       setBounds(250,150,700,550);
       setVisible(true);
   }
   public void actionPerformed(ActionEvent ae){
       setVisible(false);
       new Reception();
   }
   
    public static void main(String args[]){
        new Department();
    }
}


