
package hotel.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    
    JButton newCustomer,rooms,department,allEmployee,manager,customers,seachRoom,update,roomStatus,pickup,checkout,logout;
    Reception(){
    
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     newCustomer=new JButton("New Customer Form");
     newCustomer.setBounds(10,30,200,30);
     newCustomer.setForeground(Color.WHITE);
     newCustomer.setBackground(Color.BLACK);
     newCustomer.addActionListener(this);
     add(newCustomer);
     
     rooms=new JButton("Rooms");
     rooms.setBounds(10,70,200,30);
     rooms.setForeground(Color.WHITE);
     rooms.setBackground(Color.BLACK);
     rooms.addActionListener(this);
     add(rooms);
     
     department=new JButton("Department");
     department.setBounds(10,110,200,30);
     department.setForeground(Color.WHITE);
     department.setBackground(Color.BLACK);
     department.addActionListener(this);
     add(department);
     
     allEmployee=new JButton("All Employee");
     allEmployee.setBounds(10,150,200,30);
     allEmployee.setForeground(Color.WHITE);
     allEmployee.setBackground(Color.BLACK);
     allEmployee.addActionListener(this);
     add(allEmployee);
     
     
    customers=new JButton("Customer Info");
    customers.setBounds(10,190,200,30);
    customers.setForeground(Color.WHITE);
    customers.setBackground(Color.BLACK);
    customers.addActionListener(this);
    add(customers);
     
    manager=new JButton("Manager Info");
    manager.setBounds(10,230,200,30);
    manager.setForeground(Color.WHITE);
    manager.setBackground(Color.BLACK);
    manager.addActionListener(this);
    add(manager);
     
    
    checkout=new JButton("Check Out");
    checkout.setBounds(10,270,200,30);
    checkout.setForeground(Color.WHITE);
    checkout.setBackground(Color.BLACK);
    checkout.addActionListener(this);
    add(checkout);
     
    update=new JButton("Update Status");
    update.setBounds(10,310,200,30);
    update.setForeground(Color.WHITE);
    update.setBackground(Color.BLACK);
    update.addActionListener(this);
    add(update);
    
    roomStatus=new JButton("Update Room Status");
    roomStatus.setBounds(10,350,200,30);
    roomStatus.setForeground(Color.WHITE);
    roomStatus.setBackground(Color.BLACK);
    roomStatus.addActionListener(this);
    add(roomStatus);
    
    pickup=new JButton("Pick Up Service");
    pickup.setBounds(10,390,200,30);
    pickup.setForeground(Color.WHITE);
    pickup.setBackground(Color.BLACK);
    pickup.addActionListener(this);
    add(pickup);
    
    seachRoom=new JButton("Search Room");
    seachRoom.setBounds(10,430,200,30);
    seachRoom.setForeground(Color.WHITE);
    seachRoom.setBackground(Color.BLACK);
    seachRoom.addActionListener(this);
    add(seachRoom);
    
    
    logout=new JButton("LogOut");
    logout.setBounds(10,470,200,30);
    logout.setForeground(Color.WHITE);
    logout.setBackground(Color.BLACK);
    logout.addActionListener(this);
    add(logout);
    
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.png"));
    Image i2=i1.getImage().getScaledInstance(500, 470,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(250,30,500,470);
    add(image);
    
    setBounds(250,100,800,570); 
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==department){
            setVisible(false);
            new Department();
        }
         else if(ae.getSource()==allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }
        
         else if(ae.getSource()==manager){
            setVisible(false);
            new ManagerInfo();
        }
         else if(ae.getSource()==customers){
            setVisible(false);
            new CustomerInfo();
        }
         else if(ae.getSource()==seachRoom){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource()==roomStatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource()==pickup){
            setVisible(false);
            new PickUp();
        }
           else if(ae.getSource()==checkout){
            setVisible(false);
            new CheckOut();
        }
         else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String args[]){
      new Reception(); 
     
    }
}
