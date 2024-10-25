package Hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Checkout extends JFrame implements ActionListener {

	Choice customer;
	JLabel roomNo, checkIn, checkOut;
	JButton checkOutBtn, back;

	Checkout() {
		setLayout(null);
		setBounds(400, 200, 800, 400);
		getContentPane().setBackground(Color.WHITE);

		JLabel heading = new JLabel("Checkout");
		heading.setBounds(100, 20, 100, 30);
		heading.setForeground(Color.BLUE);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(heading);

		JLabel customerId = new JLabel("Customer Id");
		customerId.setBounds(30, 80, 100, 30);
		add(customerId);

		customer = new Choice();
		customer.setBounds(150, 80, 150, 25);
		add(customer);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/tick.png"));
		Image scaleImg = img.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon newImg = new ImageIcon(scaleImg);
		JLabel tick = new JLabel(newImg);
		tick.setBounds(310, 80, 20, 20);
		add(tick);

		JLabel roomId = new JLabel("Room Number");
		roomId.setBounds(30, 130, 100, 30);
		add(roomId);

		roomNo = new JLabel();
		roomNo.setBounds(150, 130, 200, 30);
		add(roomNo);

		JLabel checkInTime = new JLabel("CheckIn Time");
		checkInTime.setBounds(30, 180, 100, 30);
		add(checkInTime);

		checkIn = new JLabel();
		checkIn.setBounds(150, 180, 200, 30);
		add(checkIn);

		JLabel checkOutTime = new JLabel("CheckOut Time");
		checkOutTime.setBounds(30, 230, 100, 30);
		add(checkOutTime);
		
		try {
			MyConnection connection = new MyConnection();
			String query = "select * from customer";
			ResultSet res = connection.statement.executeQuery(query);

			while (res.next()) {
				customer.add(res.getString("number"));
				roomNo.setText(res.getString("room"));
				checkIn.setText(res.getString("checkintime"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		Date date = new Date();
		checkOut = new JLabel("" + date);
		checkOut.setBounds(150, 230, 200, 30);
		add(checkOut);

		checkOutBtn = new JButton("Checkout");
		checkOutBtn.setBackground(Color.BLACK);
		checkOutBtn.setForeground(Color.WHITE);
		checkOutBtn.setBounds(30, 280, 120, 30);
		checkOutBtn.addActionListener(this);
		add(checkOutBtn);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(170, 280, 120, 30);
		back.addActionListener(this);
		add(back);

		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("./icons/sixth.jpg"));
		Image scaleImg1 = img1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon newImg1 = new ImageIcon(scaleImg1);
		JLabel image = new JLabel(newImg1);
		image.setBounds(350, 50, 400, 250);
		add(image);

		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkOutBtn) {
			String query1 = "delete from customer where number='" + customer.getSelectedItem() + "'";
			String query2 = "update rooms set availableRoom = 'Available' where roomNo='" + roomNo.getText() + "'";

			try {
				MyConnection connection = new MyConnection();
				connection.statement.executeUpdate(query1);
				connection.statement.executeUpdate(query2);

				JOptionPane.showMessageDialog(null, "Checkout done");
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

		new Checkout();
	}

}
