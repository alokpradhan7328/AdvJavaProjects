package test;
import java.sql.DriverManager;
import java.util.*;
import java.sql.*;

public class DBCon12 
{

	public static void main(String[] args) 
	{
		Scanner s= new Scanner(System.in);
		try(s;)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ALOKDB","ALOKDB");
				CallableStatement cs= con.prepareCall("{call RETRIVECUSTOMER61(?,?,?,?,?,?,?,?,?)}");
				
				System.out.println("Enetr the Account NUmber: ");
				long acno = Long.parseLong(s.nextLine());
				//insert data into CallableStatement
				cs.setLong(1, acno);
				cs.registerOutParameter(2,Types.VARCHAR);
				cs.registerOutParameter(3,Types.FLOAT);
				cs.registerOutParameter(4,Types.VARCHAR);
				cs.registerOutParameter(5,Types.VARCHAR);
				cs.registerOutParameter(6, Types.VARCHAR);
				cs.registerOutParameter(7, Types.INTEGER);
				cs.registerOutParameter(8, Types.VARCHAR);	
				cs.registerOutParameter(9, Types.BIGINT);
				
				cs.execute();//procedure execute
				System.out.println("******Customer Details******");
				System.out.println("AccNo:"+acno);
				System.out.println("Name:"+cs.getString(2));
				System.out.println("Balanceot:"+cs.getFloat(3));
				System.out.println("AccTypeot:"+cs.getString(4));
				System.out.println("City:"+cs.getString(5));
				System.out.println("State:"+cs.getString(6));
				System.out.println("PinCodeot:"+cs.getLong(7));
				System.out.println("MailId:"+cs.getString(8));
				System.out.println("PhoneNoot:"+cs.getLong(9));
			}//end of the try block
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}//end with resources
		
	}

}
