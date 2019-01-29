<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
    <head>
        <jsp:include page="../common/head.jsp" />   
        <link href="<c:url value="/resources/css/manage.css" />" type="text/css" rel="stylesheet" />     
    </head>   
    <body>    
        <jsp:include  page="../common/menu.jsp"  />   
        <div class="container">
            <c:forEach items="${Users}" var="user" varStatus="s">
                <c:if test="${(s.index == 0) || (s.index == 4) || (s.index == 8) || (s.index == 12) || (s.index == 16) || (s.index == 20) || (s.index == 24) || (s.index == 28)}"><div class="row mt-5"></c:if>  
                    <c:if test="${(s.index == 3) || (s.index == 7) || (s.index == 11) || (s.index == 15) || (s.index == 19) || (s.index == 23) || (s.index == 27)|| (s.index == 31)}"><div class="col-md-2 col-8 offset-2 offset-md-0 profile-box border p-1 rounded text-center bg-light mb-2"></c:if>
                        <c:if test="${tagStatus.index} != 3,7,11,15,19,23,27,31"><div class="col-md-2 col-8 offset-2 offset-md-1 profile-box border p-1 rounded text-center mr-5 mb-2 bg-light"></c:if>
                                <img src="http://nicesnippets.com/demo/profile-1.jpg" class="w-100 mb-1">
                                <h5 class="m-0"><strong>${user.username}</strong></h5>
                            <p class="mb-2">${user.mailaziendale}</p>
                            <button class="btn btn-info btn-sm">Modifica</button>
                            <button class="btn btn-primary btn-sm">Visualizza</button>
                            <button class="btn btn-danger btn-sm">Cancella</button>
                             <c:if test="${(s.index == 3) || (s.index == 7) || (s.index == 11) || (s.index == 15) || (s.index == 19) || (s.index == 23) || (s.index == 27)|| (s.index == 31)}"></div></c:if>  
                    </c:forEach>
                    </div>  
        </body>
    </html>