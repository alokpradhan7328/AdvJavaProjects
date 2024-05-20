package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/div")
public class Diivision extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		int v1 = Integer.parseInt(req.getParameter("v1"));
		int v2 = Integer.parseInt(req.getParameter("v2"));
		int v3 = v1/v2;
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		pw.println("Division:"+v3+"<br>");
		RequestDispatcher rd = req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}
}
