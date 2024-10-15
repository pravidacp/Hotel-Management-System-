
package hotel.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
       setBounds(0,0,1400,800);
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.png"));
       Image i2=i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,1400,800);
       add(image);
       
       JLabel text=new JLabel("THE TAJ GROUP WELCOMES YOU");
       text.setBounds(300,80,800,50);
       image.add(text);
       text.setFont(new Font("Tahoma",Font.PLAIN,40));
       text.setForeground(Color.WHITE);
       
       JMenuBar mb=new JMenuBar();
       mb.setBounds(0, 0, 1400, 30);
       image.add(mb);
       
       JMenu hotel=new JMenu("HOTEL MANAGEMENT");
       hotel.setForeground(Color.red);
       mb.add(hotel);
       
       JMenuItem reception=new JMenuItem("RECEPTION");
       reception.addActionListener(this);
       hotel.add(reception);
       
       JMenu admin=new JMenu("ADMIN");
       admin.setForeground(Color.blue);
       mb.add(admin);
       
       JMenuItem addEmp=new JMenuItem("ADD EMPLOYEE");
       addEmp.addActionListener(this);
       admin.add(addEmp);
       
       JMenuItem deleteEmp=new JMenuItem("DELETE EMPLOYEE");
       deleteEmp.addActionListener(this);
       admin.add(deleteEmp);
       
       JMenuItem addrooms=new JMenuItem("ADD ROOMS");
       addrooms.addActionListener(this);
       admin.add(addrooms);
       
       JMenuItem deleteroom=new JMenuItem("DELETE ROOM");
       deleteroom.addActionListener(this);
       admin.add(deleteroom);
               
       
       JMenuItem adddriver=new JMenuItem("ADD DRIVER");
       adddriver.addActionListener(this);
       admin.add(adddriver);
       
       
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("ADD DRIVER")){
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("DELETE EMPLOYEE")){
            new DeleteEmployee();
        }
        else if(ae.getActionCommand().equals("DELETE ROOM")){
            new DeleteRoom();
        }
        else if(ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    public static void main(String args[]){
        new Dashboard();
    }
}
