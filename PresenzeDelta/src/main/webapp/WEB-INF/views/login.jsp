<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link href="<c:url value="/resources/css/*.css" />" type="text/css" />
<link href="<c:url value="/resources/css/ivh/*.css" />" type="text/css" />
<link rel='stylesheet' href='webjars/bootstrap/4.1.1/css/bootstrap.min.css'>
<script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html> 
    <head>
        <title>Pagina Autenticazione</title> 
    </head>
    <nav class="navbar navbar-icon-top navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Navbar</a>
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
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fa fa-envelope-o">
                            <span class="badge badge-danger">11</span>
                        </i>
                        Messages
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">
                        <i class="fa fa-envelope-o">
                            <span class="badge badge-danger">11</span>
                        </i>
                        Disabled
                    </a>
                </li>
            </ul>
            <ul class="navbar-nav ">
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fa fa-bell">
                            <span class="badge badge-info">11</span>
                        </i>
                        Disabled
                    </a>
                </li>
            </ul>
            <form action='<spring:url value="/loginAction"/>' method="post" class="form-horizontal">                 
                <fieldset>
                    <!-- Form Name -->
                    <legend>Autenticazione Utente</legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="textinput">Username</label>  
                        <div class="col-md-4">
                            <input id="Uname" name="Username"  name="textinput" type="text" placeholder="inserire nome utente" class="form-control input-md" required="">
                            <span class="help-block">minimo 8 caratteri massimo 16</span>  
                        </div>
                    </div>

                    <!-- Password input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="passwordinput">Password</label>
                        <div class="col-md-4">
                            <input id="Password" name="Password" type="password" placeholder="digitare la password" class="form-control input-md">
                            <span class="help-block">minimo 8 caratteri massimo 12</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="button1id">Double Button</label>
                        <div class="col-md-8">
                            <button id="buttonAccedi" name="buttonAccedi" class="btn btn-success">Accedi</button>
                            <button id="buttonAnnulla" name="buttonAnnulla" class="btn btn-danger">Annulla</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </nav> 
</body>
</html>
