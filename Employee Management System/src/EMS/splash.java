package EMS;

import java.awt.Image;

import javax.swing.*;

public class splash extends JFrame {
	
	splash(){				
		ImageIcon i1 = new ImageIcon(getClass().getResource("/Icons/front.png"));
		Image i2 = i1.getImage().getScaledInstance(1170, 700, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1170, 700);
		add(image);
		
		setSize(1170,700);
		setLocation(175,80);
		setLayout(null);
		setVisible(true);
		
		Timer timer = new Timer(5000, e-> {
			dispose(); 
			new Login();
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	public static void main(String args[]) {
		new splash();
	}
}
