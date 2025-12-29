package EMS;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class remv_Emp extends JFrame implements ActionListener{
	
	Choice choiceEMP;
	JButton delete, back;
	
	remv_Emp(){
				
		JLabel heading = new JLabel("Employee ID: ");
		heading.setBounds(50, 90, 120, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD, 15));
		heading.setForeground(Color.white);
		add(heading);
		
		choiceEMP = new Choice();
		choiceEMP.setBounds(200,90,150,30);
		add(choiceEMP);
		
		try {
			conn c = new conn();
			ResultSet rs = c.st.executeQuery("select * from employees");
			while(rs.next()) {
				choiceEMP.add(rs.getString("empID"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel labname = new JLabel("Name: ");
		labname.setBounds(50, 140, 120, 30);
		labname.setFont(new Font("Tahoma", Font.BOLD, 15));
		labname.setForeground(Color.white);
		add(labname);
		JLabel name = new JLabel();
		name.setBounds(200, 140, 150, 30);
		name.setFont(new Font("Tahoma", Font.BOLD, 15));
		name.setForeground(Color.white);
		add(name);
		
		JLabel labphone = new JLabel("Phone No.: ");
		labphone.setBounds(50, 190, 120, 30);
		labphone.setFont(new Font("Tahoma", Font.BOLD, 15));
		labphone.setForeground(Color.white);
		add(labphone);
		JLabel phone = new JLabel();
		phone.setBounds(200, 190, 150, 30);
		phone.setFont(new Font("Tahoma", Font.BOLD, 15));
		phone.setForeground(Color.white);
		add(phone);
		
		JLabel labmail = new JLabel("Email: ");
		labmail.setBounds(50, 240, 120, 30);
		labmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		labmail.setForeground(Color.white);
		add(labmail);
		JLabel mail = new JLabel();
		mail.setBounds(200, 240, 250, 30);
		mail.setFont(new Font("Tahoma", Font.BOLD, 15));
		mail.setForeground(Color.white);
		add(mail);
		
		try {
			conn c = new conn();
			ResultSet rs = c.st.executeQuery("select * from employees where empID='"+choiceEMP.getSelectedItem()+"';");
			while(rs.next()) {
				name.setText(rs.getString("name"));
				phone.setText(rs.getString("phoneNo"));
				mail.setText(rs.getString("mail"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		choiceEMP.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					conn c = new conn();
					ResultSet rs = c.st.executeQuery("select * from employees where empID='"+choiceEMP.getSelectedItem()+"';");
					while(rs.next()) {
						name.setText(rs.getString("name"));
						phone.setText(rs.getString("phoneNo"));
						mail.setText(rs.getString("mail"));
					}
				}catch(Exception E) {
					E.printStackTrace();
				}
			}
		});
		
		delete = new JButton("DELETE");
		delete.setBackground(Color.red);
		delete.setForeground(Color.black);
		delete.setBounds(420,310,100,30);
		delete.addActionListener(this);
		add(delete);
		
		back = new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.red);
		back.setBounds(315,310,100,30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/Icons/rem.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1000, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(0, 0, 1000, 400);
		add(img);
		
		setSize(1000,400);
		setLocation(300,150);
		setLayout(null);
		setVisible(true);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==delete) {
			try {
				conn c = new conn();
				String query = "delete from employees where empID = '"+choiceEMP.getSelectedItem()+"';";
				c.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Employee details deleted successfully.");
				dispose();
				new main_class();
			}catch(Exception E) {
				E.printStackTrace();
			}
		}
		else {
			dispose();
			new main_class();
		}
	}
	
	public static void main(String []args) {
		new remv_Emp();
	}
}
