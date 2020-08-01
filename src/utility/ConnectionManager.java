package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		Properties prop = null;
		try {
			prop = loadPropertiesFile();
		} 
		catch (Exception e) {
			e.getMessage();
		}
		Class.forName(prop.getProperty("driver"));
		
		Connection con = null;
		con =DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
		
		return con;
		
	}
	

	private static Properties loadPropertiesFile() throws IOException {
		// TODO Auto-generated method stub
		
		Properties p = new Properties();
		//getting all the jdbc property
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties"); 
		p.load(in);
		in.close();
		return p;
		}
}
