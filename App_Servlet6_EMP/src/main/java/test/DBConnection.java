package test;
import java.sql.*;
public class DBConnection 
{
	private static Connection con=null;
	static
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con =DriverManager.getConnection(DBInfo.dbUrl, DBInfo.uName, DBInfo.pWord);		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}//end of the block
	public static Connection getCon()
	{
		return con;
	}
}
