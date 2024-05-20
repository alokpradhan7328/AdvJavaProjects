package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet("/log")
public class LoginServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String un = req.getParameter("uname");
		String pw = req.getParameter("pword");
		UserBean ub = new LoginDAO().login(un, pw);
		if(ub == null)
		{
			req.setAttribute("msg", "Invalid Data....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			ServletContext sct = req.getServletContext();//Accessing ServletContext obj reference
			sct.setAttribute("ubean", ub);//Adding UserBean Obj to ServletContext 
			
			Cookie ck = new Cookie("fname",ub.getfName());//Cookie Creation
			res.addCookie(ck);//Adding Cookie to response
			req.getRequestDispatcher("Login.jsp").forward(req, res);
		}
	}
}
