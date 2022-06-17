import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
;
public class List_attendence extends JFrame implements ActionListener
{
	JTable t;
	JButton b1;
	String x[]={"Emp_id","f_half","s_half","Date_tm"};
	String y[][] = new String[20][4];
	int i=0,j=0;
	Font f;
	List_attendence(){
		super("List Attendnce");
		setSize(900,400);
		setLocation(100,100);
		setResizable(false);
		try {
			conn c1 = new conn();
			String q = "Select * from attendence";
			ResultSet rs = c1.s.executeQuery(q);
			while(rs.next()) {
				y[i][j++] = rs.getString("id");
				y[i][j++] = rs.getString("f_half");
				y[i][j++] = rs.getString("s_half");
				y[i][j++] = rs.getString("date_tm");
				i++;
				j=0;
			}
			t = new JTable(y,x);
			t.setFont(f);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		JScrollPane js =  new JScrollPane(t);
		add(js);
		
		b1 = new JButton("Print");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(f);
		add(b1,"South");
	}
	public void actionPerformed(ActionEvent ae) 
	{
	 if(ae.getSource()==b1)
	 {
		try 
		{
			t.print();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	  }
	}
	
	 public static void main(String[] args){
		new List_attendence().setVisible(true);
	}
}
