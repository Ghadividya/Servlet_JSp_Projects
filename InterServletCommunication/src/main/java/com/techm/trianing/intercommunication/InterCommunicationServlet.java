package com.techm.trianing.intercommunication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InterCommunicationServlet
 */
@WebServlet("/LoginServlet")
public class InterCommunicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("userName");
		String parameter2 = request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/mybd","root","1234abcd");
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user where email='"+parameter+"' and password='"+parameter2+"'");
			RequestDispatcher dispatcher = request.getRequestDispatcher("homeServlet");
			if(resultSet.next()) {
				request.setAttribute("message","Welcome to Interservlet Communication "+parameter);
				dispatcher.forward(request, response);
			}
				else {
					dispatcher=request.getRequestDispatcher("login.html");
					dispatcher.include(request, response);
				}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
