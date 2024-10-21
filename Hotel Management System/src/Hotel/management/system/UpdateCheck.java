package Hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateCheck extends JFrame implements ActionListener {

	Choice customerData;
	JTextField roomTextField, nameTextField, checkInTextField, paidTextField, pendingTextField;
	JButton check, update, back;

	UpdateCheck() {
		setLayout(null);
		setBounds(300, 200, 980, 500);
		getContentPane().setBackground(Color.WHITE);

		JLabel heading = new JLabel("Update Status");
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		heading.setForeground(Color.BLUE);
		heading.setBounds(90, 20, 200, 30);
		add(heading);

		JLabel id = new JLabel("Customer Id");
		id.setBounds(30, 80, 100, 20);
		add(id);

		customerData = new Choice();
		customerData.setBounds(200, 80, 150, 25);
		add(customerData);

		try {
			MyConnection connection = new MyConnection();
			String query = "select * from customer";
			ResultSet res = connection.statement.executeQuery(query);

			while (res.next()) {
				customerData.add(res.getString("number"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		JLabel room = new JLabel("Room Number");
		room.setBounds(30, 120, 100, 20);
		add(room);

		roomTextField = new JTextField();
		roomTextField.setBounds(200, 120, 150, 25);
		add(roomTextField);

		JLabel name = new JLabel("Name");
		name.setBounds(30, 160, 100, 20);
		add(name);

		nameTextField = new JTextField();
		nameTextField.setBounds(200, 160, 150, 25);
		add(nameTextField);

		JLabel checkIn = new JLabel("checkIn Time");
		checkIn.setBounds(30, 200, 100, 20);
		add(checkIn);

		checkInTextField = new JTextField();
		checkInTextField.setBounds(200, 200, 150, 25);
		add(checkInTextField);

		JLabel paid = new JLabel("Amount Paid");
		paid.setBounds(30, 240, 100, 20);
		add(paid);

		paidTextField = new JTextField();
		paidTextField.setBounds(200, 240, 150, 25);
		add(paidTextField);

		JLabel pending = new JLabel("Pending Amount");
		pending.setBounds(30, 280, 100, 20);
		add(pending);

		pendingTextField = new JTextField();
		pendingTextField.setBounds(200, 280, 150, 25);
		add(pendingTextField);

		check = new JButton("Check");
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.setBounds(30, 340, 100, 30);
		check.addActionListener(this);
		add(check);

		update = new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setBounds(150, 340, 100, 30);
		update.addActionListener(this);
		add(update);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(270, 340, 100, 30);
		back.addActionListener(this);
		add(back);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/nine.jpg"));
		JLabel image = new JLabel(img);
		image.setBounds(400, 50, 500, 300);
		add(image);

		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == check) {
			String id = customerData.getSelectedItem();

			try {
				MyConnection connection = new MyConnection();
				ResultSet res1 = connection.statement.executeQuery("select * from customer where number='" + id + "'");
				while (res1.next()) {
					roomTextField.setText(res1.getString("room"));
					nameTextField.setText(res1.getString("name"));
					checkInTextField.setText(res1.getString("checkintime"));
					paidTextField.setText(res1.getString("deposit"));
				}

				ResultSet res2 = connection.statement
						.executeQuery("select * from rooms where roomNo='" + roomTextField.getText() + "'");
				while (res2.next()) {
					String price = res2.getString("roomPrice");
					int amountPaid = Integer.parseInt(price) - Integer.parseInt(paidTextField.getText());
					pendingTextField.setText("" + amountPaid);
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}

		} else if (e.getSource() == update) {
			String number = customerData.getSelectedItem();
			String roomNo = roomTextField.getText();
			String name = nameTextField.getText();
			String checkintime = checkInTextField.getText();
			String paid = paidTextField.getText();

			try {
				MyConnection connection = new MyConnection();
				connection.statement.executeUpdate("update customer set room='" + roomNo + "', name='" + name
						+ "', checkintime='" + checkintime + "', deposit='" + paid + "' where number='"+number+"'");
				JOptionPane.showMessageDialog(null, "Data updated successfully");
				setVisible(false);
				new Reception().setVisible(true);
			} catch (Exception e2) {
				System.out.println(e2);
			}
		} else {
			setVisible(false);
			new Reception().setVisible(true);
		}
	}

	public static void main(String[] args) {

		new UpdateCheck();
		System.out.println("Hello World");
	}
}
