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
			//// 1. Connect with DB 
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_name", "user", "password");
			//// 2. Create Statement
			Statement statement = connection.createStatement();
			//// 3. Execute Statement
			ResultSet result = statement.executeQuery("SHOW TABLES");
			
			//// 4. Iterate the Result
			while(result.next()) {
				System.out.println(result.getString(1));
			}
			
			//// 5. Close the Connection
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
