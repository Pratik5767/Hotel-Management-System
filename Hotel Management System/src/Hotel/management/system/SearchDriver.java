package Hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class SearchDriver extends JFrame implements ActionListener {

	JTable table;
	JButton back, submit;
	Choice carTypeList;
	JCheckBox available;

	SearchDriver() {
		setLayout(null);
		setBounds(300, 200, 1000, 600);
		getContentPane().setBackground(Color.WHITE);

		JLabel heading = new JLabel("Pickup Service");
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		heading.setBounds(400, 40, 200, 30);
		add(heading);

		JLabel carType = new JLabel("Car Type");
		carType.setBounds(50, 100, 100, 20);
		add(carType);
		
		carTypeList = new Choice();
		carTypeList.setBounds(150, 100, 200, 25);
		add(carTypeList);
		
		try {
			MyConnection connection = new MyConnection();
			String query = "select * from driver";
			ResultSet res = connection.statement.executeQuery(query);
			
			while(res.next()) {
				carTypeList.add(res.getString("brand"));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

		JLabel name = new JLabel("Name");
		name.setBounds(60, 170, 100, 20);
		add(name);

		JLabel age = new JLabel("Age");
		age.setBounds(210, 170, 100, 20);
		add(age);

		JLabel gender = new JLabel("Gender");
		gender.setBounds(340, 170, 100, 20);
		add(gender);

		JLabel company = new JLabel("Company");
		company.setBounds(470, 170, 100, 20);
		add(company);

		JLabel brand = new JLabel("Brand");
		brand.setBounds(620, 170, 100, 20);
		add(brand);
		
		JLabel availability = new JLabel("Availability");
		availability.setBounds(750, 170, 100, 20);
		add(availability);
		
		JLabel location = new JLabel("Location");
		location.setBounds(890, 170, 100, 20);
		add(location);

		table = new JTable();
		table.setBounds(0, 200, 1000, 300);
		add(table);

		try {
			MyConnection connection = new MyConnection();
			String query = "select * from driver";
			ResultSet res = connection.statement.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(res));
		} catch (Exception e) {
			System.out.println(e);
		}

		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setBounds(300, 500, 120, 30);
		add(submit);

		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(500, 500, 120, 30);
		add(back);

		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			try {
				MyConnection connection = new MyConnection();
				String query = "select * from driver where brand='" + carTypeList.getSelectedItem() + "'";
				ResultSet res = connection.statement.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(res));
			} catch (Exception e1) {
				System.out.println(e1);
			}

		} else {
			setVisible(false);
			new Reception().setVisible(true);
		}
	}

	public static void main(String[] args) {

		new SearchDriver();
	}
}