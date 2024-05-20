package test;
import java.util.*;
import java.sql.*;

public class DBCon7 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;){
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ALOKDB","ALOKDB");
				
				PreparedStatement ps1 = con.prepareStatement("insert into BookDetails61 values(?,?,?,?,?)");
				
				PreparedStatement ps2 = con.prepareStatement("select * from Bookdetails61 ");
				
				PreparedStatement ps3 = con.prepareStatement("Select *from BookDetails61 where code =?");
				
				PreparedStatement ps4 = con.prepareStatement("update BookDetails61 set Price=?,Qty=Qty+?  where code =?");
				
				PreparedStatement ps5 = con.prepareStatement("delete from BookDetails61 where code =?");
				while(true)
				{
					System.out.println("\t*****MENU****");
					System.out.println("\t1.AddBookDetails"+
					"\n\t2.ViewBookDetails"+"\n\t3.ViewBookDetailsByCode"+
					"\n\t4.UpdateBook(Price-Qty)"+"\n\t5.DeleteBookDetails"+
					"\n\t6.Exit");
					System.out.println("\nEnter Your Choice..");
					switch(Integer.parseInt(s.nextLine()))
					{
					case 1:
						System.out.println("Enter Book_Code");
						String bCode = s.nextLine();
						System.out.println("Enter Book_Name");
						String bName = s.nextLine();
						System.out.println("Enter Book_Author");
						String bAuthor = s.nextLine();
						System.out.println("Enter Book_Price");
						float bPrice = Float.parseFloat(s.nextLine());
						System.out.println("Enter Book_Qty");
						int bQty = Integer.parseInt(s.nextLine());
						
						ps1.setString(1,bCode);
						ps1.setString(2,bName);
						ps1.setString(3,bAuthor);
						ps1.setFloat(4,bPrice);
						ps1.setInt(5,bQty);
						
						int k = ps1.executeUpdate();
						System.out.println(k>0?"Book DetailsEntered SuccessFullly":"Invalid BookDetails");
						break;
					case 2:
						System.out.println("\t----BookDetails-----");
						ResultSet rs= ps2.executeQuery();
						while(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+
									rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
						}
						break;
					case 3:
						System.out.println("Enter the Book_Code:");
						String code = s.nextLine();
						
						ps3.setString(1, code);
						
						ResultSet rs1 = ps3.executeQuery();
						System.out.println(rs1.next()?rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+
									rs1.getString(3)+"\t"+rs1.getFloat(4)+"\t"+rs1.getInt(5):"Invalid Book-Code");
						
						break;
					case 4:
						System.out.println("Enter the Book COde to Update Price & Qty");
						String bc2= s.nextLine();
							
						ps3.setString(1, bc2);//loading into prepared stmmnt
						 ResultSet rs3= ps3.executeQuery();
						 if(rs3.next())
						 {
							 System.out.println("Old Book Price: "+rs3.getFloat(4));
							 System.out.println("Enter new Book Price:");
							 float nprice = Float.parseFloat(s.nextLine());
							 System.out.println("Existing Book Stocks:"+rs3.getInt(5));
							 System.out.println("Enter New Stock:");
							 int nQty= Integer.parseInt(s.nextLine());
							 
							 ps4.setFloat(1, nprice);
							 ps4.setInt(2, nQty);
							 ps4.setString(3, bc2);
							 int k2=ps4.executeUpdate();
							 if(k2>0) {
								 System.out.println("Data Added SuccessFully....");
							 }
						 }
						 else {
							 System.out.println("Invalid COde.....");
						 }
						
						break;
					case 5:
						System.out.println("Enter The Book-Code to Delete");
						String bc3= s.nextLine();
						ps3.setString(1,bc3);
						ResultSet rs4= ps3.executeQuery();
						ps5.setString(1, bc3);
						 if(rs4.next())
						 {
							 int k3= ps5.executeUpdate();
							 System.out.println(k3>0?"Book deleted Successfully":"Invalid Code");
						 }
						break;
					case 6:
						System.out.println("Opeartion Stopped....");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Input");
						break;
					}	
				}
			}//end of the try
			catch(Exception e) {
				System.out.println(e.toString());
			}
		}//end with resources
	}
}
