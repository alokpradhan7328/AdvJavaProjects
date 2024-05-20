package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class DBCon9 {

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		try(s;){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ALOKDB","ALOKDB");
				
				PreparedStatement ps1 = con.prepareStatement("insert into Employee61 values(?,?,?,?,?,?,?)");
				PreparedStatement ps2 = con.prepareStatement("select * from Employee61");
				PreparedStatement ps3 = con.prepareStatement("select * from Employee61 where eid=?");
				PreparedStatement ps4 = con.prepareStatement("update table Employee61 set bSal=?,hra=?,da=?,total=? where eid=?");
				PreparedStatement ps5 = con.prepareStatement("delete from Employee61 where eid=?");
				
				while(true) {
					System.out.println("*******Menu********");
					System.out.println("\t1.AddEmployee"+"\n\t2.ViewAllEmployee"
					+"\n\t3.ViewEmployee by id"+"\n\t4.Update Employee By Id(bsal,hra,da,total)"+
					"\n\t5.DeleteEmployee"+"\n\t6.Exit");
					System.out.println("Enter a Choice...");
					int choice=s.nextInt();
					switch(choice)
					{
					case 1:
						s.nextLine();
						System.out.println("Enter Emp-Id:");
						String id= s.nextLine();
						System.out.println("Enter Emp-Name:");
						String name= s.nextLine();
						System.out.println("Enter Emp-Desg:");
						String desg= s.nextLine();
						System.out.println("Enter Emp-bSal:");
						float bSal= Float.parseFloat(s.nextLine());
						
						float hra =bSal*(91.0f/100);
						float da= bSal*(63.0f/100);
						float total= bSal+hra+da;
						
						//Loading values into PrearedStatements
						ps1.setString(1, id);
						ps1.setString(2, name);
						ps1.setString(3, desg);
						ps1.setFloat(4, bSal);
						ps1.setFloat(5, hra);
						ps1.setFloat(6, da);
						ps1.setFloat(7, total);
						
						int k=ps1.executeUpdate();
						if(k>0)
							System.out.println("Data Added Successfully....");
						
						break;
					case 2:
						ResultSet rs = ps2.executeQuery();
						while(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"
									+rs.getString(3)+"\t"+rs.getFloat(4)
									+"\t"+rs.getFloat(5)+"\t"+rs.getFloat(6)+"\t"+rs.getFloat(7));
						}
						break;
					case 3:
						s.nextLine();
						System.out.println("Enter Emp-Id");
						String id2=s.nextLine();
						ps3.setString(1, id2);
						ResultSet rs2= ps3.executeQuery();
						if(rs2.next())
							System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"
									+rs2.getString(3)+"\t"+rs2.getFloat(4)
									+"\t"+rs2.getFloat(5)+"\t"+rs2.getFloat(6)+"\t"+rs2.getFloat(7));
						else
							System.out.println("Invalid Emp-Id");
						
						break;
					case 4:
						System.out.println("Enter the Emp- Id to Update(bSal,hra,da,total)");
						String id3=s.nextLine();
						
						ps3.setString(1, id3);
						ResultSet rs3=ps3.executeQuery();
						if(rs3.next())
						{
							System.out.println("Employee Old Salary: "+rs3.getFloat(4));
							System.out.println("Enter New Salary: ");
							float nSal= Float.parseFloat(s.nextLine());
							
							float nhra =nSal*(91.0f/100);
							float nda= nSal*(63.0f/100);
							float ntotal= nSal+nhra+nda;
							
							ps4.setFloat(1, nSal);
							ps4.setFloat(2, nhra);
							ps4.setFloat(3, nda);
							ps4.setFloat(4, ntotal);
							ps4.setString(5, id3);
							
							int k1 = ps4.executeUpdate();
							if(k1>0)
								System.out.println("Data Updated Successfully...");
							else
								System.out.println("Something  Error...");
						}
						
						break;
					case 5:
						s.nextLine();
						System.out.println("Enter Emp-Id to Delete From Table");
						String id4=s.nextLine();
						ps3.setString(1, id4);
						//ResultSet rs4= ps3.executeQuery();
						ps5.setString(1, id4);
						int k4=ps5.executeUpdate();
						System.out.println(k4>0?"Data deleted succesfully..":"Invalid Emp-Id");
						break;
					case 6:
						System.out.println("Operation Stopped....");
						System.exit(0);
					default:
						System.out.println("Invalid Choice...");
					}
					
					
				}
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
		}
	}
}
