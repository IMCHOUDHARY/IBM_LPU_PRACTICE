package comm.example.model.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7849420058781597495L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("u_name").toString();
		String password=request.getParameter("u_pass").toString();
		if((userName.equalsIgnoreCase("Dummy") &&(password.equalsIgnoreCase("dummy"))))
		{
			RequestDispatcher view=request.getRequestDispatcher("success.html");
			view.forward(request, response);
		}
		else
		{
			RequestDispatcher view=request.getRequestDispatcher("error.html");
			view.forward(request, response);
		}*/
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("u_name").toString();
		String passWord = request.getParameter("u_pass").toString();
		
		if((userName.equalsIgnoreCase("root")) && (passWord.equalsIgnoreCase("root")))
		{
			RequestDispatcher view = request.getRequestDispatcher("success.html");
			view.forward(request, response);
		}
		else
		{
			RequestDispatcher view = request.getRequestDispatcher("error.html");
			view.forward(request, response);
		}
	}
}
