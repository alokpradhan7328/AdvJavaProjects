package test;

import java.sql.*;

public class LoginDAO 
{
	public UserBean ub = null;
	public UserBean login(String un,String pw)
	{
		try 
		{
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from UserReg61 where 			UNAME=? AND PWORD=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				ub = new UserBean();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhNo(rs.getLong(7));
			}
			
		}//end of try
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ub;
	}
}
