<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
   <nav class="navbar navbar-icon-top navbar-expand-lg navbar-dark bg-dark">
       <a class="navbar-brand"  href="http://Deltasi.it"><img src="<c:url value="/resources/css/images/delta-logo.png" />" style="height: 4em; display: inline-block;vertical-align: middle; max-width: 100%;" /></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">
                            <i class="fa fa-home"></i>
                            Home                          
                        </a>
                    </li>
                    <sec:authorize access="isAuthenticated()">
                     <li class="nav-item active">
                             <a class="nav-link" href="<c:url value="/logout" />">
                            <i class="fa fa-sign-out-alt"></i>
                            Logout                           
                        </a>
                    </li>    
                    </sec:authorize>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/presenze/inserimento" />" >
                            <i class="fa fa-plus-square"></i> 
                            Presenza
                        </a>
                    </li>
                    <sec:authorize access="hasRole('USER')">
                         <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/presenze/list" />" >
                           <i class="fa fa-bars"></i> 
                          Mio Riepilogo
                        </a>
                    </li>    
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/anagrafica/card" />" >
                           <i class="fa fa-address-card"></i> 
                          Mio Profilo
                        </a>
                    </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/presenze/riepilogo" />" >
                           <i class="fa fa-bars"></i> 
                           Riepilogo
                        </a>
                    </li>                  
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/anagrafica/list" />" >
                           <i class="fa fa-address-card"></i> 
                          Anagrafiche
                        </a>
                    </li>
                      </sec:authorize>
                </ul>
                <ul class="navbar-nav ">
                   <sec:authorize access="hasRole('ADMIN')">
                     <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/users/manage" />" >
                            <i class="fa fa-users"></i>  
                           Utenti
                        </a>
                    </li>
                    <li class="nav-item"> 
                        <a class="nav-link" href="<c:url value="/users/register" />" >
                            <i class="fa fa-user-plus"></i>  
                           Registrazione
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/curricula/view" />" >
                            <i class="fa fa-clone"></i>  
                            Curriculum
                        </a>
                    </li>
                      </sec:authorize>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/qualita/docs" />" >
                            <i class="fa fa-university"></i>                 
                                    Qualità
                        </a>
                    </li>
                </ul>          
            </div>
        </nav> 