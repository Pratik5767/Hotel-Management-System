package Hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener { 
	
	JTable table;
	JButton back;

	EmployeeInfo() {
		setLayout(null);
		setBounds(300, 200, 1000, 600);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel name = new JLabel("Name");
		name.setBounds(40, 10, 100, 20);
		add(name);
		
		JLabel age = new JLabel("Age");
		age.setBounds(170, 15, 100, 20);
		add(age);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(290, 15, 100, 20);
		add(gender);
		
		JLabel job = new JLabel("Job");
		job.setBounds(410, 15, 100, 20);
		add(job);
		
		JLabel salary = new JLabel("Salary");
		salary.setBounds(540, 15, 100, 20);
		add(salary);
		
		JLabel phone = new JLabel("Phone");
		phone.setBounds(660, 15, 100, 20);
		add(phone);
		
		JLabel email = new JLabel("email");
		email.setBounds(790, 15, 100, 20);
		add(email);
		
		JLabel aadhaar = new JLabel("Aadhaar");
		aadhaar.setBounds(910, 15, 100, 20);
		add(aadhaar);
		
		table = new JTable();
		table.setBounds(0, 40, 1000, 400);
		add(table);
		
		try {
			MyConnection connection = new MyConnection();
			String query = "select * from employee";
			ResultSet res = connection.statement.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(res));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(420, 500, 120, 30);
		add(back);
		
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Reception().setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new EmployeeInfo();
	}

}
