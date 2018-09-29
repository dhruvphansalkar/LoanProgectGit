package com.cg.lms.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	static String driver = null;
	static String url = null;
	static String unm = null;
	static String pwd = null;
	public static Connection getConn() throws SQLException, IOException, ClassNotFoundException
	{
		Properties myProps= loadDBInfo();
		driver = myProps.getProperty("Driver");
		url = myProps.getProperty("Url");
		unm = myProps.getProperty("User");
		pwd = myProps.getProperty("Password");
		
		Connection con=null;
		if(con==null)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,unm,pwd);
			
			return con;
		}
		else
		{
			return con;
		}
	}
	
	public static Properties loadDBInfo() throws IOException
	{
		
			FileReader fr = new FileReader("DbInfo.properties");
			Properties dbProps = new Properties();
			dbProps.load(fr);
			return dbProps;
		
	}

}
