<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<html>
    <head>
        <jsp:include page="../common/head.jsp" />   
        <link href="<c:url value="/resources/css/common/parsley.css" />" type="text/css" rel="stylesheet" />   
        <link href="<c:url value="/resources/css/presenze/riepilogo.css" />" type="text/css" rel="stylesheet" />       
        <script src="<c:url value="/resources/js/riepilogo.js" />" type="text/javascript"></script>
    </head>   
    <body>    
        <jsp:include  page="../common/menu.jsp"  />            
        <div class="container delta_services">
            <div class="row">
                <ul class="links">
                    <li class="disabled"><a href="#" title="Anno">
                            <span class="icon"><i class="fa fa-calendar"></i></span>
                            <span class="text">
                                <select id="annoselect"
                                        class="form-control" required>                                            
                                    <option value="2019">2019</option>
                                    <option value="2018">2018</option>
                                </select>
                            </span></a>
                        <div class="clearfix"></div>
                    </li>
                    <sec:authorize access="!hasRole('ROLE_ADMIN')">   
                        <li><a href="#" title="Anno" class="disabled">
                                <span class="icon"><i class="fa fa-user-circle-o"></i></span>
                                <span class="text">
                                    Utente
                                </span></a>
                            <div class="clearfix"></div>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <li id="Utente">
                            <a href="#" title="Utente">
                                <span class="icon"><i class="fas fa-user"></i></span>    
                                <span class="text">
                                    <form:select id="selectUsers"    
                                                 data-validation="required" 
                                                 path="Users"                                                     
                                                 name="userid"                                                    
                                                 cssClass="form-control"
                                                 required="true"
                                                 data-parsley-errors-container="#errorSelectUsers">
                                        <form:option value="" label=" Selezionare Utente"/>
                                        <form:options items="${Users}" name="iduser" itemValue="id" itemLabel="username"/>
                                    </form:select>
                                </span>
                            </a>
                            <div class="clearfix"></div>
                            <div class="form-group row" style="margin-left: 10px; margin-top: 5px">
                                <span class="col-md-1 col-md-offset-2 text-center"></span>
                                <div class="col-md-8">   
                                    <div id="errorSelectUsers" class="errorBlock"></div>
                                </div>
                            </div>
                        </li>                            
                    </sec:authorize>       
                    <li id="Mese" style="display:none">
                        <a href="#" title="Mese">
                            <span class="icon"><i class="fas fa-calendar-plus"></i></span>    
                            <span class="text">
                                <select                                    
                                    name="MeseSelect" 
                                    class="form-control" 
                                    required
                                    id="MeseSelect">
                                </select>                                   
                            </span>
                        </a>
                        <div class="clearfix"></div>                      
                        <input type="hidden" id="IdUserValue"   />      
                    </li>
                    <li id="Totale" style="display:none" class="disabled">
                        <a href="#" title="Totale">
                            <span class="icon"><i class="fas fa-calculator"></i></span>    
                            <span  class="text">                                                       
                                <input type="text" name="TotaleText" class="form-control" id="TotaleText"  readonly  autocomplete="off" />
                            </span>                     
                        </a>
                        <div class="clearfix"></div>
                    </li>                   
                </ul>                
            </div>
        </div>   
        <div id="divGiorni" style="display:none" class="container">
            <table id="tableGiorni" class="table table-hover table-sm table-riepilogo">
                <thead>
                    <tr>
                        <th>Usermame</th>
                        <th>Data</th>    
                        <th><i class="fas fa-calendar-day"></i></th>                        
                    </tr>
                </thead>                    
            </table>
        </div>
        <jsp:include page="../common/modalerror.jsp" />   
        <jsp:include page="modifica.jsp" />   
    </body>
</html>