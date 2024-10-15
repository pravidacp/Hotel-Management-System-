
package hotel.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class PickUp extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    
    Choice typeofcar;
   PickUp(){
       
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
     JLabel text=new JLabel("PickUp Service");
     text.setFont(new Font("Tahoma",Font.PLAIN,17));
     text.setBounds(400,40,200,30);
     add(text);  
       
     JLabel lblbed=new JLabel(" Type of car");
     lblbed.setBounds(50,100,100,120);
     add(lblbed);
     
    typeofcar=new Choice();
    typeofcar.setBounds(150,150,200,20);
    try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select * from driver");
        while(rs.next()){
            typeofcar.add(rs.getString("brand"));
        }
      
    }catch(Exception e){
        e.printStackTrace();
    }
     add(typeofcar);
    
       JLabel l1=new JLabel("Name");
       l1.setBounds(100,180,100,20);
       add(l1);
       
       JLabel l2=new JLabel("age ");
       l2.setBounds(200,180,100,20);
       add(l2);
       
       JLabel l3=new JLabel("gender ");
       l3.setBounds(330,180,100,20);
       add(l3);
       
       JLabel l4=new JLabel("company ");
       l4.setBounds(460,180,100,20);
       add(l4);
       
       JLabel l5=new JLabel("brand ");
       l5.setBounds(630,180,100,20);
       add(l5);
       
       JLabel l6=new JLabel("availability ");
       l6.setBounds(740,180,100,20);
       add(l6);
       
       JLabel l7=new JLabel("Location ");
       l7.setBounds(890,180,100,20);
       add(l7);
       
       table=new JTable();
       table.setBounds(0,200,1000,300);
       add(table);
       
       try{
           Conn conn=new Conn();
           ResultSet rs=conn.s.executeQuery("select * from driver;");
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
           String query="select * from driver where brand='"+typeofcar.getSelectedItem()+"'";
           
           Conn conn=new Conn();
           ResultSet rs;
            rs=conn.s.executeQuery(query);
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
        new PickUp();
    }
}

