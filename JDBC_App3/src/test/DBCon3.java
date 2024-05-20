package test;
import java.util.*;
import java.sql.*;

public class DBCon3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		try(s;){
			try {
				System.out.println("Enter Book-Code:");
				int bcode = Integer.parseInt(s.nextLine());
				System.out.println("Enter Book-Name:");
				String bname = s.nextLine();
				System.out.println("Enter Book -Author:");
				String bauthor =  s.nextLine();
				System.out.println("Enter Book-Price:");
				float bprice = s.nextFloat();
				System.out.println("Enter Book-Qty:");
				int bqty = s.nextInt();
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ALOKDB","ALOKDB");
				Statement stm = con.createStatement();
				String query = "Insert into BOOKDETAILS61 VALUES("+bcode+",'"+bname+"','"+bauthor+"','"+bprice+"',"+bqty+")";
				int k = stm.executeUpdate(query);
				
				if(k>0) {
					System.out.println("\t BookDetails Data Entered SuccessFully.....");
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
