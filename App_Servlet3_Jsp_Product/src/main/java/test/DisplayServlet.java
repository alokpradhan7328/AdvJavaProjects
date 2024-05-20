package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/dis")
public class DisplayServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		RequestDispatcher rd = req.getRequestDispatcher("Display.jsp");
		rd.forward(req, res);
	}

}
