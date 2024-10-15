package Hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener {

	JTextField nameTextField, ageTextField, salaryTextField, phoneTextField, emailTextField, aadhaarTextField;
	JRadioButton male, female, other;
	JComboBox jobList;
	JButton submit;

	AddEmployee() {
		setLayout(null);
		setSize(850, 500);
		setLocation(350, 200);
		getContentPane().setBackground(Color.WHITE);

		JLabel name = new JLabel("Name");
		name.setBounds(60, 30, 120, 30);
		name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(name);

		nameTextField = new JTextField();
		nameTextField.setBounds(200, 30, 250, 30);
		add(nameTextField);

		JLabel age = new JLabel("Age");
		age.setBounds(60, 80, 120, 30);
		age.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(age);

		ageTextField = new JTextField();
		ageTextField.setBounds(200, 80, 250, 30);
		add(ageTextField);

		JLabel gender = new JLabel("Gender");
		gender.setBounds(60, 130, 120, 30);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(gender);

		// Radio Buttons
		male = new JRadioButton("Male");
		male.setBounds(200, 130, 70, 30);
		male.setFont(new Font("Tahoma", Font.PLAIN, 14));
		male.setBackground(Color.WHITE);
		add(male);

		female = new JRadioButton("Female");
		female.setBounds(290, 130, 70, 30);
		female.setFont(new Font("Tahoma", Font.PLAIN, 14));
		female.setBackground(Color.WHITE);
		add(female);

		other = new JRadioButton("other");
		other.setBounds(390, 130, 70, 30);
		other.setFont(new Font("Tahoma", Font.PLAIN, 14));
		other.setBackground(Color.WHITE);
		add(other);

		ButtonGroup selectGender = new ButtonGroup();
		selectGender.add(male);
		selectGender.add(female);
		selectGender.add(other);

		JLabel job = new JLabel("Job");
		job.setBounds(60, 180, 120, 30);
		job.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(job);

		String[] jobarr = { "Select", "Front Desk Clerks", "Porters", "Housekeepings", "Kitchen staff", "Room services", "Chefs",
				"Waiter/Waitress", "Manager", "Accountant" };
		jobList = new JComboBox(jobarr);
		jobList.setBounds(200, 180, 250, 30);
		jobList.setBackground(Color.WHITE);
		add(jobList);

		JLabel salary = new JLabel("Salary");
		salary.setBounds(60, 230, 120, 30);
		salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(salary);

		salaryTextField = new JTextField();
		salaryTextField.setBounds(200, 230, 250, 30);
		add(salaryTextField);

		JLabel phone = new JLabel("Phone No.");
		phone.setBounds(60, 290, 120, 30);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(phone);

		phoneTextField = new JTextField();
		phoneTextField.setBounds(200, 290, 250, 30);
		add(phoneTextField);

		JLabel email = new JLabel("Email");
		email.setBounds(60, 350, 120, 30);
		email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(email);

		emailTextField = new JTextField();
		emailTextField.setBounds(200, 350, 250, 30);
		add(emailTextField);

		JLabel aadhaar = new JLabel("Aadhaar");
		aadhaar.setBounds(60, 400, 120, 30);
		aadhaar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(aadhaar);

		aadhaarTextField = new JTextField();
		aadhaarTextField.setBounds(200, 400, 250, 30);
		add(aadhaarTextField);

		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(650, 420, 150, 30);
		submit.addActionListener(this);
		add(submit);

		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/tenth.jpg"));
		Image scaleImg = img.getImage().getScaledInstance(430, 430, Image.SCALE_DEFAULT);
		ImageIcon newImg = new ImageIcon(scaleImg);
		JLabel image = new JLabel(newImg);
		image.setBounds(430, 70, 430, 430);
		add(image);

		setResizable(false);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = nameTextField.getText();
		String age = ageTextField.getText();
		String salary = salaryTextField.getText();
		String phone = phoneTextField.getText();
		String email = emailTextField.getText();
		String aadhaar = aadhaarTextField.getText();

		String gender = null;
		if (male.isSelected()) {
			gender = "male";
		} else if (female.isSelected()) {
			gender = "female";
		} else {
			gender = "other";
		}

		String job = (String) jobList.getSelectedItem();
		
		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "Name should not be empty");
			return;
		}
		else if (age.equals("")) {
			JOptionPane.showMessageDialog(null, "Age should not be empty");
			return;
		} 
		else if (salary.equals("")) {
			JOptionPane.showMessageDialog(null, "Salary should not be empty");
			return;
		}
		else if (phone.equals("")) {
			JOptionPane.showMessageDialog(null, "Phone should not be empty");
			return;
		}
		else if (email.equals("")) {
			JOptionPane.showMessageDialog(null, "Email should not be empty");
			return;
		}
		else if (aadhaar.equals("")) {
			JOptionPane.showMessageDialog(null, "Aadhaar should not be empty");
			return;
		}		

		try {
			MyConnection connection = new MyConnection();
			String query = "insert into employee values ('" + name + "', '" + age + "', '" + gender + "', '" + job
					+ "', '" + salary + "', '" + phone + "', '" + email + "', '" + aadhaar + "')";
			
			connection.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Employee added successfully");
			setVisible(false);
		} catch (Exception e2) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {

		new AddEmployee();
	}

}
