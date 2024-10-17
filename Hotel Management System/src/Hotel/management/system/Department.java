package Hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener { 
	
	JTable table;
	JButton back;

	Department() {
		setLayout(null);
		setBounds(400, 200, 700, 480);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel departmentHeader = new JLabel("Department");
		departmentHeader.setBounds(100, 15, 100, 20);
		add(departmentHeader);
		
		JLabel buggetHeader = new JLabel("Bugget");
		buggetHeader.setBounds(350, 15, 100, 20);
		add(buggetHeader);
		
		table = new JTable();
		table.setBounds(0, 40, 700, 300);
		add(table);
		
		try {
			MyConnection connection = new MyConnection();
			String query = "select * from department";
			ResultSet res = connection.statement.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(res));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(280, 400, 120, 30);
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
		
		new Department();
	}

}
