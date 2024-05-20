package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		//Bean Object
		UserBean ub = new UserBean();
		//loading the value from req obj to bean obj
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setmId(req.getParameter("mid"));
		ub.setPhNo(Long.parseLong(req.getParameter("phno")));
		
		
		int k = new RegisterDAO().register(ub);
		System.out.println(k);
		if(k>0)
		{
			req.getRequestDispatcher("Register.jsp").forward(req, res);		
		}
	}
}
