import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    login(){
         super("Login Page");
         setLayout(new BorderLayout());
         t2 = new JPasswordField(10);
         t1 = new JTextField(10);
         JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon\\defaultpic.png")));
         
         b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
         b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\cancel.png")));
         b1.addActionListener(this);
         b2.addActionListener(this);
         
         JPanel p2,p4;
         p2 = new JPanel();
         p4 = new JPanel();
         
         add(l,BorderLayout.WEST);
         
         p2.add(new JLabel("User Name "));
         p2.add(t1);
         p2.add(new JLabel("Password "));
         p2.add(t2);
         add(p2,BorderLayout.CENTER);
       
         
         p4.add(b1);
         p4.add(b2);
         
         add(p4,BorderLayout.SOUTH);
         
         setVisible(true);
         setSize(600,350);
         setLocation(350,350);
         setVisible(true);
         
         
     }
    
     public void actionPerformed(ActionEvent ae){
     try
     {
      conn c1 = new conn();
      String u = t1.getText();
      String v = t1.getText();
      String q = "Select * from login where username = '"+u+"' and password = '"+v+"'";
      
      ResultSet rs = c1.s.executeQuery(q);
      if(rs.next()){
          new project().setVisible(true);
          setVisible(false);
       }else{
          JOptionPane.showMessageDialog(null,"Invalid Login");
          setVisible(false);
      }
      }catch(Exception e){
              e.printStackTrace();
              }
      
}
     public static void main(String args[]){
         new login();
     }
}
