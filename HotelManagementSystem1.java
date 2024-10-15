
package hotel.management.system1;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HotelManagementSystem1 extends JFrame implements ActionListener{
 HotelManagementSystem1(){
    setSize(1366,565);
    setLocation(100,100);
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.png"));
    JLabel image= new JLabel(i1);
    image.setBounds(0,0,1366,565);
    add(image);
    JLabel text = new JLabel("Hotel Management System");
    text.setBounds(20, 430, 1000, 90);
    text.setForeground(Color.white);
    text.setFont(new Font("Times New Roman",Font.PLAIN,40));
    image.add(text);
    
    JButton next=new JButton("Next");
    next.setBounds(1100,500,150,50);
    image.add(next);
    next.setBackground(Color.cyan);
    next.setForeground(Color.black);
    next.addActionListener(this);
    
    setVisible(true);
    while(true){
        text.setVisible(false);
        try{
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
        text.setVisible(true);
         try{
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
 }
 public void actionPerformed(ActionEvent ae){
     setVisible(false);
     new Login();
 }
    public static void main(String[] args) {
        new HotelManagementSystem1();
    }
    
}
