
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
    <head>
        <jsp:include page="head.jsp"></jsp:include>
        <link href="<c:url value="/resources/css/error.css" />" type="text/css" rel="stylesheet" />     
    </head>   
    <body>    
        <jsp:include page="menu.jsp" />   
        	<div class="wrapper">
			<div class="container-fluid" id="top-container-fluid-nav">
				<div class="container">	
					<!---- for nav container ----->	
				</div>
			</div> 
			
					
			<div class="container-fluid" id="body-container-fluid">
				<div class="container">
					<!---- for body container ---->
						
						
						<div class="jumbotron">
						<h1 class="display-1"><i class="fa  fa-spin fa-cog fa-3x"></i></h1>
						<h1 class="display-3">ERROR</h1>
						<p class="lower-case">${Error}</p>
						<p class="lower-case">Contattare l'amministratore di sistema per segnalare il problema</p>

						</div>
						
						 <!-------mother container middle class------------------->
						 

				</div>
			</div>
				
						
 
			<div class="container-fluid" id="footer-container-fluid">
				<div class="container">
					<!---- for footer container ---->
 				</div>
			</div>
  			
				
			
		</div>
                    </body>
    <html>