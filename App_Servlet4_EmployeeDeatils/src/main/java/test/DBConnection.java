package test;

import java.sql.*;

public class DBConnection {

	private static Connection con = null;
	static 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(DBInfo.dbUrl,DBInfo.uName,DBInfo.pWord);
			
		}//end of the try
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}//end of the block
	
	public static Connection getCon()
	{
		return con;
	}
}
