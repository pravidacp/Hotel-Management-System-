
package hotel.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    JLabel lblname,lblage,lblgender,lbljob,lblsalary,lblphone,lblemail,lbladhar;
    JTextField tfname,tfage,tfsalary,tfphone,tfemail,tfadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    AddEmployee(){
        setLayout(null);
        lblname=new JLabel("Name");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Times New Roman",Font.PLAIN,14));
        add(lblname);
        
        tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        
        lblage=new JLabel("Age");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Times New Roman",Font.PLAIN,14));
        add(lblage);
        
        tfage =new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);
        
        lblgender=new JLabel("Gender");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Times New Roman",Font.PLAIN,14));
        add(lblgender);
        
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Times New Roman",Font.PLAIN,12));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(290,130,70,30);
        rbfemale.setFont(new Font("Times New Roman",Font.PLAIN,12));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        lbljob=new JLabel("Job");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Times New Roman",Font.PLAIN,14));
        add(lbljob);
       
        String str[]={"Front Desk Clerks ","porters","Housekeeping","Kitchen Staff","Room Service","Chefs","waiter/waitress","Manager","Accountant"};
        cbjob=new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);
        
        lblsalary=new JLabel("Salary");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Times New Roman",Font.PLAIN,14));
        add(lblsalary);
        
        tfsalary =new JTextField();
        tfsalary.setBounds(200,220,150,30);
        add(tfsalary);
        
        
        lblphone=new JLabel("Phone");
        lblphone.setBounds(60,270,120,30);
        lblphone.setFont(new Font("Times New Roman",Font.PLAIN,14));
        add(lblphone);
        
        tfphone =new JTextField();
        tfphone .setBounds(200,270,150,30);
        add(tfphone );
        
        lblemail=new JLabel("Email");
        lblemail.setBounds(60,320,120,30);
        lblemail.setFont(new Font("Times New Roman",Font.PLAIN,14));
        add(lblemail);

        tfemail =new JTextField();
        tfemail .setBounds(200,320,150,30);
        add(tfemail );
        
        lbladhar=new JLabel("Aadhar");
        lbladhar.setBounds(60,360,120,30);
        lbladhar.setFont(new Font("Times New Roman",Font.PLAIN,14));
        add(lbladhar);

        tfadhar =new JTextField();
        tfadhar .setBounds(200,360,150,30);
        add(tfadhar );
        
        submit=new JButton("submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,400,150,30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.png"));
        Image i2=i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(420,40,450,430);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(200,180,850,540);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String adhar=tfadhar.getText();
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name should not be empty");
        }
        else if(age.equals("")){
            JOptionPane.showMessageDialog(null,"Age should not be empty");
        }
        else if(salary.equals("")){
            JOptionPane.showMessageDialog(null,"Salary should not be empty");
        }
        else if(phone.equals("")){
            JOptionPane.showMessageDialog(null,"Phone should not be empty");
        }
        else if(email.equals("")){
            JOptionPane.showMessageDialog(null,"Email should not be empty");
        }
        else if(adhar.equals("")){
            JOptionPane.showMessageDialog(null,"Aadhar should not be empty");
        }
       String gender=null;
       if(rbmale.isSelected()){
           gender="Male";
       }
       else if(rbfemale.isSelected()){
           gender="Female";
       }
       String job=(String)cbjob.getSelectedItem();
       try{
           Conn conn=new Conn();
           
           String query="insert into Employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+adhar+"')";
           conn.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null,"Employee Added Successfully");
           setVisible(false);
       }catch(Exception e){
           e.printStackTrace();
       }
       
    }
    
    public static void main(String args[]){
        new AddEmployee();
    }
}
