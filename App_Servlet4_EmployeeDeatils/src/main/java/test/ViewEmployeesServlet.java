package test;
import java.io.*;
import java.util.ArrayList;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewEmployeesServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		ViewEmployeeDAO ved = new ViewEmployeeDAO();
		ArrayList<EmployeeBean> al=ved.retrive();
		req.setAttribute("alist", al);
		RequestDispatcher rd = req.getRequestDispatcher("ViewEmployees.jsp");
		rd.forward(req, res);		
	}
}
