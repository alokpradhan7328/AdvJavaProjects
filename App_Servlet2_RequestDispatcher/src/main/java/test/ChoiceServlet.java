package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/test")
public class ChoiceServlet extends HttpServlet 
{
	{
		System.out.println("hello");
	}
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		String s1 = req.getParameter("s1");
		System.out.println(s1);
		switch(s1)
		{
		case "Add":
			RequestDispatcher rd = req.getRequestDispatcher("ad");
			rd.forward(req, res);
			break;
		case "Avg":
			RequestDispatcher rd1 = req.getRequestDispatcher("av");
			rd1.forward(req, res);
			break;
		case "Sub":
			RequestDispatcher rd2 = req.getRequestDispatcher("sub");
			rd2.forward(req, res);
			break;
		case "Mul":
			RequestDispatcher rd3 = req.getRequestDispatcher("mul");
			rd3.forward(req, res);
			break;
			
		default :
			RequestDispatcher rdn = req.getRequestDispatcher("input.html");
			rdn.forward(req, res);
				
			
			
		}
	}
}
