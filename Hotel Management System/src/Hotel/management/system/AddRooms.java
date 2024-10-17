package Hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddRooms extends JFrame implements ActionListener {

	JTextField roomTextField, roomPriceField;
	JComboBox availablerooms, cleanrooms, availablebedType;
	JButton add, cancel;

	AddRooms() {
		setLayout(null);
		// Location height/width
		setBounds(330, 200, 940, 470);
		getContentPane().setBackground(Color.WHITE);

		JLabel heading = new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(150, 20, 200, 20);
		add(heading);

		JLabel roomNo = new JLabel("Room No.");
		roomNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roomNo.setBounds(60, 80, 120, 30);
		add(roomNo);

		roomTextField = new JTextField();
		roomTextField.setBounds(200, 80, 150, 30);
		add(roomTextField);

		JLabel roomAvailable = new JLabel("Available");
		roomAvailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roomAvailable.setBounds(60, 130, 120, 30);
		add(roomAvailable);

		String roomsAvailableOptions[] = { "Select", "Available", "Occupied" };
		availablerooms = new JComboBox(roomsAvailableOptions);
		availablerooms.setBounds(200, 130, 150, 30);
		availablerooms.setBackground(Color.WHITE);
		add(availablerooms);

		JLabel roomClean = new JLabel("Cleaning status");
		roomClean.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roomClean.setBounds(60, 180, 120, 30);
		add(roomClean);

		String roomsCleanOptions[] = { "Select", "Cleaned", "Dirty" };
		cleanrooms = new JComboBox(roomsCleanOptions);
		cleanrooms.setBounds(200, 180, 150, 30);
		cleanrooms.setBackground(Color.WHITE);
		add(cleanrooms);

		JLabel roomPrice = new JLabel("Price");
		roomPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roomPrice.setBounds(60, 230, 120, 30);
		add(roomPrice);

		roomPriceField = new JTextField();
		roomPriceField.setBounds(200, 230, 150, 30);
		add(roomPriceField);

		JLabel bedType = new JLabel("Bed Type");
		bedType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bedType.setBounds(60, 280, 120, 30);
		add(bedType);

		String bedTypeOptions[] = { "Select", "Single Bed", "Double Bed" };
		availablebedType = new JComboBox(bedTypeOptions);
		availablebedType.setBounds(200, 280, 150, 30);
		availablebedType.setBackground(Color.WHITE);
		add(availablebedType);

		add = new JButton("Add Room");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setBounds(60, 350, 130, 30);
		add.addActionListener(this);
		add(add);

		cancel = new JButton("Cancel");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.setBounds(220, 350, 130, 30);
		cancel.addActionListener(this);
		add(cancel);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/Twelve.jpg"));
		JLabel image = new JLabel(img);
		image.setBounds(400, 30, 500, 300);
		add(image);

		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			String roomNo = roomTextField.getText();
			String availableRoom = (String) availablerooms.getSelectedItem();
			String roomStatus = (String) cleanrooms.getSelectedItem();
			String roomPrice = roomPriceField.getText();
			String bedType = (String) availablebedType.getSelectedItem();

			try {
				MyConnection connection = new MyConnection();
				String query = "insert into rooms value('" + roomNo + "', '" + availableRoom + "', '" + roomStatus
						+ "', '" + roomPrice + "', '" + bedType + "')";
				connection.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "New room added successfully");
				setVisible(false);
			} catch (Exception e1) {
				System.out.println(e1);
			}

		} else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {

		new AddRooms();
	}

}
