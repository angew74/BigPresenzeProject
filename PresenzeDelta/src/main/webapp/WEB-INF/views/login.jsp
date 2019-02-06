<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<link rel="apple-touch-icon" sizes="57x57" href="<c:url value="/resources/css/images/favicon/apple-icon-57x57.png" />" />
<link rel="apple-touch-icon" sizes="60x60" href="<c:url value="/resources/css/images/favicon/apple-icon-60x60.png" />" />
<link rel="apple-touch-icon" sizes="72x72" href="<c:url value="/resources/css/images/favicon/apple-icon-72x72.png" />" />
<link rel="apple-touch-icon" sizes="76x76" href="<c:url value="/resources/css/images/favicon/apple-icon-76x76.png" />" />
<link rel="apple-touch-icon" sizes="114x114" href="<c:url value="/resources/css/images/favicon/apple-icon-114x114.png" />" />
<link rel="apple-touch-icon" sizes="120x120" href="<c:url value="/resources/css/images/favicon/apple-icon-120x120.png" />" />
<link rel="apple-touch-icon" sizes="144x144" href="<c:url value="/resources/css/images/favicon/apple-icon-144x144.png" />" />
<link rel="apple-touch-icon" sizes="152x152" href="<c:url value="/resources/css/images/favicon/apple-icon-152x152.png" />" />
<link rel="apple-touch-icon" sizes="180x180" href="<c:url value="/resources/css/images/favicon/apple-icon-180x180.png" />" />
<link rel="icon" type="image/png" sizes="192x192"  href="<c:url value="/resources/css/images/favicon/android-icon-192x192.png" />" />
<link rel="icon" type="image/png" sizes="32x32" href="<c:url value="/resources/css/images/favicon/favicon-32x32.png" />" />
<link rel="icon" type="image/png" sizes="96x96" href="<c:url value="/resources/css/images/favicon/favicon-96x96.png" />" />
<link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/resources/css/images/favicon/favicon-16x16.png" />" />
<link rel="manifest" href="<c:url value="/resources/css/images/favicon/manifest.json" />" />
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="<c:url value="/resources/css/images/favicon/ms-icon-144x144.png" />" />
<meta name="theme-color" content="#ffffff">
<!DOCTYPE html>
<html> 
    <head>
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">       
        <link href="<c:url value="/resources/css/users/login.css" />" type="text/css" rel="stylesheet" />       
        <link rel="stylesheet" href="webjars/bootstrap/4.1.1/css/bootstrap.min.css">
        <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <title>Autenticazione</title> 
    </head>   
    <body>
        <nav class="navbar navbar-icon-top navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand"  href="http://Deltasi.it"><img src="resources/css/images/delta-logo.png" style="height: 4em; display: inline-block;vertical-align: middle; max-width: 100%;" /></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">
                            <i class="fa fa-home"></i>
                            Home
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>                  
            </div>
        </nav> 
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Tabs Titles -->
                <!-- Icon -->
                <div class="fadeIn first">
                    <img id="profile-img" class="profile-img-card" src="resources/css/images/avatar.png" id="icon"  alt="User Icon" />
                </div>
                <form action='<spring:url value="/login"/>' method="post">       
                    <input id="login" type="text" name="username"  placeholder="Username"  class="fadeIn second">                                   
                    <input id="password" type="password" name="password"  placeholder="password" class="fadeIn third">                  
                    <input type="submit" class="fadeIn fourth" class="btn btn-dark"  value="Accedi">     
                    <div id="formFooter">
                        <a class="underlineHover" href="#">Password dimenticata?</a>
                    </div>
            </div>
        </div>
    </form>
</body>
</html>
