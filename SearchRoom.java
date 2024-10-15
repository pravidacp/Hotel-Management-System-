package hotel.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
   SearchRoom(){
       
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
     JLabel lblbed=new JLabel("Bed Type");
     lblbed.setBounds(50,100,100,120);
     add(lblbed);
     
     bedType=new JComboBox(new String[]{"Single Bed","Double Bed"});
     bedType.setBounds(150,150,150,25);
     bedType.setBackground(Color.WHITE);
     add(bedType);
     
     available=new JCheckBox("Only Display Available");
     available.setBounds(650,150,200,25);
     available.setBackground(Color.WHITE);
     add(available);
       
     JLabel text=new JLabel("Search for Room");
     text.setFont(new Font("Tahoma",Font.PLAIN,17));
     text.setBounds(400,40,200,30);
     add(text);
       
       JLabel l1=new JLabel("Room Number");
       l1.setBounds(10,180,100,20);
       add(l1);
       
       JLabel l2=new JLabel("Availability ");
       l2.setBounds(210,180,100,20);
       add(l2);
       
       JLabel l3=new JLabel("Status ");
       l3.setBounds(420,180,100,20);
       add(l3);
       
       JLabel l4=new JLabel("Price ");
       l4.setBounds(630,180,100,20);
       add(l4);
       
       JLabel l5=new JLabel("BedType ");
       l5.setBounds(840,180,100,20);
       add(l5);
       
       table=new JTable();
       table.setBounds(0,200,1000,300);
       add(table);
       
       try{
           Conn conn=new Conn();
           ResultSet rs=conn.s.executeQuery("select * from room;");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       back=new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(300,500,120,30);
       back.addActionListener(this);
       add(back);
       
       submit=new JButton("Submit");
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.setBounds(500,500,120,30);
       submit.addActionListener(this);
       add(submit);
       
       setBounds(100,50,1050,600);
       setVisible(true);
   }
   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==submit){
           try{
           String query1="select * from room where bed_type='"+bedType.getSelectedItem()+"'";
           String query2="select * from room where availability='Available' AND bed_type='"+bedType.getSelectedItem()+"'";
           
           Conn conn=new Conn();
           ResultSet rs;
           if(available.isSelected()){
               rs=conn.s.executeQuery(query2);
           }else{
            rs=conn.s.executeQuery(query1);
           }
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
           }catch(Exception e){
               e.printStackTrace();
           }
       }else{
          setVisible(false);
       new Reception();
       }
   }
   
    public static void main(String args[]){
        new SearchRoom();
    }
}
