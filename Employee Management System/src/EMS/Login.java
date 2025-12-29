package EMS;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JTextField tusername;
	JPasswordField tpassword;
	JButton login, back;
	conn c = null;
	
	Login(){
		JLabel username = new JLabel("Username: ");
		username.setBounds(90, 50, 100, 25);  
		username.setForeground(Color.white);//frame-x, frame-y, width, height
		add(username);
		tusername = new JTextField();
		tusername.setBounds(90, 75, 300, 25);
		add(tusername);
		
		JLabel password = new JLabel("Password: ");
		password.setBounds(90, 110,100,25);
		password.setForeground(Color.white);
		add(password);
		tpassword = new JPasswordField();
		tpassword.setBounds(90, 135, 300, 25);
		add(tpassword);
		
		login = new JButton("LOGIN");
		login.setBounds(165, 210, 150, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		back = new JButton("Cancel");
		back.setBounds(165, 260, 150, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/Icons/LoginB.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel img = new JLabel(i3);
		img.setBounds(0, 0, 500, 400);
		add(img);
		
		
		setSize(500,400);
		setLocation(525,240);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			try {
				String username = tusername.getText();
				char[] pwdChars = tpassword.getPassword();
				String password = new String(pwdChars);
				c = new conn();
				String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
				ResultSet rs =  c.st.executeQuery(query);
				if(rs.next()) {
					dispose();
					new main_class();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
				}
			}catch(Exception E){
				E.printStackTrace();
			}finally {
				if(c!=null)c.close();
			}
		}
		else if(e.getSource()==back) {
			System.exit(0);
		}
	}
	
	public static void main(String args[]) {
		new Login();
	}
}
