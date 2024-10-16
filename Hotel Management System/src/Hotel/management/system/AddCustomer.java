package Hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {

	JComboBox userID;
	JTextField numberTextField, nameTextField, countryTextField, depositTextField;
	JRadioButton male, female, other;
	Choice allcatedRooms;
	JButton add, back;
	JLabel checkTime;

	AddCustomer() {
		setLayout(null);
		setBounds(350, 200, 800, 550);
		getContentPane().setBackground(Color.WHITE);

		JLabel text = new JLabel("NEW CUSTOMER FORM");
		text.setFont(new Font("Raleway", Font.PLAIN, 20));
		text.setBounds(100, 20, 300, 30);
		add(text);

		JLabel id = new JLabel("ID");
		id.setFont(new Font("Raleway", Font.PLAIN, 20));
		id.setBounds(35, 80, 100, 20);
		add(id);

		String idOption[] = { "Aadhaar", "Passport", "Driving License", "Voter-id card", "Rashan card" };
		userID = new JComboBox(idOption);
		userID.setBackground(Color.WHITE);
		userID.setBounds(200, 80, 150, 25);
		add(userID);

		JLabel number = new JLabel("Number");
		number.setFont(new Font("Raleway", Font.PLAIN, 20));
		number.setBounds(35, 120, 150, 20);
		add(number);

		numberTextField = new JTextField();
		numberTextField.setBounds(200, 120, 150, 25);
		add(numberTextField);

		JLabel name = new JLabel("Name");
		name.setFont(new Font("Raleway", Font.PLAIN, 20));
		name.setBounds(35, 160, 150, 20);
		add(name);

		nameTextField = new JTextField();
		nameTextField.setBounds(200, 160, 150, 25);
		add(nameTextField);

		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Raleway", Font.PLAIN, 20));
		gender.setBounds(35, 200, 150, 20);
		add(gender);

		male = new JRadioButton("Male");
		male.setBackground(Color.WHITE);
		male.setBounds(200, 200, 60, 30);
		add(male);

		female = new JRadioButton("Female");
		female.setBackground(Color.WHITE);
		female.setBounds(270, 200, 70, 30);
		add(female);

		ButtonGroup selectGender = new ButtonGroup();
		selectGender.add(male);
		selectGender.add(female);

		JLabel country = new JLabel("Country");
		country.setFont(new Font("Raleway", Font.PLAIN, 20));
		country.setBounds(35, 240, 150, 20);
		add(country);

		countryTextField = new JTextField();
		countryTextField.setBounds(200, 240, 150, 25);
		add(countryTextField);

		JLabel allocatedRoom = new JLabel("Room No");
		allocatedRoom.setFont(new Font("Raleway", Font.PLAIN, 20));
		allocatedRoom.setBounds(35, 280, 150, 20);
		add(allocatedRoom);

		allcatedRooms = new Choice();

		try {
			MyConnection connection = new MyConnection();
			String query = "select * from rooms where availableRoom='Available'";
			ResultSet res = connection.statement.executeQuery(query);

			while (res.next()) {
				allcatedRooms.add(res.getString("roomNo"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		allcatedRooms.setBounds(200, 280, 150, 25);
		add(allcatedRooms);

		JLabel checkIn = new JLabel("Checkin Time");
		checkIn.setFont(new Font("Raleway", Font.PLAIN, 20));
		checkIn.setBounds(35, 320, 150, 20);
		add(checkIn);

		Date date = new Date();

		checkTime = new JLabel("" + date);
		checkTime.setFont(new Font("Raleway", Font.PLAIN, 10));
		checkTime.setBounds(200, 320, 150, 25);
		add(checkTime);

		JLabel deposit = new JLabel("Deposit");
		deposit.setFont(new Font("Raleway", Font.PLAIN, 20));
		deposit.setBounds(35, 360, 150, 20);
		add(deposit);

		depositTextField = new JTextField();
		depositTextField.setBounds(200, 360, 150, 25);
		add(depositTextField);

		add = new JButton("Add");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setBounds(50, 410, 120, 30);
		add.addActionListener(this);
		add(add);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(200, 410, 120, 30);
		back.addActionListener(this);
		add(back);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/fifth.png"));
		Image scaleImg = img.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon newImg = new ImageIcon(scaleImg);
		JLabel image = new JLabel(newImg);
		image.setBounds(400, 50, 300, 400);
		add(image);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			String id = (String) userID.getSelectedItem();
			String number = numberTextField.getText();
			String name = nameTextField.getText();

			String gender = null;
			if (male.isSelected()) {
				gender = "Male";
			} else {
				gender = "Female";
			}

			String country = countryTextField.getText();
			String roomNo = allcatedRooms.getSelectedItem();
			String checkInTime = checkTime.getText();
			String deposit = depositTextField.getText();

			try {
				String query1 = "insert into customer values('" + id + "', '" + number + "', '" + name + "', '" + gender
						+ "', '" + country + "', '" + roomNo + "', '" + checkInTime + "', '" + deposit + "')";
				String query2 = "update rooms set availableRoom='Occupied' where roomNo='"+roomNo+"'";
				
				MyConnection connection = new MyConnection();
				connection.statement.executeUpdate(query1);
				connection.statement.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "New Customer added successfully");
				
				setVisible(false);
				new Reception().setVisible(true);
			} catch (Exception e1) {
				System.out.println(e1);
			}
		} else if (e.getSource() == back) {
			setVisible(false);
			new Reception().setVisible(true);
		}
	}

	public static void main(String[] args) {

		new AddCustomer();
	}

}
