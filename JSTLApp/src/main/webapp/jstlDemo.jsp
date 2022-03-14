


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cout Demo</title>
</head>
<body>
<c:out value="${10+9}"/>
<c:set var="testScore" value="${80}" scope="session"/>
<c:out value="testScore"/>
<c:if test="${testScore>=80}">
    <P>Your score is Awesome <c:out value="${testScore}"/></P>
    <c:out value="${testScore}"/>
 </c:if>
 
 <c:choose>
 <c:when test="${testScore>=80}">
 A Grade
 </c:when>
 <c:when test="${testScore>=60 && testScore<=80}">
 B Grade
 </c:when>
 <c:otherwise>
 C Grade
 </c:otherwise>
 
 
 </c:choose>
 
 <c:forEach var="i" begin="1" end="3">
 <c:out value="${i}"/>
 </c:forEach>
   
<c:remove var="testScore"/>
 After removal the value is:<c:out value="${testScore}"/>
 
 <c:set var="accountBalance" value="123.456"/>
 <fmt:parseNumber var="i" type="number" value="${accountBalance })"/>
 <p>Account is <c:out value="${i}"/><p>
 
 
  <c:set var="accountBalance" value="1777.4569"/>
 <p> formated number1: <fmt:formatNumber value="${accountBalance }" type="currency"/></p>
 <p> formated number2: <fmt:formatNumber value="${accountBalance }" type="number" maxFractionDigits="2"/></p>
 <p> formated number3: <fmt:formatNumber value="${accountBalance }" type="number" maxIntegerDigits="2"/></p>
 <p> formated number4: <fmt:formatNumber value="${accountBalance }" type="percent"/></p>
 <p> formated number5: <fmt:formatNumber value="${accountBalance }" type="number" pattern="####.##$"/></p>
 
 <c:set var="myDate" value="17-02-2022"/>
 <fmt:parseDate  var="parseDate" value="${myDate}" pattern="dd-MM-yyyy"/>
 <p>Parse Date:<c:out value="${ parseDate}"/></p>
 
 
</body>
</html>