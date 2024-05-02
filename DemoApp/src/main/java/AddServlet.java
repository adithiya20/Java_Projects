

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i+j;
		
		//System.out.println(k);
		//PrintWriter out = res.getWriter();
		//out.println(k);
		
		//If you want to add data and send a request from one servlet to another
		/*
		 * req.setAttribute("k", k);
		 * 
		 * RequestDispatcher rd = req.getRequestDispatcher("sq"); rd.forward(req, res);
		 */
		
		//if you want to Redirect your request to a user... servlet one will send a message back to client saying "you are being redirected"
		//and then client is redirected to servlet 2...Thus two requests are sent in total by client
		res.sendRedirect("https://www.geeksforgeeks.org/url-rewriting-using-java-servlet/");
		
	}

}
