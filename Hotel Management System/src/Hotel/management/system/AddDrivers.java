package Hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDrivers extends JFrame implements ActionListener {

	JTextField nameTextField, ageTextField, carCompanyField, carModelField, locationField;
	JComboBox selectGender, selectOption;
	JButton add, cancel;

	AddDrivers() {
		setLayout(null);
		// Location height/width
		setBounds(300, 200, 980, 470);
		getContentPane().setBackground(Color.WHITE);

		JLabel heading = new JLabel("Add Drivers");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(150, 10, 200, 20);
		add(heading);

		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.PLAIN, 16));
		name.setBounds(60, 70, 120, 30);
		add(name);

		nameTextField = new JTextField();
		nameTextField.setBounds(200, 70, 150, 30);
		add(nameTextField);

		JLabel age = new JLabel("Age");
		age.setFont(new Font("Tahoma", Font.PLAIN, 16));
		age.setBounds(60, 110, 120, 30);
		add(age);

		ageTextField = new JTextField();
		ageTextField.setBounds(200, 110, 150, 30);
		add(ageTextField);

		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gender.setBounds(60, 150, 120, 30);
		add(gender);

		String genderOptions[] = { "Male", "Female" };
		selectGender = new JComboBox(genderOptions);
		selectGender.setBounds(200, 150, 150, 30);
		selectGender.setBackground(Color.WHITE);
		add(selectGender);

		JLabel car = new JLabel("Car Company");
		car.setFont(new Font("Tahoma", Font.PLAIN, 16));
		car.setBounds(60, 190, 120, 30);
		add(car);

		carCompanyField = new JTextField();
		carCompanyField.setBounds(200, 190, 150, 30);
		add(carCompanyField);

		JLabel model = new JLabel("Car Model");
		model.setFont(new Font("Tahoma", Font.PLAIN, 16));
		model.setBounds(60, 230, 120, 30);
		add(model);

		carModelField = new JTextField();
		carModelField.setBounds(200, 230, 150, 30);
		add(carModelField);

		JLabel available = new JLabel("Available");
		available.setFont(new Font("Tahoma", Font.PLAIN, 16));
		available.setBounds(60, 270, 120, 30);
		add(available);

		String availableOptions[] = { "Available", "Busy" };
		selectOption = new JComboBox(availableOptions);
		selectOption.setBounds(200, 270, 150, 30);
		selectOption.setBackground(Color.WHITE);
		add(selectOption);

		JLabel location = new JLabel("Location");
		location.setFont(new Font("Tahoma", Font.PLAIN, 16));
		location.setBounds(60, 310, 120, 30);
		add(location);

		locationField = new JTextField();
		locationField.setBounds(200, 310, 150, 30);
		add(locationField);

		add = new JButton("Add Driver");
		add.setForeground(Color.WHITE);
		add.setBackground(Color.BLACK);
		add.setBounds(60, 370, 130, 30);
		add.addActionListener(this);
		add(add);

		cancel = new JButton("Cancel");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.BLACK);
		cancel.setBounds(220, 370, 130, 30);
		cancel.addActionListener(this);
		add(cancel);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/eleven.jpg"));
		Image scaleImg = img.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon newImg = new ImageIcon(scaleImg);
		JLabel image = new JLabel(newImg);
		image.setBounds(400, 30, 500, 300);
		add(image);

		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			String name = nameTextField.getText();
			String age = ageTextField.getText();
			String gender = (String) selectGender.getSelectedItem();
			String company = carCompanyField.getText();
			String brand = carModelField.getText();
			String availability = (String) selectOption.getSelectedItem();
			String location = locationField.getText();

			try {
				MyConnection connection = new MyConnection();
				String query = "insert into driver value('" + name + "', '" + age + "', '" + gender + "', '" + company
						+ "', '" + brand + "', '" + availability + "', '" + location + "')";
				connection.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "New Driver added successfully");
				setVisible(false);
			} catch (Exception e1) {
				System.out.println(e1);
			}

		} else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {

		new AddDrivers();
	}
}
