package com.techm.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
//@WebServlet("/readServlet")
public class ReadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;

    public void init(ServletConfig Config) {
    	try {
    		ServletContext context = Config.getServletContext();
    		System.out.println("init()");
    		Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection(context.getInitParameter("dbUrl"),context.getInitParameter("dbUser"),context.getInitParameter("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from user");
			PrintWriter writer = response.getWriter();
			writer.print("<table>");
			writer.print("<tr>");
			writer.print("<th>");
			writer.println("First Name");
			writer.print("</th>");
			writer.print("<th>");
			writer.println("Last Name");
			writer.print("</th>");
			writer.print("<th>");
			writer.println("Email");
			writer.print("</th>");
			writer.print("</tr>");
			while(result.next()) {
			
				writer.print("<td>");
				writer.print(result.getString(1));
				writer.print("</td>");
				writer.print("<td>");
				writer.print(result.getString(2));
				writer.print("</td>");
				writer.print("<td>");
				writer.print(result.getString(3));
				writer.print("</td>");
				writer.print("</tr>");
				
			}
			writer.print("</table>");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
