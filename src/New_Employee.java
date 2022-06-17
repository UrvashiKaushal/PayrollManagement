import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class New_Employee extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JButton b1,b2;
	Choice c1;
	
	New_Employee(){
		super("New Employee");
		setSize(600,650);
		setLocation(600,100);
		getContentPane().setBackground(Color.WHITE);
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		p1.setLayout(new GridLayout(9,2,10,40));
		
		l1 = new JLabel("Name");
		t1 = new JTextField(15);
		p1.add(l1);
		p1.add(t1);
		
		c1 = new Choice();
		c1.add("Male");
		c1.add("Female");
		c1.add("Other");
		l2 = new JLabel("Gender");
		p1.add(l2);
		p1.add(c1);
		
		l3 = new JLabel("Address");
		t3 = new JTextField(15);
		p1.add(l3);
		p1.add(t3);
		
		l4 = new JLabel("State");
		t4 = new JTextField(15);
		p1.add(l4);
		p1.add(t4);
		
		l5 = new JLabel("City");
		t5 = new JTextField(15);
		p1.add(l5);
		p1.add(t5);
		
		l6 = new JLabel("Email");
		t6 = new JTextField(15);
		p1.add(l6);
		p1.add(t6);
		
		l7 = new JLabel("Phone");
		t7 = new JTextField(15);
		p1.add(l7);
		p1.add(t7);
		
		l8 = new JLabel("Emp_Id");
		t8 = new JTextField(15);
		p1.add(l8);
		p1.add(t8);
		
		
		b1 = new JButton("Submit");
		b2 = new JButton("Cancel");
		p1.add(b1);
		p1.add(b2);
		
		setLayout(new BorderLayout());
		add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icons/new_employee.png"))),"West");
		add(p1,"Center");
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1) {
		String name = t1.getText();
		String gender = c1.getSelectedItem();
		String address = t3.getText();
		String state = t4.getText();
		String city = t5.getText();
		String email = t6.getText();
		String phone = t7.getText();
		int id  = Integer.parseInt(t8.getText());
		
		
		String q = "insert into employee values('"+id+"','"+name+"','"+gender+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phone+"')";
		
		try {
			conn obj = new conn();
			obj.s.executeUpdate(q);
			JOptionPane.showMessageDialog(null,"Employee Created");
			this.setVisible(false);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		if(e.getSource()==b2)
		{
			JOptionPane.showMessageDialog(null,"Sure");
			setVisible(false);
		}
	}
}
	public static void main(String args[]) {
		new New_Employee().setVisible(true);
		
	}
}
