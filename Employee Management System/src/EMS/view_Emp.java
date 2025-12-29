package EMS;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class view_Emp extends JFrame implements ActionListener {

	Choice choiceEMP;
	JTable table;
	
	conn c = null;
	
	JButton searchbtn, printbtn, updatebtn, backbtn;
	
	view_Emp(){
	
		JLabel search = new JLabel("Search by Employee ID: ");
		search.setBounds(20, 20, 150, 30);
		search.setForeground(Color.cyan);
		add(search);
		choiceEMP = new Choice();
		choiceEMP.setBounds(180, 20, 150, 20);
		add(choiceEMP);
		try {
			c = new conn();
			ResultSet rs = c.st.executeQuery("select * from employees");
			while(rs.next()) {
				choiceEMP.add(rs.getString("empID"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(c!=null)c.close();
		}
		
		table = new JTable();
		try {
			c = new conn();
			ResultSet rs = c.st.executeQuery("select * from employees");
			table.setModel(TableUtils.buildTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(c!=null)c.close();
		}
		
		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(0, 100, 900, 600);
		add(jp);
		
		searchbtn = new JButton("Search");
		searchbtn.setBounds(20 , 65, 80, 20);
		searchbtn.setBackground(Color.black);
		searchbtn.setForeground(Color.cyan);
		searchbtn.addActionListener(this);
		add(searchbtn);
		
		printbtn = new JButton("Print");
		printbtn.setBounds(120 , 65, 80, 20);
		printbtn.setBackground(Color.black);
		printbtn.setForeground(Color.cyan);
		printbtn.addActionListener(this);
		add(printbtn);
		
		updatebtn = new JButton("Update");
		updatebtn.setBounds(220 , 65, 80, 20);
		updatebtn.setBackground(Color.black);
		updatebtn.setForeground(Color.cyan);
		updatebtn.addActionListener(this);
		add(updatebtn);
		
		backbtn = new JButton("Back");
		backbtn.setBounds(320 , 65, 80, 20);
		backbtn.setBackground(Color.black);
		backbtn.setForeground(Color.cyan);
		backbtn.addActionListener(this);
		add(backbtn);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/Icons/view head.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel bg = new JLabel(i3);
		bg.setBounds(0, 0, 900, 100);
		add(bg);
		
		setSize(900,700);
		setLocation(300,100);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==searchbtn) {
			String query = "select * from employees where empID = '"+choiceEMP.getSelectedItem()+"';";
			try {
				c = new conn();
				ResultSet rs = c.st.executeQuery(query);
				table.setModel(TableUtils.buildTableModel(rs));
			}catch(Exception E) {
				E.printStackTrace();
			}finally {
				if(c!=null)c.close();
			}
		}
		else if(e.getSource()==printbtn) {
			try {
				table.print();
			}catch(Exception E) {
				E.printStackTrace();
			}
		}
		else if(e.getSource()==updatebtn) {
			dispose();
			new update_Emp(choiceEMP.getSelectedItem());
			
		}
		else {
			dispose();
			new main_class();
		}
		
	}
	
	public static void main(String []args) {
		new view_Emp();
	}

}
