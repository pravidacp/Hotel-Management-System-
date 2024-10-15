
package hotel.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class DeleteEmployee extends JFrame implements ActionListener {
    JTable table;
    JButton delete,back;
    Choice empemail;
    DeleteEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
     JLabel text=new JLabel("Deleting An Employee");
     text.setFont(new Font("Tahoma",Font.PLAIN,17));
     text.setBounds(400,40,200,30);
     add(text);  
       
     JLabel lblemail=new JLabel(" Email Id ");
     lblemail.setBounds(50,100,100,120);
     add(lblemail);
     
    empemail=new Choice();
    empemail.setBounds(150,150,200,20);
    try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select * from Employee ");
        while(rs.next()){
            empemail.add(rs.getString("email"));
        }
      
    }catch(Exception e){
        e.printStackTrace();
    }
     add(empemail);
       
     JLabel l1=new JLabel("Name");
       l1.setBounds(50,180,100,20);
       add(l1);
       
       JLabel l2=new JLabel("age ");
       l2.setBounds(160,180,100,20);
       add(l2);
       
       JLabel l3=new JLabel("gender ");
       l3.setBounds(280,180,100,20);
       add(l3);
       
       JLabel l4=new JLabel("job ");
       l4.setBounds(400,180,100,20);
       add(l4);
       
       JLabel l5=new JLabel("salary ");
       l5.setBounds(510,180,100,20);
       add(l5);
       
       JLabel l6=new JLabel("phone no ");
       l6.setBounds(640,180,100,20);
       add(l6);
       
       JLabel l7=new JLabel("Email ");
       l7.setBounds(760,180,100,20);
       add(l7);
       
       JLabel l8=new JLabel("Aadhar ");
      l8.setBounds(880,180,100,20);
       add(l8);
       
       table=new JTable();
       table.setBounds(0,200,1000,300);
       add(table);
       
       try{
           Conn conn=new Conn();
           ResultSet rs=conn.s.executeQuery("select * from Employee;");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       
       delete=new JButton("Delete");
       delete.setBackground(Color.BLACK);
       delete.setForeground(Color.WHITE);
       delete.setBounds(500,500,120,30);
       delete.addActionListener(this);
       add(delete);
     
       back=new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(300,500,120,30);
       back.addActionListener(this);
       add(back); 
       
       
        setBounds(100,50,1100,600);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
           try{
           String query="delete from employee where email='"+empemail.getSelectedItem()+"'"; 
           Conn conn=new Conn();
           conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
          
          
           
           }catch(Exception e){
               e.printStackTrace();
           }
       }else{
            setVisible(false);
            new Dashboard();
        }
    }
    public static void main(String args[]){
        new DeleteEmployee();
    }
}
