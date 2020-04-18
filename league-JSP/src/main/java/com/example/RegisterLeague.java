package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.League;

public class RegisterLeague extends HttpServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2007552158095964521L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		/*response.setContentType("text/html");
		
		String l_title = request.getParameter("l_name");
		int l_year = Integer.parseInt(request.getParameter("l_year"));
		String l_season = request.getParameter("l_season");
		
		if( (l_title.length() > 8) && (l_year>=2010 && l_year<=2020) )
		{
			RequestDispatcher view = request.getRequestDispatcher("success.html");
			view.forward(request, response);
		}
		else
		{
			RequestDispatcher view = request.getRequestDispatcher("error.html");
			view.forward(request, response);
		}*/
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String l_title = request.getParameter("l_title");
		int l_year = Integer.parseInt(request.getParameter("l_year"));
		//String l_season = request.getParameter("l_season");
		
		if( (l_title.length() > 8) && (l_year>=2010 && l_year<=2020) )
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
