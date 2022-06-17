import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Salary extends JFrame implements ActionListener
{
	
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField t1,t2,t3,t4,t5,t6;
	Choice ch1;
	JButton b1,b2;
	Font f;
	JPanel p1,p2;
	Salary()
	{
	super("Salary");
	setLocation(100,100);
	setSize(840,400);
	setResizable(false);
	
	f = new Font("Arial",Font.BOLD,14);
	
	l1 = new JLabel("Select Id");
	l2 = new JLabel("Hra");
	l3 = new JLabel("Da");
    l4 = new JLabel("Med");
	l5 = new JLabel("Pf");
    l6 = new JLabel("basic_salary");
    
    l1.setFont(f);
    l2.setFont(f);
    l3.setFont(f);
    l4.setFont(f);
    l5.setFont(f);
    l6.setFont(f);
    
	ch1 = new Choice();
	try {
		conn obj = new conn();
		String q = "select id from employee";
		ResultSet rs = obj.s.executeQuery(q);
		while(rs.next()) {
			ch1.add(rs.getString("id"));
		}
	}
	catch(Exception ex) 
	{
	  ex.printStackTrace();	
	}
	ch1.setFont(f);
	
	t1 = new JTextField();
	t2 = new JTextField();
	t3 = new JTextField();
	t4 = new JTextField();
	t5 = new JTextField();
	
	t1.setFont(f);
	t2.setFont(f);
	t3.setFont(f);
	t4.setFont(f);
	t5.setFont(f);
	
	ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/IO Server_128.png"));
	Image image = img.getImage().getScaledInstance(120,320,Image.SCALE_DEFAULT);
	ImageIcon img2 = new ImageIcon(image);
	l7=new JLabel(img2);
	
	
   
	
	b1 = new JButton("Submit");
	b2 = new JButton("Close");
	b1.setFont(f);
	b2.setFont(f);
	b1.setBackground(Color.BLACK);
	b1.setForeground(Color.BLUE);
	b2.setBackground(Color.BLACK);
	b2.setForeground(Color.BLUE);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	
	p1=new JPanel();
	p1.setLayout(new GridLayout(7,2,10,10));
	p1.add(l1);
	p1.add(ch1);
	p1.add(l2);
	p1.add(t1);
	p1.add(l3);
	p1.add(t2);
	p1.add(l4);
	p1.add(t3);
	p1.add(l5);
	p1.add(t4);
	p1.add(l6);
	p1.add(t5);
	p1.add(b1);
	p1.add(b2);
	
	p2=new JPanel();
	p2.setLayout(new GridLayout(1,1,10,10));
	p2.add(l7);
	
	setLayout(new BorderLayout(30,30));
	
	add(p1,"Center");
	add(p2,"West");

}

public void actionPerformed(ActionEvent e) 
{
	
  if(e.getSource()==b1)
  {  
    int id = Integer.parseInt(ch1.getSelectedItem());
    float hra = Float.parseFloat(t1.getText());
    float da = Float.parseFloat(t2.getText());
    float med = Float.parseFloat(t3.getText());
    float pf = Float.parseFloat(t4.getText());
    float basic_salary = Float.parseFloat(t5.getText());
   	try {
		conn obj1 = new conn();
		String q1 = "insert into salary values('"+id+"','"+hra+"','"+da+"','"+med+"','"+pf+"','"+basic_salary+"')";
		obj1.s.executeUpdate(q1);
		JOptionPane.showMessageDialog(null,"Salary Inserted Successfully");
		this.setVisible(true);
		this.setVisible(true);
	}
   	catch(Exception exx) {
		exx.printStackTrace();
	}
  }

  if(e.getSource()==b2)
  {
    JOptionPane.showMessageDialog(null,"Sure");
    setVisible(true);
  }
}
  
public static void main(String[] args) {
	new Salary().setVisible(true);
}
  
}


