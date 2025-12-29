package EMS;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;


public class update_Emp extends JFrame implements ActionListener {
	
	JTextField teducation, tsname, taddress, tphone, tmail, tsalary, tdesg, taadhar;
	JLabel tempid;
	JButton upd, back;
	String number;
	
	conn c = null;
	
	update_Emp(String number){
		this.number = number;
				
		JLabel heading = new JLabel("Update Employee Detail: ");
		heading.setBounds(60, 40, 400, 40);
		heading.setFont(new Font("Serif", Font.BOLD, 30));
		heading.setForeground(Color.cyan);
		add(heading);
		
		JLabel name = new JLabel("Name: ");
		name.setBounds(60, 110, 100, 30);
		name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		name.setForeground(Color.white);
		add(name);
		JLabel tname = new JLabel();
		tname.setBounds(200, 110, 200, 30);
		tname.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		tname.setBackground(Color.DARK_GRAY);
		tname.setForeground(Color.white);
		add(tname);
		
		JLabel sname = new JLabel("Surname: ");
		sname.setBounds(450, 110, 100, 30);
		sname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		sname.setForeground(Color.white);
		add(sname);
		tsname = new JTextField();
		tsname.setBounds(590, 110, 200, 30);
		tsname.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		tsname.setBackground(Color.DARK_GRAY);
		tsname.setForeground(Color.white);
		add(tsname);
		
		JLabel dob = new JLabel("DoB: ");
		dob.setBounds(60, 180, 100, 30);
		dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		dob.setForeground(Color.white);
		add(dob);
		JLabel tdob = new JLabel();
		tdob.setBounds(200, 180, 200, 30);
		tdob.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tdob.setForeground(Color.white);
		add(tdob);
		
		JLabel phone = new JLabel("Phone No.: ");
		phone.setBounds(450, 180, 120, 30);
		phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		phone.setForeground(Color.white);
		add(phone);
		tphone = new JTextField();
		tphone.setBounds(590, 180, 200, 30);
		tphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		tphone.setBackground(Color.DARK_GRAY);
		tphone.setForeground(Color.white);
		add(tphone);
		
		JLabel address = new JLabel("Address: ");
		address.setBounds(60, 250, 100, 30);
		address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		address.setForeground(Color.white);
		add(address);
		taddress = new JTextField();
		taddress.setBounds(200, 250, 200, 30);
		taddress.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		taddress.setBackground(Color.DARK_GRAY);
		taddress.setForeground(Color.white);
		add(taddress);  
		
		JLabel mail = new JLabel("E-Mail: ");
		mail.setBounds(450, 250, 100, 30);    
		mail.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		mail.setForeground(Color.white);
		add(mail);
		tmail = new JTextField();
		tmail.setBounds(590, 250, 200, 30);
		tmail.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		tmail.setBackground(Color.DARK_GRAY);
		tmail.setForeground(Color.white);
		add(tmail);  
		
		JLabel deg = new JLabel("Education: ");
		deg.setBounds(60, 320, 140, 30);
		deg.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		deg.setForeground(Color.white);
		add(deg);
		teducation = new JTextField();
		teducation.setBounds(200, 320, 200, 30);
		teducation.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		teducation.setBackground(Color.DARK_GRAY);
		teducation.setForeground(Color.white);
		add(teducation);
		
		JLabel aadhar = new JLabel("Aadhar No: ");
		aadhar.setBounds(450, 320, 130, 30);
		aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		aadhar.setForeground(Color.white);
		add(aadhar);
		JLabel taadhar = new JLabel();
		taadhar.setBounds(590, 320, 200, 30);
		taadhar.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		taadhar.setBackground(Color.DARK_GRAY);
		taadhar.setForeground(Color.white);
		add(taadhar);  
		
		JLabel desg = new JLabel("Designation: ");
		desg.setBounds(60, 390, 130, 30);     
		desg.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		desg.setForeground(Color.white);
		add(desg);
		tdesg = new JTextField();
		tdesg.setBounds(200, 390, 200, 30);
		tdesg.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		tdesg.setBackground(Color.DARK_GRAY);
		tdesg.setForeground(Color.white);
		add(tdesg);
		
		JLabel salary = new JLabel("Salary: ");
		salary.setBounds(450, 390, 100, 30);
		salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		salary.setForeground(Color.white);
		add(salary);
		tsalary = new JTextField();
		tsalary.setBounds(590, 390, 200, 30);
		tsalary.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		tsalary.setBackground(Color.DARK_GRAY);
		tsalary.setForeground(Color.white);
		add(tsalary);   
		
		JLabel empid = new JLabel("Employee ID: ");
		empid.setBounds(60, 460, 130, 30);
		empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		empid.setForeground(Color.white);
		add(empid);
		tempid = new JLabel();
		tempid.setBounds(200, 460, 200, 30);
		tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		tempid.setForeground(Color.red);
		add(tempid); 
		
		try {
			c = new conn();
			String query = "select * from employees where empID='"+number+"';";
			ResultSet rs = c.st.executeQuery(query);
			while(rs.next()) {
				tname.setText(rs.getString("name"));
				tsname.setText(rs.getString("sname"));
				tdob.setText(rs.getString("dob"));
				taddress.setText(rs.getString("address"));
				tsalary.setText(rs.getString("salary"));
				tphone.setText(rs.getString("phoneNo"));
				tmail.setText(rs.getString("mail"));
				teducation.setText(rs.getString("education"));
				taadhar.setText(rs.getString("aadhar"));
				tempid.setText(rs.getString("empID"));
				tdesg.setText(rs.getString("designation"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(c!=null)c.close();
		}
		
		upd = new JButton("UPDATE");
		upd.setBounds(520, 560, 200, 50);
		upd.setBackground(Color.cyan);
		upd.setForeground(Color.black);
		upd.addActionListener(this);
		add(upd);
		
		back = new JButton("BACK");
		back.setBounds(170, 560, 200, 50);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/Icons/Add emp.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel bg = new JLabel(i3);
		bg.setBounds(0, 0, 900, 700);
		add(bg);
		
		setSize(900,700);
		setLocation(300,50);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==upd) {
			String sname = tsname.getText();
			String phone = tphone.getText();
			String address = taddress.getText();
			String mail = tmail.getText();
			String deg = teducation.getText();
			String desg = tdesg.getText();
			String salary = tsalary.getText();
			try {
				c = new conn();
				String query = "update employees set sname = '"+sname+"', phoneNo = '"+phone+"',address='"+address+"',mail='"+mail+"',education='"+deg+"',designation='"+desg+"',salary='"+salary+"' where empID = '"+number+"';";
				c.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details updated successfully");
				dispose();
				new view_Emp();
			}catch(Exception E) {
				E.printStackTrace();
			}finally {
				if(c!=null)c.close();
			}
		}
		else {
			dispose();
			new view_Emp();
		}
	}
	
	public static void main(String args[]) {
		new update_Emp("");
	}
}
