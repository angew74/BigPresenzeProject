<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="<c:url value="/resources/css/*.css" />" type="text/css" />
<link href="<c:url value="/resources/css/ivh/*.css" />" type="text/css" />
<link href="<c:url value="/resources/css/md-data-table/*.css" />" type="text/css" />
<script type="text/javascript"  src="<c:url value="/resources/angular/angular.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/errors.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/version.json" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-animate.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-aria.js" />"></script>  
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-loader.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-cookies.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-csp.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-material.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-format.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-messages.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-mocks.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-parse-ext.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-resource.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-route.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-sanitize.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-scenario.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/angular/angular-touch.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/jquery/jquery-validate.unobtrusive.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/jquery/jquery-validate-vsdoc.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/jquery/jquery-validate.js" />"></script>
<script type="text/javascript"  src="<c:url value="/resources/jquery/jquery-1.10.2.intellisense.js" />"></script>
 <script type="text/javascript"  src="<c:url value="/resources/jquery/jquery-1.10.2.intellisense.js" />"></script>
 <script type="text/javascript"  src="<c:url value="/resources/js/app.js" />"></script>
 <script type="text/javascript"  src="<c:url value="/resources/js/controller.js" />"></script>
 <script type="text/javascript"  src="<c:url value="/resources/js/service.js" />"></script>
 <script type="text/javascript"  src="<c:url value="/resources/lib/bootstrap/bootstrap.js" />"></script>
 <script type="text/javascript"  src="<c:url value="/resources/lib/i18n/angular-locale_it-it.js" />"></script>
 <script type="text/javascript"  src="<c:url value="/resources/lib/i18n/angular-locale_it.js" />"></script>
 <script type="text/javascript"  src="<c:url value="/resources/lib/respond/respond.js" />"></script>
 <script type="text/javascript"  src="<c:url value="/resources/lib/modernizr/modernizr-2.6.2.js" />"></script>
<!DOCTYPE html>
<html> 
<head>
<title>Pagina Autenticazione</title> 
</head>
 <body ng-app="PresenzeApp" layout="row" class="icondemoFontIconsWithLigatures"> 
  <form action='<spring:url value="/loginAction"/>' method="post">  
      <md-content ng-controller="LoginController" layout="row"  layout-align="left" layout-padding="layout-padding"
             ng-cloak="ng-cloak" class="login-form">
    <md-card flex="flex" flex-gt-sm="50" flex-gt-md="33">
        <md-toolbar>
            <div class="md-toolbar-tools">
                <h2><span>Autenticazione Utente</span></h2>
            </div>
        </md-toolbar>
        <md-card-content>
            <form name="Form">
                <md-input-container class="md-block">
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
                </md-input-container>              
                <md-input-container class="md-block">
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
                </md-input-container>
                <md-button ng-disabled="!Form.$valid" ng-click="LoginCheck($event)" class="md-raised md-primary">Accedi</md-button>
                <md-button ng-click="clearFields()" class=" md-raised md-primary">Cancella</md-button>
            </form>          
        </md-card-content>
    </md-card>
   
</md-content>
<div id="divLoading" style="margin: 0px; padding: 0px; position: fixed; right: 0px; top: 0px; width: 100%; height: 100%; background-color: #666666; z-index: 30001; opacity: .8; filter: alpha(opacity=70); display: none">
    <p style="position: absolute; top: 30%; left: 45%; color: White;">
        Attendere prego...<img src="~/Content/images/loader/loader.gif">
    </p>
</div>
<div class="dialog-demo-content" layout="row" layout-wrap layout-margin layout-align="center">
    <md-button class="md-primary md-raised" id="ConfirmDialog" ng-click="showConfirm($event)">
        Confirm Dialog
    </md-button>
</div>
<div style="visibility: hidden">
    <div class="md-dialog-container" id="myDialog">
        <md-dialog layout-padding>
        </md-dialog>
    </div>
</div>
    </form>
</body>
</html>
