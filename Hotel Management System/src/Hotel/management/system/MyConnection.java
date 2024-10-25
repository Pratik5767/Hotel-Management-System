package Hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MyConnection {

	Connection connection;
	Statement statement;

	MyConnection() {
		try {
			// Register the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Creating Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root",
					"Enter your database name");
			//Creating the statements
			statement = connection.createStatement();
			//Executing MySQL queries
			//Closing connection
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
