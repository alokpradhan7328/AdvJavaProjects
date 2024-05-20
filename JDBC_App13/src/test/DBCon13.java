package test;
import java.sql.Connection;
import java.util.*;
import java.sql.*;


public class DBCon13 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;)
		{
			try
			{
				System.out.println("ENter the Accno to Disply Phno... ");
				long acno = s.nextLong();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","alokdb","ALOKDB");
				CallableStatement cs= con.prepareCall("{call ?:= RETRIVEPHNO61(?)}");
				cs.registerOutParameter(1, Types.BIGINT);
				cs.setLong(2, acno);
				cs.execute();//executing the Callable Statement
				System.out.println("------------Details------------");
				System.out.println("ACCNo: "+acno);
				System.out.println("PhoneNO: "+cs.getLong(1));
				con.close();
			}//end of the try
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}//end with resources

	}

}
