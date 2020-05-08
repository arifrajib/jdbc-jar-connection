package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		
		try {
			//// Connect with DB 
			connection = DriverManager.getConnection("jdbc:mysql://192.168.0.21:3306/consumer_report", "root", "root");
			//// Create Statement
			Statement statement = connection.createStatement();
			//// Execute Statement
			ResultSet result = statement.executeQuery("SHOW TABLES");
			
			//// Iterate the Result
			while(result.next()) {
				System.out.println(result.getString(1));
			}
			
			//// Close the Connection
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}

	}

}
