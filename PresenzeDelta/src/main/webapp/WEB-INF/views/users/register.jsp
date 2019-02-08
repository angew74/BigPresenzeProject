<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page session="true"%>
<html>
    <head>
        <jsp:include page="../common/head.jsp" />   
        <link href="<c:url value="/resources/css/users/register.css" />" type="text/css" rel="stylesheet" />        
            <script src="<c:url value="/resources/js/register.js" />" type="text/javascript"> 
    </script>    
</head>   
<body>    
    <jsp:include  page="../common/menu.jsp"  />  
    <form name="userForm" action="/PresenzeDelta/users/add" method="post">     
    <div class="container h-100">
        <div class="d-flex justify-content-center">
            <div class="card mt-5 col-md-4 animated bounceInDown myForm">
                <div class="card-header">
                    <h4>Registrazione Utente</h4>
                </div>
                <div class="card-body">                    
                        <div id="dynamic_container">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text br-15"><i class="fa fa-user-circle"></i></span>
                                </div>
                               <input type="text" placeholder="UserName" name="username" class="form-control"/>
                            </div>
                            <div class="input-group mt-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text br-15"><i class="fa fa-key"></i></span>
                                </div>
                                <input type="text" placeholder="Password" name="password" class="form-control"/>
                            </div>
                            <div class="input-group mt-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text br-15"><i class="fa fa-at"></i></span>
                                </div>
                                <input type="email" placeholder="Email" name="mailaziendale" class="form-control"/>
                            </div>
                        </div>                                                
                </div>
                <div class="card-footer">
                    <button type="submit" id="submitUser" class="btn btn-success btn-sm float-right submit_btn"><i class="fas fa-arrow-alt-circle-right"></i>Registra</button>
                </div>
            </div>
        </div>
    </div>
     </form>
       <jsp:include page="../common/modalerror.jsp" />   
        <jsp:include page="../common/modalsuccess.jsp" />   
</body>
</html>