<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="<c:url value="/resources/css/*.css" />" type="text/css" />
<link href="<c:url value="/resources/css/ivh/*.css" />" type="text/css" />
<link href="<c:url value="/resources/css/md-data-table/*.css" />" type="text/css" />
<script type="text/javascript"  src="<c:url value="/resources/lib/md-data-table/md-data-table.min.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/js/app.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/js/controller.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/js/service.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/lib/bootstrap/bootstrap.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/lib/i18n/angular-locale_it-it.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/lib/i18n/angular-locale_it.js" />"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js">
</script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.0/angular-messages.js">
</script>
<!DOCTYPE html>
<html> 
    <head>
        <title>Pagina Autenticazione</title> 
    </head>
    <body ng-app="PresenzeApp" layout="row" class="icondemoFontIconsWithLigatures"> 
        <form action='<spring:url value="/loginAction"/>' method="post">  

            <mat-card class="login-card-card"  ng-controller="LoginController">
                <mat-card-header>
                    <div mat-card-avatar class="login-header-image"></div>
                    <mat-card-title>Presenze Delta</mat-card-title>
                    <mat-card-subtitle>Autenticazione Utente</mat-card-subtitle>
                </mat-card-header> 
                <mat-card-content>
                    <form name="Form">
                        <mat-form-field>
                            <label>Utenza</label>
                            <input type="text" id="Uname" ng-model="uName"
                                   ng-minlength="3"
                                   ng-maxlength="16" maxlength="16" required
                                   name="Username" style="width:200px" />
                            <div id="mesUser" ng-messages="loginform.Username.$error" role="alert">
                                <div ng-message-exp="required">UserName obbligatorio.</div>
                                <div ng-message-exp="[minlength, maxlength, required]">
                                    UserName deve essere di almeno 3 caratteri e massimo 16
                                </div>
                            </div>
                        </mat-form-field>         
                        <mat-form-field>
                            <label>Password</label>
                            <input type="password" id="Password" ng-model="password" name="Password"
                                   ng-minlength="8" maxlength="8"
                                   ng-maxlength="12" required
                                   tyle="width:200px" />
                            <div ng-messages="loginform.Password.$error" role="alert">
                                <div ng-message-exp="required">Password obbligatoria.</div>
                                <div ng-message-exp="[minlength, maxlength,required]">
                                    Password deve essere di almeno 8 caratteri e massimo 12
                                </div>
                            </div>
                        </mat-form-field>           
                    </form>          
                </mat-card-content>
                <mat-card-actions>
                    <button mat-raised-button color="primary" ng-disabled="!Form.$valid" ng-click="LoginCheck($event)">Accedi</button>
                    <button mat-raised-button ng-click="clearFields()" color="accent">Annulla</button>               
                </mat-card-actions>
            </mat-card>      
        </md-content>
    </form>
</body>
</html>
