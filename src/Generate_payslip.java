import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Generate_payslip extends JFrame implements ActionListener{
    JButton b1;
    JLabel l1,l2,l3,l4,l5,l6;
    JTextArea ta;
    Choice ch;
    JPanel p1;
	Font f;
    Generate_payslip()
    {
        super("Generate Payslip");
        setSize(500,500);
        setLocation(100,100);
 	    setResizable(false);
 		
 		f = new Font("arial",Font.BOLD,16);
 		
 		l2 = new JLabel("id");	
 		
 		l2.setFont(f);
        ch = new Choice();
		
		try {
			conn obj = new conn();
			String q = "Select * from employee";
			ResultSet rs = obj.s.executeQuery(q);
			while(rs.next()) {
				ch.add(rs.getString("id"));
			}
		}catch(Exception ex) 
		{
		  ex.printStackTrace();	
		} 
		b1 = new JButton("Print");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setFont(f);
		
		ta=new JTextArea();
		JScrollPane sp=new JScrollPane(ta);
		ta.setEditable(false);
		ta.setFont(f);
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(1,3,10,10));
		p1.add(l2);
		p1.add(ch);
		p1.add(b1);
        setLayout(new BorderLayout());
        add(sp,"Center");
        add(p1,"South");
              
     }
    
     public void actionPerformed(ActionEvent e)
     {
     if(e.getSource()==b1)
     {
    	 ta.setText("--------------Pay Slip--------------");
    	 try 
    	 {
    		conn obj1 = new conn();
    		int id = Integer.parseInt(ch.getSelectedItem());	
 			String q1="Select * from employee where id ='"+id+"'";
 			ResultSet rs1 = obj1.s.executeQuery(q1);
			while(rs1.next()) 
			{
				ta.append("\n\nEmployee id : "+Integer.parseInt(rs1.getString("id")));
				ta.append("\n\nEmployee name : "+rs1.getString("name"));
				ta.append("\n---------------------------------------\n\n");
			}
			String q2="Select * from salary where id='"+id+"'";
			ResultSet rs2 = obj1.s.executeQuery(q2);
			
			while(rs2.next()) 
			{
				ta.append("\n\nHRA : "+Float.parseFloat(rs2.getString("hra")));
				ta.append("\n\nDA : "+Float.parseFloat(rs2.getString("da")));
				ta.append("\n\nMED : "+Float.parseFloat(rs2.getString("med")));
				ta.append("\n\nPF : "+Float.parseFloat(rs2.getString("pf")));
				ta.append("\n\nbasic_salary : "+Float.parseFloat(rs2.getString("basic_salary")));
				ta.append("\n---------------------------------------\n\n");
				float gross_salary=Float.parseFloat(rs2.getString("hra"))+Float.parseFloat(rs2.getString("da"))+Float.parseFloat(rs2.getString("med"))+Float.parseFloat(rs2.getString("pf"))+Float.parseFloat(rs2.getString("basic_salary"));
				double tax=(gross_salary*2.1)/100;
				ta.append("\n Gross salary : "+gross_salary);
				ta.append("\n Total : "+gross_salary);
				ta.append("\nTax 2.1% of salary : "+tax);
			}
 		}
    	catch(Exception exx) 
    	{
 			exx.printStackTrace();
 		}
     
     }
      
}
     public static void main(String args[]){
         new Generate_payslip().setVisible(true);
     }
}
