package test;
import java.sql.*;

public class DBCon1
{

	public static void main(String[] args)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ALOKDB", "ALOKDB");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from customer61");
				System.out.println("\t\t-----Table's Data-----\n");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+"\t"+rs.getLong(5));
				}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}

	}

}
