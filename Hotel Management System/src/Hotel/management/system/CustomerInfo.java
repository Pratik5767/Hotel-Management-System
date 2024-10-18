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

public class CustomerInfo extends JFrame implements ActionListener { 
	
	JTable table;
	JButton back;

	CustomerInfo() {
		setLayout(null);
		setBounds(300, 200, 1000, 600);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel document = new JLabel("Document Type");
		document.setBounds(10, 15, 100, 20);
		add(document);
		
		JLabel number = new JLabel("Number");
		number.setBounds(160, 15, 100, 20);
		add(number);
		
		JLabel name = new JLabel("Name");
		name.setBounds(280, 15, 100, 20);
		add(name);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(410, 15, 100, 20);
		add(gender);
		
		JLabel country = new JLabel("Country");
		country.setBounds(540, 15, 100, 20);
		add(country);
		
		JLabel roomNo = new JLabel("Room number");
		roomNo.setBounds(650, 15, 100, 20);
		add(roomNo);
		
		JLabel checkin = new JLabel("Checkin Time");
		checkin.setBounds(790, 15, 100, 20);
		add(checkin);
		
		JLabel deposit = new JLabel("Deposit");
		deposit.setBounds(910, 15, 100, 20);
		add(deposit);
		
		table = new JTable();
		table.setBounds(0, 40, 1000, 400);
		add(table);
		
		try {
			MyConnection connection = new MyConnection();
			String query = "select * from customer";
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Reception().setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new CustomerInfo();
	}

}
