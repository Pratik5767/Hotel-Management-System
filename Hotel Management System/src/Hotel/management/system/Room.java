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

public class Room extends JFrame implements ActionListener { 
	
	JTable table;
	JButton back;

	Room() {
		setLayout(null);
		setBounds(300, 200, 1050, 600);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("./icons/eight.jpg"));
		Image scaleImg = img.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon newImg = new ImageIcon(scaleImg);
		JLabel image = new JLabel(newImg);
		image.setBounds(550, 0, 600, 600);
		add(image);
		
		JLabel roomHeader = new JLabel("Room Number");
		roomHeader.setBounds(10, 15, 100, 20);
		add(roomHeader);
		
		JLabel avaliabilityHeader = new JLabel("Avaliability");
		avaliabilityHeader.setBounds(120, 15, 100, 20);
		add(avaliabilityHeader);
		
		JLabel statusHeader = new JLabel("Status");
		statusHeader.setBounds(230, 15, 100, 20);
		add(statusHeader);
		
		JLabel priceHeader = new JLabel("Price");
		priceHeader.setBounds(340, 15, 100, 20);
		add(priceHeader);
		
		JLabel bedtypeHeader = new JLabel("Bed Type");
		bedtypeHeader.setBounds(440, 15, 100, 20);
		add(bedtypeHeader);
		
		
		table = new JTable();
		table.setBounds(0, 40, 500, 400);
		add(table);
		
		try {
			MyConnection connection = new MyConnection();
			String query = "select * from rooms";
			ResultSet res = connection.statement.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(res));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		back.setBounds(200, 500, 120, 30);
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
		
		new Room();
	}

}
