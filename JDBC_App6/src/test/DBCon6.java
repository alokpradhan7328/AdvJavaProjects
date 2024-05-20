package test;
import java.util.*;
import java.net.Inet4Address;
import java.sql.*;

public class DBCon6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;)
		{
			try
			{
				while(true)
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ALOKDB","ALOKDB");
					Statement stm = con.createStatement();
					System.out.println("----MENU----");
					System.out.println("\t1.AddProduct"+"\n\t2.ViewProduct"+"\n\t3.ViewProductByCode"+"\n\t4.Exit");
					System.out.println("Enter the Choice:.");
					
					switch(Integer.parseInt(s.nextLine()))
					{
					case 1:
						System.out.println("Enter Product-Code:");
						int pcode = Integer.parseInt(s.nextLine());
						System.out.println("Enter Product-Name:");
						String pname = s.nextLine();
						System.out.println("Enter Product-Price");
						float price = Float.parseFloat(s.nextLine());
						System.out.println("Enter Product-Qty");
						int qty = Integer.parseInt(s.nextLine());
						int k = stm.executeUpdate("insert into PRODUCT61 values("+pcode+",'"+pname+"',"+price+","+qty+") ");
						System.out.println(k>0?"Data Added Successfully":"Data not added..");
						break;
					case 2:
						ResultSet rs = stm.executeQuery("select * from PRODUCT61");
						while(rs.next())
						{
							System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
						}
						break;
					case 3:
						System.out.println("Enter the Product-Code:");
						int code =Integer.parseInt(s.nextLine());
						ResultSet rs1 =stm.executeQuery("select * from PRODUCT61 where pcode="+code);
						System.out.println(rs1.next()?rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getFloat(3)+"\t"+rs1.getInt(4):"Invalid PCode");
						break;
					case 4:
						System.out.println("Operation Stopped....");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Input..");
					}//end of switch
					con.close();
				}//end of the loop
			}//end of try

			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}//end with resources
		
	}

}
