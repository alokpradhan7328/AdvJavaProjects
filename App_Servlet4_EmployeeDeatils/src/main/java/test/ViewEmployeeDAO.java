package test;
import java.sql.*;
import java.util.*;
public class ViewEmployeeDAO 
{
	public ArrayList<EmployeeBean> al = new ArrayList<EmployeeBean>();
	public ArrayList<EmployeeBean> retrive()
	{
		try
		{
			Connection con =DBConnection.getCon();//adding existing connection
			PreparedStatement ps = con.prepareStatement("select * from Employee61");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EmployeeBean eb = new EmployeeBean();
				//addin the values into EmployeeBean obj
				eb.seteId(rs.getString(1));
				eb.seteName(rs.getString(2));
				eb.seteDesg(rs.getString(3));
				eb.setbSal(rs.getFloat(4));
				eb.setHra(rs.getFloat(5));
				eb.setDa(rs.getFloat(6));
				eb.setTotSal(rs.getFloat(7));
				al.add(eb);//add  bean obj to al
				
			}//end of the loop
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
