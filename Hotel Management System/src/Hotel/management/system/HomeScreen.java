package Hotel.management.system;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HomeScreen extends JFrame implements ActionListener {

	JButton next;
	
	HomeScreen() {
		setLayout(null);
		
		setSize(1366, 565);
		setLocation(100, 100);
		setResizable(false);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/first.jpg"));
		JLabel image = new JLabel(img);
		// Location x, Location y, length, breadth
		image.setBounds(0, 0, 1366, 565);
		add(image);
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setBounds(20, 430, 1000, 90);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("serif", Font.PLAIN, 50));
		image.add(text);
		
		next = new JButton("Next");
		next.setBounds(1150, 450, 110, 35);
		next.setBackground(Color.WHITE);
		next.setFont(new Font("serif", Font.PLAIN, 20));
		next.addActionListener(this);
		image.add(next);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		// Dipper functionality
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				System.out.println(e);
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Login().setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new HomeScreen();
	}
}