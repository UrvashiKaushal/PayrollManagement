import java.sql.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;


public class Update_employee extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	Choice ch1,ch2;
	JButton b1,b2;
	JPanel p1,p2;
	Font f;
	
	
	
	Update_employee()
	{
		
		super("Update Employee");
		setSize(740,447);
		setLocation(200,70);
		setResizable(false);
		
		f = new Font("Arial",Font.BOLD,14);
		
		l1 = new JLabel("Name");
		l2 = new JLabel("Gender");
		l3 = new JLabel("Address");
	    l4 = new JLabel("State");
		l5 = new JLabel("City");
	    l6 = new JLabel("Email");
	    l7 = new JLabel("Phone");
	    l9 = new JLabel("id");
	    ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpeg"));
		Image image1 = img1.getImage().getScaledInstance(140,400,Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(image1);
		l8=new JLabel(img2);
		
	    
	    l1.setFont(f);
	    l2.setFont(f);
	    l3.setFont(f);
	    l4.setFont(f);
	    l5.setFont(f);
	    l6.setFont(f);
	    l7.setFont(f);
	    l9.setFont(f);
	    

		t1 = new JTextField();
		t2 = new JTextField();
		t3 = new JTextField();
		t4 = new JTextField();
		t5 = new JTextField();
		t6 = new JTextField();
		
		t1.setFont(f);
		t2.setFont(f);
		t3.setFont(f);
		t4.setFont(f);
		t5.setFont(f);
		t6.setFont(f);
		
	    
	    
		ch1 = new Choice();
		ch1.add("Male");
		ch1.add("Female");
		ch1.setFont(f);
		
		ch2 = new Choice();
		
		try {
			conn obj = new conn();
			String q = "select id from employee";
			ResultSet rs = obj.s.executeQuery(q);
			while(rs.next()) {
				ch2.add(rs.getString("id"));
			}
		}catch(Exception ex) 
		{
		  ex.printStackTrace();	
		}
		ch2.setFont(f);
		
		b1 = new JButton("Submit");
		b2 = new JButton("Close");
		b1.setFont(f);
		b2.setFont(f);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(9,2,10,10));
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(ch1);
		p1.add(l3);
		p1.add(t2);
		p1.add(l4);
		p1.add(t3);
		p1.add(l5);
		p1.add(t4);
		p1.add(l6);
		p1.add(t5);
		p1.add(l7);
		p1.add(t6);
		p1.add(l9);
		p1.add(ch2);
		p1.add(b1);
		p1.add(b2);
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(1,1,10,10));
		p2.add(l8);
		
		setLayout(new BorderLayout(30,30));
		add(p1,"Center");
		add(p2,"West");
		
		try {
			int id = Integer.parseInt(ch2.getSelectedItem()) ;
			conn obj1 = new conn();
			String q1  = "select * from employee where id = '"+id+"'";
			ResultSet rs1 = obj1.s.executeQuery(q1);
			//while(rs1.next()) {
			//	t1.setText(rs1.getString("name"));
			//	rs1.getString("gender");
			//	t2.setText(rs1.getString("address"));
			//	t3.setText(rs1.getString("state"));
			//	t4.setText(rs1.getString("city"));
			//	t5.setText(rs1.getString("email"));
			//	t6.setText(rs1.getString("phone"));
			//}
		}
		catch(Exception exx)
		{
			exx.printStackTrace();
		}	
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	  if(e.getSource()==b1) {
		    int id = Integer.parseInt(ch2.getSelectedItem());
		    String name = t1.getText();
			String gender = ch1.getSelectedItem();
			String address = t2.getText();
			String state = t3.getText();
			String city = t4.getText();
			String email = t5.getText();
			String phone = t6.getText();
	
			
			try {
				conn obj = new conn();
				String q = "update employee set name='"+name+"',gender='"+gender+"',address='"+address+"',state='"+state+"',city='"+city+"',email='"+email+"',phone='"+phone+"' where id='"+id+"'";
				obj.s.executeUpdate(q);
				JOptionPane.showMessageDialog(null,"Record Updated");
				this.setVisible(false);
				this.setVisible(true);
			}
			catch(Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	    if(e.getSource()==b2)
	    {
	   	    JOptionPane.showMessageDialog(null,"Sure");
	   	    setVisible(false);	
	    }
		  
	}
	  
	public static void main(String[] args) {
		new Update_employee().setVisible(true);
	}
	  
}



