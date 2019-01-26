
%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="common/head.jsp"></jsp:include>
  <body>
	<h1>Spring MVC 5 + Spring Security 5 + Hibernate 5 example</h1>
  <jsp:include page="common/menu.jsp" />
	<h2>${message} prova</h2>
	<security:authorize access="hasRole('ROLE_USER')">
		This text is only visible to a user
		<br/>
	</security:authorize>
	
	<security:authorize access="hasRole('ROLE_ADMIN')">
		This text is only visible to an admin
		<br/>
	</security:authorize>
  <a href="<c:url value="logout" />">Logout</a>
  
	<form action="/logout" method="post">
		<input value="Logout" type="submit">
	</form>
</body>  
</html>
