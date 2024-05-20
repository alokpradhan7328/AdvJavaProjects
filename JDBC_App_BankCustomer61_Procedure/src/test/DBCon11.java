package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DBCon11 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Alokdb","ALOKDB");
				CallableStatement cs = con.prepareCall("{call BANKCUSTOMER61(?,?,?,?,?,?,?,?,?)}");
				
				System.out.println("Enter the Accoun Number: ");
				long acno=Long.parseLong(s.nextLine());
				System.out.println("Enter the Name: ");
				String name = s.nextLine();
				System.out.println("Enter the Balance: ");
				float bal = Float.parseFloat(s.nextLine());
				System.out.println("Enter the Atype: ");
				String atype = s.nextLine();
				System.out.println("Enter the City: ");
				String city = s.nextLine();
				System.out.println("Enter the State: ");
				String state = s.nextLine();
				System.out.println("Enter the PinCode: ");
				int pcode = Integer.parseInt(s.nextLine());
				System.out.println("Enter the MailID: ");
				String mid = s.nextLine();
				System.out.println("Enter the PhNo: ");
				long phno= Long.parseLong(s.nextLine());
				
				//LOADIG DATA INTO CALLABLESTATEMENT
				cs.setLong(1, acno);
				cs.setString(2, name);
				cs.setFloat(3, bal);
				cs.setString(4, atype);
				cs.setString(5, city);
				cs.setString(6, state);
				cs.setInt(7, pcode);
				cs.setString(8, mid);
				cs.setLong(9, phno);
				
				cs.execute();//procedure Executed
				System.out.println("Customer Details Added Succesfully");
				con.close();
				
			}//end of the try block
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}//end with resources
		
		
		}
}
