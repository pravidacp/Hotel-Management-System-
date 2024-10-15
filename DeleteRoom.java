
package hotel.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class DeleteRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,delete;
    Choice roomch;
    DeleteRoom(){
         getContentPane().setBackground(Color.WHITE);
 setLayout(null);
 JLabel text=new JLabel("Deleting A Room");
     text.setFont(new Font("Tahoma",Font.BOLD,17));
     text.setBounds(400,40,200,30);
     add(text);  
       
     JLabel lblemail=new JLabel(" Room No ");
     lblemail.setBounds(50,100,100,120);
     add(lblemail);
     
    roomch=new Choice();
    roomch.setBounds(150,150,200,20);
    try{
        Conn c=new Conn();
        ResultSet rs=c.s.executeQuery("select * from room ");
        while(rs.next()){
            roomch.add(rs.getString("roomno"));
        }
      
    }catch(Exception e){
        e.printStackTrace();
    }
     add(roomch);
       
     JLabel l1=new JLabel("Room No");
       l1.setBounds(50,180,100,20);
       add(l1);
       
       JLabel l2=new JLabel("availabilty ");
       l2.setBounds(180,180,100,20);
       add(l2);
       
       JLabel l3=new JLabel("cleaning_status ");
       l3.setBounds(300,180,100,20);
       add(l3);
       
       JLabel l4=new JLabel("price ");
       l4.setBounds(440,180,100,20);
       add(l4);
       
       JLabel l5=new JLabel("bed_type ");
       l5.setBounds(580,180,100,20);
       add(l5);
       
       
       table=new JTable();
       table.setBounds(0,200,700,300);
       add(table);
       
       try{
           Conn conn=new Conn();
           ResultSet rs=conn.s.executeQuery("select * from room;");
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
       
       setBounds(100,50,900,600);
        setVisible(true);
        
}
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
           try{
           String query="delete from room where roomno='"+roomch.getSelectedItem()+"'"; 
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
        new DeleteRoom();
        
    }
}
