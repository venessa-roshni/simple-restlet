package DBConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
	public Connection getConnection() {
		Properties props = new Properties();
		FileInputStream file = null;
		Connection con = null;
		try {
			//file = new FileInputStream("db.properties");
			
			props.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));

			// load the Driver Class
			Class.forName(props.getProperty("jdbc.driver"));

			// create the connection now
			con = DriverManager.getConnection(props.getProperty("jdbc.url"),
					props.getProperty("jdbc.username"),
					props.getProperty("jdbc.password"));

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
