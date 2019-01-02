<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html> 
<head>
<title>Custom Login Page</title> 
<style>
.errorblock {
    color: #ff0000;
    background-color: #ffEEEE;
}
</style>
</head>
<body>
    <h3>Custom Login Page</h3>  
 
  <form action='<spring:url value="/loginAction"/>' method="post">
  
        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td><input name="submit" type="submit" value="submit" /></td>
                <td><input name="reset" type="reset" /></td>
            </tr>
        </table>
 
    </form>
</body>
</html>