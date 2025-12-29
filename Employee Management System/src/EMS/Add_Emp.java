package EMS;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Add_Emp extends JFrame implements ActionListener{
	
	JTextField tname, tsname, taddress, tphone, tmail, tsalary, tdesg, taadhar;
	JDateChooser tdob;
	JComboBox tdeg;
	JButton add, back;
	JLabel tempid;
	
	conn c = null;
	
	Random ran = new Random();
	int num = ran.nextInt(999999);
	
	Add_Emp(){
				
		JLabel heading = new JLabel("Add Employee Detail: ");
		heading.setBounds(60, 40, 400, 40);
		heading.setFont(new Font("Serif", Font.BOLD, 30));
		heading.setForeground(Color.cyan);
		add(heading);
		
		JLabel name = new JLabel("Name: ");
		name.setBounds(60, 110, 100, 30);
		name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		name.setForeground(Color.white);
		add(name);
		tname = new JTextField();
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
		tdob = new JDateChooser();
		tdob.setBounds(200, 180, 200, 30);
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
		String []degrees = {"BBA","B.Tech","BCA","BA","B.Sc","B.Com","MBA","MCA","MA","M.Tech","M.Sc","PHD"};
		tdeg = new JComboBox(degrees);
		tdeg.setBounds(200, 320, 200, 30);
		tdeg.setFont(new Font("SAN_SERIF", Font.PLAIN, 15));
		tdeg.setBackground(Color.DARK_GRAY);
		tdeg.setForeground(Color.white);
		add(tdeg); 
		
		JLabel aadhar = new JLabel("Aadhar No: ");
		aadhar.setBounds(450, 320, 130, 30);
		aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		aadhar.setForeground(Color.white);
		add(aadhar);
		taadhar = new JTextField();
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
		tempid = new JLabel(""+num);
		tempid.setBounds(200, 460, 200, 30);
		tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
		tempid.setForeground(Color.red);
		add(tempid); 
		
		add = new JButton("ADD");
		add.setBounds(520, 560, 200, 50);
		add.setBackground(Color.cyan);
		add.setForeground(Color.black);
		add.addActionListener(this);
		add(add);
		
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
		if(e.getSource()==add) {
			String name = tname.getText();
			String sname = tsname.getText();
			String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
			String phone = tphone.getText();
			String address = taddress.getText();
			String mail = tmail.getText();
			String deg = (String)tdeg.getSelectedItem();
			String aadhar = taadhar.getText();
			String desg = tdesg.getText();
			String salary = tsalary.getText();
			String empid = tempid.getText();
			
			try {
				c = new conn();
				String query = "insert into employees values('"+name+"','"+sname+"','"+dob+"','"+phone+"','"+address+"','"+mail+"','"+deg+"','"+aadhar+"','"+desg+"','"+salary+"','"+empid+"');";
				c.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Employee Details added successfully.");
				dispose();
				new main_class();
			}catch(Exception E) {
				E.printStackTrace();
			}finally {
				if(c!=null)c.close();
			}
		}
		else if(e.getSource()==back) {
			dispose();
			new main_class();
		}
		
	}
	public static void main(String args[]) {
		new Add_Emp();
	}
}
