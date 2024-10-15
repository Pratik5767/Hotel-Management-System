package Hotel.management.system;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame {
	
	Reception() {
		setLayout(null);
		setBounds(350, 200, 800, 610);
		getContentPane().setBackground(Color.WHITE);
		
		JButton newCustomer = new JButton("New Customer Form");
		newCustomer.setBackground(Color.BLACK);
		newCustomer.setForeground(Color.WHITE);
		newCustomer.setBounds(10, 30, 200, 30);
		add(newCustomer);
		
		JButton rooms = new JButton("Rooms");
		rooms.setBackground(Color.BLACK);
		rooms.setForeground(Color.WHITE);
		rooms.setBounds(10, 80, 200, 30);
		add(rooms);
		
		JButton department = new JButton("Department");
		department.setBackground(Color.BLACK);
		department.setForeground(Color.WHITE);
		department.setBounds(10, 130, 200, 30);
		add(department);
		
		JButton allEmployee = new JButton("All Employee");
		allEmployee.setBackground(Color.BLACK);
		allEmployee.setForeground(Color.WHITE);
		allEmployee.setBounds(10, 180, 200, 30);
		add(allEmployee);
		
		JButton allCustomer = new JButton("All Customer");
		allCustomer.setBackground(Color.BLACK);
		allCustomer.setForeground(Color.WHITE);
		allCustomer.setBounds(10, 230, 200, 30);
		add(allCustomer);
		
		JButton managerInfo = new JButton("Manager Info");
		managerInfo.setBackground(Color.BLACK);
		managerInfo.setForeground(Color.WHITE);
		managerInfo.setBounds(10, 280, 200, 30);
		add(managerInfo);
		
		JButton checkout = new JButton("Checkout");
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.WHITE);
		checkout.setBounds(10, 280, 200, 30);
		add(checkout);
		
		JButton updateStatus = new JButton("Update Status");
		updateStatus.setBackground(Color.BLACK);
		updateStatus.setForeground(Color.WHITE);
		updateStatus.setBounds(10, 330, 200, 30);
		add(updateStatus);
		
		JButton roomStatus = new JButton("Update Room Status");
		roomStatus.setBackground(Color.BLACK);
		roomStatus.setForeground(Color.WHITE);
		roomStatus.setBounds(10, 380, 200, 30);
		add(roomStatus);
		
		JButton pickService = new JButton("PickUp Service");
		pickService.setBackground(Color.BLACK);
		pickService.setForeground(Color.WHITE);
		pickService.setBounds(10, 430, 200, 30);
		add(pickService);
		
		JButton searchRoom = new JButton("Search Room");
		searchRoom.setBackground(Color.BLACK);
		searchRoom.setForeground(Color.WHITE);
		searchRoom.setBounds(10, 480, 200, 30);
		add(searchRoom);
		
		JButton logout = new JButton("Logout");
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.WHITE);
		logout.setBounds(10, 530, 200, 30);
		add(logout);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/fourth.jpg"));
		JLabel image = new JLabel(img);
		image.setBounds(250, 30, 500, 470);
		add(image);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		
		new Reception();
	}

}
