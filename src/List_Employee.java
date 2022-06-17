import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class List_Employee extends JFrame implements ActionListener{
	JTable t;
	JButton b1;
	String h[]={"Emp_id","Name","Gender","Address","State","City","Email_id","Phone"};
	String d[][] = new String[20][8];
	int i=0,j=0;
	
	List_Employee(){
		super("View Employee");
		JTable t = new JTable(d,h);
		setSize(1000,400);
		setLocation(300,150);
		try {
			String q = "select * from employee";
			conn c1 = new conn();
			ResultSet rs = c1.s.executeQuery(q);
			while(rs.next()) {
				d[i][j++] = rs.getString("id");
				d[i][j++] = rs.getString("name");
				d[i][j++] = rs.getString("gender");
				d[i][j++] = rs.getString("address");
				d[i][j++] = rs.getString("state");
				d[i][j++] = rs.getString("city");
				d[i][j++] = rs.getString("email");
				d[i][j++] = rs.getString("phone");
				i++;
				j=0;
			}
			t = new JTable(d,h);
		}
		catch(Exception e) {}
		b1 =  new JButton("Print");
		add(b1,"South");
		JScrollPane s1 =  new JScrollPane(t);
		add(s1);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae) {
		try {
			t.print();
		}catch(Exception e) {}
	}
	
	 public static void main(String[] args){
		new List_Employee().setVisible(true);
	}
}
