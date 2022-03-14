package com.techm.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet(urlPatterns="/addServlet",
initParams= {
		@WebInitParam(name="dbUrl", value="jdbc:mysql://localhost/mybd"),
		@WebInitParam          (name="dbUser" , value="root"),
		@WebInitParam             (name="dbPassword" , value="1234abcd"),
})
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;

    public void init(ServletConfig Config) {
    	try {
    		ServletContext context = Config.getServletContext();
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		Enumeration <String> eachname=context.getInitParameterNames();
    		
    		while(eachname.hasMoreElements()) {
    			String element = eachname.nextElement();
    			System.out.println("Each param name:"+element);
    			System.out.println("Context param value:" +context.getInitParameter(element));
    			
    		}
			 connection = DriverManager.getConnection(Config.getInitParameter("dbUrl"),Config.getInitParameter("dbUser"),Config.getInitParameter("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FirstName= request.getParameter("firstName");
		String LastName= request.getParameter("lastName");
		String Email= request.getParameter("email");
		String Password= request.getParameter("password");
		
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into user values('"+FirstName+"','"+LastName+"','"+Email+"','"+Password+"')");
			PrintWriter writer = response.getWriter();
			if(result>0) {
				writer.print("<H1>USER CREATED</H1>");
			}else {
				writer.print("<H1>UNABLE TO CREATE USER</H1>");
			}
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
