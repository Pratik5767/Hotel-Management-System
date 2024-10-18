package Hotel.management.system;

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

public class SearchRoom extends JFrame implements ActionListener {

	JTable table;
	JButton back, submit;
	JComboBox<String> bedTypeList;
	JCheckBox available;

	SearchRoom() {
		setLayout(null);
		setBounds(300, 200, 1000, 600);
		getContentPane().setBackground(Color.WHITE);

		JLabel heading = new JLabel("Search for Room");
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		heading.setBounds(400, 40, 200, 30);
		add(heading);

		JLabel bedType = new JLabel("Bed Type");
		bedType.setBounds(50, 100, 100, 20);
		add(bedType);

		bedTypeList = new JComboBox<String>(new String[] { "Single Bed", "Double Bed" });
		bedTypeList.setBounds(150, 100, 150, 25);
		bedTypeList.setBackground(Color.WHITE);
		add(bedTypeList);

		available = new JCheckBox("Only Display available");
		available.setBounds(650, 100, 150, 25);
		available.setBackground(Color.WHITE);
		add(available);

		JLabel roomHeader = new JLabel("Room Number");
		roomHeader.setBounds(60, 170, 100, 20);
		add(roomHeader);

		JLabel avaliabilityHeader = new JLabel("Avaliability");
		avaliabilityHeader.setBounds(260, 170, 100, 20);
		add(avaliabilityHeader);

		JLabel statusHeader = new JLabel("Status");
		statusHeader.setBounds(480, 170, 100, 20);
		add(statusHeader);

		JLabel priceHeader = new JLabel("Price");
		priceHeader.setBounds(680, 170, 100, 20);
		add(priceHeader);

		JLabel bedtypeHeader = new JLabel("Bed Type");
		bedtypeHeader.setBounds(880, 170, 100, 20);
		add(bedtypeHeader);

		table = new JTable();
		table.setBounds(0, 200, 1000, 300);
		add(table);

		try {
			MyConnection connection = new MyConnection();
			String query = "select * from rooms";
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			try {
				MyConnection connection = new MyConnection();
				String query1 = "select * from rooms where bedType='" + bedTypeList.getSelectedItem() + "'";
				String query2 = "select * from rooms where availableRoom='Available' AND bedType='"
						+ bedTypeList.getSelectedItem() + "'";
				
				ResultSet res;
				if(available.isSelected()) {
					res = connection.statement.executeQuery(query2);
				} else {
					res = connection.statement.executeQuery(query1);
				}
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

		new SearchRoom();

	}
}
