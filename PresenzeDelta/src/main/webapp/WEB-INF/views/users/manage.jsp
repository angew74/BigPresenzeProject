<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
    <head>
        <jsp:include page="../common/head.jsp" />   
        <link href="<c:url value="/resources/css/users/manage.css" />" type="text/css" rel="stylesheet" />     
        <script src="<c:url value="/resources/js/manage.js" />" type="text/javascript"> 
        </script>    
    </head>   
    <body>    
        <jsp:include  page="../common/menu.jsp"  />   
        <div class="container">
            <c:forEach items="${Users}" var="user" varStatus="s">
                <c:if test="${(s.index == 0) || (s.index == 4) || (s.index == 8) || (s.index == 12) || (s.index == 16) || (s.index == 20) || (s.index == 24) || (s.index == 28)}">
                    <div class="row mt-5">
                    </c:if>  
                    <c:if test="${(s.index == 3) || (s.index == 7) || (s.index == 11) || (s.index == 15) || (s.index == 19) || (s.index == 23) || (s.index == 27)|| (s.index == 31)}">
                        <div class="col-md-2 col-8 offset-2 offset-md-0 profile-box border p-1 rounded text-center bg-light mb-2">
                        </c:if>
                        <c:if test="${(s.index != 3) && (s.index != 7) && (s.index != 11) && (s.index != 15) && (s.index != 19) && (s.index != 23) && (s.index != 27) && (s.index != 31)}">
                            <div class="col-md-2 col-8 offset-2 offset-md-0 profile-box border p-1 rounded text-center mr-5 bg-light mb-2">
                            </c:if>
                            <img src="<c:url value="/resources/css/images/avatar.png" />" class="w-100 mb-1">
                            <h5 class="m-0"><strong>${user.username}</strong></h5>
                            <p class="mb-2">${user.mailaziendale}</p>
                            <button type="submit" id="${user.id}"  name="cancella"><i class="fas fa-user-minus" aria-hidden="true" title="Elimina"></i></button>
                            <button type="submit" id="${user.id}" id="buttonEdit${user.id}" onclick="editService(${user.id})" name="modifica"><i class="fas fa-pencil-alt" aria-hidden="true" title="Modifica"></i></button>
                            <button type="submit" id="buttonView${user.id}" onclick="viewService(${user.id})" name="visualizza"><i class="fas fa-user-alt" aria-hidden="true" title="Visualizza"></i></button>
                                <c:if test="${(s.index == 3) || (s.index == 7) || (s.index == 11) || (s.index == 15) || (s.index == 19) || (s.index == 23) || (s.index == 27)|| (s.index == 31)}">
                            </div>
                        </c:if>  
                    </div>
                </c:forEach>
            </div>  
            <jsp:include page="../common/userdetails.jsp" />      
             <jsp:include page="../common/useredit.jsp" />      
         <jsp:include page="../common/modalerror.jsp" />   
    </body>
</html>