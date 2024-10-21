package Hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {

	JButton newCustomer, rooms, department, allEmployee, allCustomer, managerInfo, checkout, updateStatus, roomStatus,
			pickService, searchRoom, logout;

	Reception() {
		setLayout(null);
		setBounds(350, 200, 800, 560);
		getContentPane().setBackground(Color.WHITE);

		newCustomer = new JButton("New Customer Form");
		newCustomer.setBackground(Color.BLACK);
		newCustomer.setForeground(Color.WHITE);
		newCustomer.setBounds(10, 30, 200, 30);
		newCustomer.addActionListener(this);
		add(newCustomer);

		rooms = new JButton("Rooms");
		rooms.setBackground(Color.BLACK);
		rooms.setForeground(Color.WHITE);
		rooms.setBounds(10, 70, 200, 30);
		rooms.addActionListener(this);
		add(rooms);

		department = new JButton("Department");
		department.setBackground(Color.BLACK);
		department.setForeground(Color.WHITE);
		department.setBounds(10, 110, 200, 30);
		department.addActionListener(this);
		add(department);

		allEmployee = new JButton("All Employee");
		allEmployee.setBackground(Color.BLACK);
		allEmployee.setForeground(Color.WHITE);
		allEmployee.setBounds(10, 150, 200, 30);
		allEmployee.addActionListener(this);
		add(allEmployee);

		allCustomer = new JButton("All Customer");
		allCustomer.setBackground(Color.BLACK);
		allCustomer.setForeground(Color.WHITE);
		allCustomer.setBounds(10, 190, 200, 30);
		allCustomer.addActionListener(this);
		add(allCustomer);

		managerInfo = new JButton("Manager Info");
		managerInfo.setBackground(Color.BLACK);
		managerInfo.setForeground(Color.WHITE);
		managerInfo.setBounds(10, 230, 200, 30);
		managerInfo.addActionListener(this);
		add(managerInfo);

		checkout = new JButton("Checkout");
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.WHITE);
		checkout.setBounds(10, 270, 200, 30);
		add(checkout);

		updateStatus = new JButton("Update Status");
		updateStatus.setBackground(Color.BLACK);
		updateStatus.setForeground(Color.WHITE);
		updateStatus.setBounds(10, 310, 200, 30);
		updateStatus.addActionListener(this);
		add(updateStatus);

		roomStatus = new JButton("Update Room Status");
		roomStatus.setBackground(Color.BLACK);
		roomStatus.setForeground(Color.WHITE);
		roomStatus.setBounds(10, 350, 200, 30);
		roomStatus.addActionListener(this);
		add(roomStatus);

		pickService = new JButton("PickUp Service");
		pickService.setBackground(Color.BLACK);
		pickService.setForeground(Color.WHITE);
		pickService.setBounds(10, 390, 200, 30);
		add(pickService);

		searchRoom = new JButton("Search Room");
		searchRoom.setBackground(Color.BLACK);
		searchRoom.setForeground(Color.WHITE);
		searchRoom.setBounds(10, 430, 200, 30);
		searchRoom.addActionListener(this);
		add(searchRoom);

		logout = new JButton("Logout");
		logout.setBackground(Color.BLACK);
		logout.setForeground(Color.WHITE);
		logout.setBounds(10, 470, 200, 30);
		logout.addActionListener(this);
		add(logout);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/fourth.jpg"));
		JLabel image = new JLabel(img);
		image.setBounds(250, 30, 500, 470);
		add(image);

		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newCustomer) {
			setVisible(false);
			new AddCustomer().setVisible(true);
		} 
		else if(e.getSource() == rooms) {
			setVisible(false);
			new Room().setVisible(true);
		} 
		else if(e.getSource() == department) {
			setVisible(false);
			new Department().setVisible(true);
		} 
		else  if (e.getSource() == allEmployee) {
			setVisible(false);
			new EmployeeInfo().setVisible(true);
		} 
		else if (e.getSource() == managerInfo) {
			setVisible(false);
			new ManagerInfo().setVisible(true);
		}
		else if (e.getSource() == allCustomer) {
			setVisible(false);
			new CustomerInfo().setVisible(true);
		} 
		else if (e.getSource() == searchRoom) {
			setVisible(false);
			new SearchRoom().setVisible(true);
		}
		else if(e.getSource() == updateStatus) {
			setVisible(false);
			new UpdateCheck().setVisible(true);
		}
		else if(e.getSource() == roomStatus) {
			setVisible(false);
			new UpdateRoom().setVisible(true);
		}
	}

	public static void main(String[] args) {

		new Reception();
	}

}
