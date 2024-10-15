
package hotel.management.system1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    JLabel heading,lblname,lblage,lblgender,lblmodel,lblcomp,lblavailable,lbllocation;
    JTextField tfname,tfcompany,tfage,tfmodel,tflocation;
    JButton add,cancel;
    JComboBox availablecombo,gendercombo;
   AddDriver(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        heading=new JLabel("Add Driver");
        heading.setFont(new Font("Times New Roman",Font.BOLD,20));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        lblname=new JLabel("Name");
        lblname.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lblname.setBounds(60,80,120,30);
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);
        
        lblage=new JLabel("Age");
        lblage.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lblage.setBounds(60,130,120,30);
        add(lblage);
        
        tfage=new JTextField();
        tfage.setBounds(200,130,150,30);
        add(tfage);
        
        
        lblgender=new JLabel("Gender");
        lblgender.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lblgender.setBounds(60,180,150,30);
        add(lblgender);
   
        
        String genderOptions[]={"Male","Female"};
        gendercombo=new JComboBox(genderOptions);
        gendercombo.setBounds(200,180,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
      
        lblcomp=new JLabel("Car Company");
        lblcomp.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lblcomp.setBounds(60,230,120,30);
        add(lblcomp);
        
        tfcompany=new JTextField();
        tfcompany.setBounds(200,230,150,30);
        add(tfcompany);
        
        lblmodel=new JLabel("Car Model");
        lblmodel.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lblmodel.setBounds(60,280,120,30);
        add(lblmodel);
        
        tfmodel=new JTextField();
        tfmodel.setBounds(200,280,150,30);
        add(tfmodel);
        
        lblavailable=new JLabel("Available");
        lblavailable.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lblavailable.setBounds(60,340,120,30);
        add(lblavailable);
        
        String driverOptions[]={"Available","Busy"};
        availablecombo=new JComboBox(driverOptions);
        availablecombo.setBounds(200,340,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        lbllocation=new JLabel("Location");
        lbllocation.setFont(new Font("Times New Roman",Font.PLAIN,16));
        lbllocation.setBounds(60,380,120,30);
        add(lbllocation);
        
        
        tflocation=new JTextField();
        tflocation.setBounds(200,380,150,30);
        add(tflocation);
        
        
        add=new JButton("Add Driver");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(60,430,130,30);
       add.addActionListener(this);
        add(add);
        
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,430,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.png"));
        Image i2=i1.getImage().getScaledInstance(450, 350,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,450,350);
        add(image);
        setBounds(300,180,980,570);
        setVisible(true);
   }
   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String) gendercombo.getSelectedItem();
            String company=tfcompany.getText();
            String brand=tfmodel.getText();
            String available=(String) availablecombo.getSelectedItem();
            String location=tflocation.getText();
            
            try{
                Conn conn=new Conn();
                String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
 public static void main(String args[]){
  new AddDriver();
}
}
