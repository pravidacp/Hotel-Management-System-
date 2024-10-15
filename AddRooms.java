
package hotel.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener{
    JLabel heading,lblroomno,lblavailable,lblclean,lblprice,lbltype;
    JTextField tfroom,tfprice;
    JButton add,cancel;
    JComboBox typecombo,availablecombo,cleancombo;
    
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        heading=new JLabel("Add Romms");
        heading.setFont(new Font("Times New Roman",Font.BOLD,20));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        lblroomno=new JLabel("Room number");
        lblroomno.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);
        
        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        lblavailable=new JLabel("Available");
        lblavailable.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);
        
        String availableOptions[]={"Available","Occupied"};
        availablecombo=new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        
        lblclean=new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lblclean.setBounds(60,180,150,30);
        add(lblclean);
        
        String cleanOptions[]={"Cleaned","Dirty"};
        cleancombo=new JComboBox(cleanOptions);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
      
        lblprice=new JLabel("Price");
        lblprice.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);
        
        tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        lbltype=new JLabel("Bed Type");
        lbltype.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);
        
        String typeOptions[]={"SingleBed","DoubleBed"};
        typecombo=new JComboBox(typeOptions);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);
        
        add=new JButton("Add Room");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.png"));
        Image i2=i1.getImage().getScaledInstance(450, 350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,450,350);
        add(image);
        setBounds(200,180,940,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String roomnumber=tfroom.getText();
            String availability=(String)availablecombo.getSelectedItem();
            String status=(String)cleancombo.getSelectedItem();
            String price=tfprice.getText();
            String type=(String)typecombo.getSelectedItem();
            
            try{
                Conn conn=new Conn();
                String str="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String args[]){
        new AddRooms();
    }
}
