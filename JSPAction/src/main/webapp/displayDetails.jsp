<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="product" class="com.techm.trining.usebean.Product">
<jsp:setProperty name="product" property="*"/>
</jsp:useBean>
Product Details
<br  />Id:<jsp:getProperty property="id" name="product" />
<br />Name:<jsp:getProperty property="name" name="product" />
<br />Description:<jsp:getProperty property="description" name="product" />
<br />Id:<jsp:getProperty property="price" name="product" />


</body>
</html>