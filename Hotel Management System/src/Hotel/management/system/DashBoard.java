package Hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DashBoard extends JFrame implements ActionListener {
	
	DashBoard() {
		setLayout(null);
		setSize(1550, 1000);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/third.jpg"));
		Image scaleImg = img.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
		ImageIcon newImg = new ImageIcon(scaleImg);
		JLabel image = new JLabel(newImg);
		image.setBounds(0, 0, 1550, 1000);
		add(image);
		
		JLabel text = new JLabel("THE TAJ GROUPS WELCOMES YOU");
		text.setBounds(400, 80, 1000, 50);
		text.setFont(new Font("Tohama", Font.PLAIN, 45));
		text.setForeground(Color.WHITE);
		image.add(text);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1550, 30);
		image.add(menuBar);
		
		JMenu hotel = new JMenu("Hotel Management");
		hotel.setForeground(Color.BLUE);
		menuBar.add(hotel);
		
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);

		JMenu admin = new JMenu("Admin");
		admin.setForeground(Color.BLUE);
		menuBar.add(admin);
		
		JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
		addEmployee.addActionListener(this);
		admin.add(addEmployee);

		JMenuItem addRooms = new JMenuItem("ADD ROOMS");
		addRooms.addActionListener(this);
		admin.add(addRooms);
		
		JMenuItem addDrivers = new JMenuItem("ADD DRIVERS");
		addDrivers.addActionListener(this);
		admin.add(addDrivers);
		
		JMenu close = new JMenu("Close");
		close.setForeground(Color.RED);
		menuBar.add(close);
		
		JMenuItem exit = new JMenuItem("Exit Dashboard");
		exit.addActionListener(this);
		exit.setBackground(Color.RED);
		exit.setForeground(Color.WHITE);
		close.add(exit);
		
		setUndecorated(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// when using menuItems we use getActionCommand to write the action
		// It return a text of a menuItem which we can equate
		if(e.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee();
		} else if (e.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms();
		} else if (e.getActionCommand().equals("ADD DRIVERS")) {
			new AddDrivers();
		} else if (e.getActionCommand().equals("RECEPTION")) {
			new Reception();
		} else if (e.getActionCommand().equals("Exit Dashboard")) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		
		new DashBoard();
	}

}
