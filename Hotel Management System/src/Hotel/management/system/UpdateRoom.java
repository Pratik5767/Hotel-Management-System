package Hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateRoom extends JFrame implements ActionListener {

	Choice customerData;
	JTextField roomTextField, availableTextField, cleanTextField;
	JButton check, update, back;

	UpdateRoom() {
		setLayout(null);
		setBounds(300, 200, 980, 450);
		getContentPane().setBackground(Color.WHITE);

		JLabel heading = new JLabel("Update Room Status");
		heading.setFont(new Font("Tahoma", Font.PLAIN, 25));
		heading.setForeground(Color.BLUE);
		heading.setBounds(30, 20, 250, 30);
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
		room.setBounds(30, 130, 100, 20);
		add(room);

		roomTextField = new JTextField();
		roomTextField.setBounds(200, 130, 150, 25);
		add(roomTextField);

		JLabel available = new JLabel("Availability");
		available.setBounds(30, 180, 100, 20);
		add(available);

		availableTextField = new JTextField();
		availableTextField.setBounds(200, 180, 150, 25);
		add(availableTextField);

		JLabel clean = new JLabel("Cleaning Status");
		clean.setBounds(30, 230, 100, 20);
		add(clean);

		cleanTextField = new JTextField();
		cleanTextField.setBounds(200, 230, 150, 25);
		add(cleanTextField);

		check = new JButton("Check");
		check.setBackground(Color.BLACK);
		check.setForeground(Color.WHITE);
		check.setBounds(30, 300, 100, 30);
		check.addActionListener(this);
		add(check);

		update = new JButton("Update");
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.setBounds(150, 300, 100, 30);
		update.addActionListener(this);
		add(update);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(270, 300, 100, 30);
		back.addActionListener(this);
		add(back);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/seventh.jpg"));
		Image scaleImg = img.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon newImg = new ImageIcon(scaleImg);
		JLabel image = new JLabel(newImg);
		image.setBounds(400, 50, 500, 300);
		add(image);

		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == check) {
			String id = customerData.getSelectedItem();
			String query1 = "select * from customer where number='" + id + "'";
			String query2 = "select * from rooms where roomNo='" + roomTextField.getText() + "'";
			
			try {
				MyConnection connection = new MyConnection();
				ResultSet res1 = connection.statement.executeQuery(query1);
				while (res1.next()) {
					roomTextField.setText(res1.getString("room"));
				}

				ResultSet res2 = connection.statement.executeQuery(query2);
				while (res2.next()) {
					availableTextField.setText(res2.getString("availableRoom"));
					cleanTextField.setText(res2.getString("roomStatus"));
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		} else if (e.getSource() == update) {
			String roomNo = roomTextField.getText();
			String available = availableTextField.getText();
			String status = cleanTextField.getText();

			try {
				MyConnection connection = new MyConnection();
				connection.statement.executeUpdate("update rooms set availableRoom='" + available + "', roomStatus='"
						+ status + "' where roomNo='" + roomNo + "'");
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

		new UpdateRoom();
	}
}
