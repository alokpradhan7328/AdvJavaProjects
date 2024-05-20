package test;
import java.util.*;
import java.sql.*;
public class DBCon2 {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
			try(s;){
				try {
					
					System.out.println("Enter the Cust-Id: ");
					int id = Integer.parseInt(s.nextLine());
					System.out.println("Enter the Cust-Name: ");
					String name = s.nextLine();
					System.out.println("Enter the Cust-City: ");
					String city = s.nextLine();
					System.out.println("Enter the Cust-MailId: ");
					String mid = s.nextLine();
					System.out.println("Enter the Cust-phNo: ");
					long phno = s.nextLong();
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ALOKDB", "ALOKDB");
					Statement stm = con.createStatement();
					int k = stm.executeUpdate("insert into CUSTOMER61 values("+id+",'"+name+"','"+city+"','"+mid+"',"+phno+")");
					if(k>0) {
						System.out.println("Customer61 Data added Successfully.....");
					}
					con.close();
			}
				catch(Exception e)
				{
					System.out.println(e.toString());
				}
			}
	}

}
