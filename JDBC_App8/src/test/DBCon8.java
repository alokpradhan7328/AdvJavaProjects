package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBCon8 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ALOKDB","ALOKDB");
				Statement stm = con.createStatement();
				System.out.println("****MENU*****");
				System.out.println("\t1.Non-Select Query(Create/Update/insert/delete)\n\t2.Select-Query");
				System.out.println("Enter Your Choice....");
				switch(Integer.parseInt(s.nextLine()))
				{
				case 1:
					System.out.println("Enter the Non-Select Query.");
					String qr = s.nextLine();
					int p = stm.executeUpdate(qr);
					System.out.println(p);
					System.out.println(p>=0?"Table Craeted Successfully":"Somethiong Error");
					break;
				case 2:
					System.out.println("Enter the Select Query");
					String qr2= s.nextLine();
					ResultSet rs=stm.executeQuery(qr2);
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
					}
					break;
					default:
						System.out.println("Invalid Choice......");
				}
			}//end of the try
			catch(Exception e)  
			{
				System.out.println(e.toString());
			}
		}//end with resources
				

	}

}
