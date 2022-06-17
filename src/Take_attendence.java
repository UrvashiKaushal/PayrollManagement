import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Take_attendence extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4;
    JButton b1;
    Choice ch1,ch2,ch3;
	Font f;
	JPanel p1;
	
    Take_attendence()
    {
        super("Take Attendence");
        setSize(740,370);
        setLocation(200,70);
 	    setResizable(false);
 		
 		f = new Font("Arial",Font.BOLD,14);
 		
 		l1 = new JLabel("First half");
 		l2 = new JLabel("Second half");
 		l3 = new JLabel("Employee id");
 		
 		l1.setFont(f);
 	    l2.setFont(f);
 		l3.setFont(f);
 		
 		ch1 =new Choice();
		ch1.add("present");
		ch1.add("absent");
		
		ch1.setFont(f);
		
		ch2 = new Choice();
		ch2.add("present");
		ch2.add("absent");
		
		ch2.setFont(f);
 		
        ch3 = new Choice();
		
		try {
			conn obj = new conn();
			String q = "select id from employee";
			ResultSet rs = obj.s.executeQuery(q);
			while(rs.next()) {
				ch3.add(rs.getString("id"));
			}
		}catch(Exception e) 
		{
		  e.printStackTrace();	
		}
		ch3.setFont(f);
         
		b1 = new JButton("Submit");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setFont(f);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(3,2,10,10));
		p1.add(l3);
		p1.add(ch3);
		p1.add(l1);
		p1.add(ch1);
		p1.add(l2);
		p1.add(ch2);
		
        setLayout(new BorderLayout(30,30));
        add(p1,"Center");
        add(b1,"South");
              
     }
    
     public void actionPerformed(ActionEvent e){
     if(e.getSource()==b1)
     {
    	 try 
    	 {
    		int id = Integer.parseInt(ch3.getSelectedItem());
    		String f_half=ch1.getSelectedItem();
    		String s_half=ch2.getSelectedItem();
    		String date_tm=new java.util.Date().toString();
    		
 			conn c1 = new conn();
 			String qry="insert into attendence values('"+id+"','"+date_tm+"','"+f_half+"','"+s_half+"')";
 			c1.s.executeUpdate(qry);
 			JOptionPane.showMessageDialog(null,"Record Insert");
 			this.setVisible(false);
 		}
        catch(Exception ee) 
    	{
 			ee.printStackTrace();
 		}
     
     }
      
}
     public static void main(String args[]){
         new Take_attendence().setVisible(true);
     }
}
