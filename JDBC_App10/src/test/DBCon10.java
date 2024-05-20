package test;
import java.util.*;
import java.sql.*;

public class DBCon10 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","alokdb","ALOKDB");
				Statement stm = con.createStatement();
				
				PreparedStatement ps1 = con.prepareStatement("insert into Customer61 values(?,?,?,?,?)");
				
				PreparedStatement ps2 = con.prepareStatement("select * from Customer61 where id =?");
				
				PreparedStatement ps3= con.prepareStatement("update Customer61 set city=?,phno=? where id =?");
				
				PreparedStatement ps4 =con.prepareStatement("delete from Customer61 where id=?");
				
				while(true) {
					System.out.println("\t*****MENU*****");
					System.out.println("\t1.Add Customer Details."+"\n\t2.View All Customer"+"\n\t3.View Customer's Details By Id"
							+"\n\t4.Update Customer Details (City,MobNo)"+"\n\t5.Delete Customer' Details"+"\n\t6.Exit");
					System.out.println("Enter the Choice..");
					int choice= Integer.parseInt(s.nextLine());
					switch(choice) {
					case 1:
						System.out.println("Enter the Cust-id");
						int id = Integer.parseInt(s.nextLine());
						System.out.println("Enter the Cust-Name");
						String name = s.nextLine();
						System.out.println("Enter the Cust-City");
						String city = s.nextLine();
						System.out.println("Enter the Cust-Mid");
						String mid = s.nextLine();
						System.out.println("Enter the Cust-Phno");
						long phno=Long.parseLong(s.nextLine());
						
						//loading data into Prepared Statement Objects
						ps1.setInt(1, id);
						ps1.setString(2, name);
						ps1.setString(3, city);
						ps1.setString(4, mid);
						ps1.setLong(5, phno);
						
						int k1= ps1.executeUpdate();
						if(k1>0)
							System.out.println("Data Added Successfully...");
						break;
					case 2:
						ResultSet rs = stm.executeQuery("select * from Customer61");
						while(rs.next()) {
							System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getLong(5));
						}
						break;
					case 3:
						System.out.println("Enter Cust-Id To Retrive the data..");
						int id2=Integer.parseInt(s.nextLine());
						ps2.setInt(1, id2);
						ResultSet rs2=ps2.executeQuery();
						if(rs2.next())
							System.out.println(rs2.getInt(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getString(4)+"\t"+rs2.getLong(5));
						else
							System.out.println("Invalid Cust-Id....");
						break;
					case 4:
						System.out.println("Enter Cust-Id To Update the data..");
						int id3=Integer.parseInt(s.nextLine());
						ps2.setInt(1, id3);
						ResultSet rs3= ps2.executeQuery();
						if(rs3.next()) {
							System.out.println("Old City Name: "+rs3.getString(3));
							System.out.println("Enter New City: ");
							String city1=s.nextLine();
							System.out.println("Old PhNo: "+rs3.getLong(5));
							System.out.println("Enter new MobileNo:");
							long phno2=Long.parseLong(s.nextLine());
							
							ps3.setString(1, city1);
							ps3.setLong(2, phno2);
							ps3.setInt(3, id3);
							
							int k3= ps3.executeUpdate();
							System.out.println(k3>0?"Data Updaed Successfully":"invalid Cust-Id");
						}
						break;
					case 5:
						System.out.println("Enter Cust-Id To Delete the data..");
						int id4=Integer.parseInt(s.nextLine());
						//ps2.setInt(1, id4);
						ps4.setInt(1, id4);
						int k4=ps4.executeUpdate();
						System.out.println(k4>0?"Data Deleted Successfully":"invalid Cust-Id");
						break;
					case 6:
						System.out.println("Operation Stopped.....");
						System.exit(0);
					default:
							System.out.println("Invalid Choice");
					}
				}
				
			}//end of the try
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
			
		}//end of resources
		
	}
}
