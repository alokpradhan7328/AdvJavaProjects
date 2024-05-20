package test;
import java.util.*;
import java.sql.*;

public class DBCon5 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;){
			try {
				System.out.println("Enter the Cust-Id:");
				int id = s.nextInt();
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ALOKDB","ALOKDB");
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery("select * from customer61 where id ="+id);
				System.out.println(rs.next()?rs.getInt(1)+"\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getLong(5):"Invalid CustId");
				
				con.close();
				
			}//end of try
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}//end with resources
	}

}
