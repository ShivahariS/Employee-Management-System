package EMS;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class main_class extends JFrame implements ActionListener{
	main_class(){
		ImageIcon i1 = new ImageIcon(getClass().getResource("/Icons/home.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(0, 0, 1120, 630);
		add(img);
		
		JLabel heading = new JLabel("Employee Management System");
		heading.setBounds(255, 90, 1000, 80);
		heading.setFont(new Font("Raleway", Font.BOLD, 40));
		heading.setForeground(Color.cyan);
		img.add(heading);
		
		JButton add = new JButton("Add Employee");
		add.setBounds(215, 270, 180, 60);
		add.setForeground(Color.cyan);
		add.setBackground(Color.black);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Add_Emp();
			}
		});
		add(add);
		
		JButton view = new JButton("View Employees");
		view.setBounds(465, 270, 180, 60);
		view.setForeground(Color.cyan);
		view.setBackground(Color.black);
		view.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new view_Emp();
			}
		});
		add(view);
		
		JButton rem = new JButton("Remove Employee");
		rem.setBounds(715, 270, 180, 60);
		rem.setForeground(Color.cyan);
		rem.setBackground(Color.black);
		rem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new remv_Emp();
			}
		});
		add(rem);
		
		JButton leave = new JButton("Leave");
		leave.setBounds(465, 470, 180, 60);
		leave.setForeground(Color.black);
		leave.setBackground(Color.red);
		leave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(leave);
		
		setSize(1120,630);
		setLocation(210,120);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String args[]) {
		new main_class();
	}

}
