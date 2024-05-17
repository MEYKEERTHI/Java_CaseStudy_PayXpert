package Com.java.Util;


import java.sql.*;

public class DBConnUtil {
private static Connection con=null;
	
	private DBConnUtil()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payexpert", "root", "root");
	         
	         System.out.println("Connected to the database");
			
		}
		catch(Exception e)
		{
			System.out.println("Connected to the Database");
		}
	}
	
	public static Connection getConnect()
	{
		DBConnUtil d1=new DBConnUtil();
		return con;
	}
}

