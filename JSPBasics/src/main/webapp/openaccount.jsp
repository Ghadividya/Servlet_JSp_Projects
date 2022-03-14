<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%!
         Connection conn;
         PreparedStatement ps; 
         
         public void jspInint(){
        	 try{
        	 Class.forName("com.mysql.jdbc.Driver");
        	 conn=DriverManager.getConnection("jdbc:mysql://localhost/mybd","root","1234abcd");
        	 ps=conn.prepareStatement("insert into account value(?,?,?,?)");
        	 }
        	 catch(Exception e){
        		 e.printStackTrace();
        	 }
         }
         
         
         public void jspDestroy(){
        	try{ 
        	 ps.close();
        	 conn.close();
        	}
        	catch(Exception e){
        		e.printStackTrace();
        	}
         }%>
         
   <%
        int accno = Integer.parseInt(request.getParameter("accno"));
        String lastName = request.getParameter("lastname");
        String firstName = request.getParameter("firstname");
        int bal = Integer.parseInt(request.getParameter("bal"));
        
        
        ps.setInt(1, accno);
        ps.setString(2, lastName);
        ps.setString(3, firstName);
        ps.setInt(4, bal);
        ps.executeUpdate();
        
        
    %> 
         

