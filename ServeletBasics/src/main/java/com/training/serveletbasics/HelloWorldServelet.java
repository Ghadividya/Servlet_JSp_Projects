package com.training.serveletbasics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldServelet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servelets World</h1>");
		out.println("</body>");
		out.println("</html");
		
		

	}

}
