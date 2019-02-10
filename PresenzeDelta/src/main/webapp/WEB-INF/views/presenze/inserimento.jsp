<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
<html>
    <head>
        <jsp:include page="../common/head.jsp" />   
        <link href="<c:url value="/resources/css/common/parsley.css" />" type="text/css" rel="stylesheet" />   
        <link href="<c:url value="/resources/css/presenze/inserimento.css" />" type="text/css" rel="stylesheet" />       
        <script src="<c:url value="/resources/js/inserimento.js" />" type="text/javascript"></script>
    </head>   
    <body>    
        <jsp:include  page="../common/menu.jsp"  /> 
        <div class="container">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading panel-heading-custom">
                    <span class="col-md-1 col-md-offset-2 text-center"></span>
                    <div class="col-md-8">    
                        <i class="fa fa-plus-circle bigicon" aria-hidden="true"></i>
                        Presenza
                    </div>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="well well-sm">
                                <form class="form-horizontal" name="insertPForm" data-parsley-validate action="/PresenzeDelta/presenze/add" method="post">         
                                    <fieldset>                                    
                                        <sec:authorize access="!hasRole('ROLE_ADMIN')">   
                                            <div class="form-group row">
                                                <span class="col-md-1 col-md-offset-2 text-center"></span>
                                                <div class="col-md-8">    
                                                    <div class="input-group">
                                                        <input type="text" name="userid" value="${Presenze.user.id}" class="form-control" 
                                                               id="iduseredit"  readonly  autocomplete="off" />
                                                        <div class="input-group-append">
                                                            <div class="input-group-text"><i class="fa fa-id-badge bigicon"></i></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </sec:authorize>
                                        <sec:authorize access="hasRole('ADMIN')">
                                            <div class="form-group row">
                                                <span class="col-md-1 col-md-offset-2 text-center"></span>
                                                <div class="col-md-8">    
                                                    <div class="input-group">
                                                        <form:select path="Users" id="selectUsers" data-validation="required" 
                                                                     data-parsley-errors-container="#errorSelectUsers"
                                                                     name="presenza.userid"
                                                                     class="form-control" required="true">
                                                            <form:option value="" label=" Selezionare Utente"/>
                                                            <form:options items="${Users}" name="presenza.userid" itemValue="id" itemLabel="username"/>
                                                        </form:select>
                                                        <div class="input-group-append">
                                                            <div class="input-group-text"><i class="fa fa-id-badge bigicon"></i></div>
                                                        </div>
                                                    </div>
                                                </div>  
                                            </div>
                                            <div class="form-group row">
                                                <span class="col-md-1 col-md-offset-2 text-center"></span>
                                                <div class="col-md-8">   
                                                    <div id="errorSelectUsers" class="errorBlock"></div>
                                                </div>
                                            </div>
                                        </sec:authorize>   
                                        <div class="form-group row">
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">    
                                                <div class="input-group date" id="giornopicker" data-target-input="nearest">
                                                    <fmt:formatDate value="${Presenza.presenza.giorno}" pattern="dd/MM/yyyy" var="myGiorno" />
                                                    <form:input type="text" id="giorno" name="giorno" data-validation="required"
                                                                required="required" path="Presenza.presenza.giorno"                                                                
                                                                value="${myGiorno}"                                                            
                                                                data-parsley-errors-container="#errorGiorno"
                                                                class="form-control datetimepicker-input" data-target="#giornopicker"/>
                                                    <div class="input-group-append" data-target="#giornopicker" data-toggle="datetimepicker">
                                                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                                    </div>
                                                </div>
                                            </div>                         
                                        </div>
                                        <div class="form-group row">
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">   
                                                <div id="errorGiorno" class="errorBlock"></div>
                                            </div>
                                        </div>
                                        <div class="form-group row">                          
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">    
                                                <div class="input-group date" id="oraentratapicker" data-target-input="nearest">
                                                    <form:input type="text" name="partialoraingresso" placeholder="ora entrata" id="oraentrata" 
                                                                path="Presenza.presenza.partialoraingresso"      required="required" 
                                                                value="${Presenza.presenza.partialoraingresso}"                                                      
                                                                data-parsley-errors-container="#errorOraEntrata"
                                                                data-validation="required"
                                                                class="form-control datetimepicker-input" data-target="#oraentratapicker"/>
                                                    <div class="input-group-append" data-target="#oraentratapicker" data-toggle="datetimepicker">
                                                        <div class="input-group-text"><i class="fa fa-clock-o"></i></div>
                                                    </div>
                                                </div>
                                            </div>                       
                                        </div>  
                                        <div class="form-group row">
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">   
                                                <div id="errorOraEntrata" class="errorBlock"></div>
                                            </div>
                                        </div>
                                        <div class="form-group row">                          
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">    
                                                <div class="input-group date" id="orauscitapicker" data-target-input="nearest">
                                                    <form:input type="text" name="partialorauscita" placeholder="ora uscita" id="orauscita"                                                            
                                                                path="Presenza.presenza.partialorauscita"    
                                                                data-parsley-errors-container="#errorOraUscita"                                                         
                                                                value="${Presenza.presenza.partialorauscita}" 
                                                                class="form-control datetimepicker-input" data-target="#orauscitapicker"/>
                                                    <div class="input-group-append" data-target="#orauscitapicker" data-toggle="datetimepicker">
                                                        <div class="input-group-text"><i class="fa fa-clock-o"></i></div>
                                                    </div>
                                                </div>
                                            </div>                       
                                        </div> 
                                        <div class="form-group row">
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">   
                                                <div id="errorOraUscita" class="errorBlock"></div>
                                            </div>
                                        </div>
                                        <div class="form-group row">                          
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">   
                                                <div class="input-group">                                    
                                                    <form:input class="form-control" id="pausapranzo"       
                                                                value="${Presenza.presenza.pausapranzo}" 
                                                                path="Presenza.presenza.pausapranzo"  
                                                                min="0" max="480" name="pausapranzo" data-validation="required"  
                                                                placeholder="minuti pausa pranzo" type="number"
                                                                data-parsley-errors-container="#errorPausaPranzo"
                                                                />
                                                    <div class="input-group-append">
                                                        <div class="input-group-text"><i class="fa fa-cutlery bigicon"></i></div>
                                                    </div>
                                                </div>
                                            </div>                       
                                        </div>  
                                        <div class="form-group row">
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">   
                                                <div id="errorPausaPranzo" class="errorBlock"></div>
                                            </div>
                                        </div>
                                        <div class="form-group row">     
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">   
                                                <div class="input-group">
                                                    <form:input class="form-control" id="orepermesso" 
                                                                path="Presenza.presenza.orepermesso"
                                                                data-parsley-errors-container="#errorOrePermesso"
                                                                value="${Presenza.presenza.orepermesso}" 
                                                                name="orepermesso" min="0" max="8" data-validation="required"                                              
                                                                placeholder="ore permesso" type="number" />
                                                    <div class="input-group-append">
                                                        <div class="input-group-text"><i class="fa fa-hourglass bigicon"></i></div>
                                                    </div>
                                                </div>                       
                                            </div>  
                                        </div>
                                        <div class="form-group row">
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">   
                                                <div id="errorOrePermesso" class="errorBlock"></div>
                                            </div>
                                        </div>
                                        <div class="form-group row">               
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">   
                                                <div class="input-group">
                                                    <form:input class="form-control" id="congedoparentale" 
                                                                path="Presenza.presenza.congedoparentale" 
                                                                value="${Presenza.presenza.congedoparentale}" 
                                                                data-parsley-errors-container="#errorCongedoParentale"
                                                                name="congedoparentale"  data-parsley-type="number"
                                                                data-validation="required"  min="0" max="8" placeholder="ore congedo parentale" type="number" />
                                                    <div class="input-group-append">
                                                        <div class="input-group-text"><i class="fa fa-child bigicon"></i></div>
                                                    </div>
                                                </div>                       
                                            </div>  
                                        </div>
                                        <div class="form-group row">
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">   
                                                <div id="errorCongedoParentale" class="errorBlock"></div>                           
                                            </div>
                                        </div>
                                        <div class="form-group row">                          
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">   
                                                <div class="input-group">
                                                    <form:input class="form-control" id="permessomalattafiglio" 
                                                                data-parsley-errors-container="errorFiglio"
                                                                path="Presenza.presenza.permessomalattiafiglio"    
                                                                value="${Presenza.presenza.permessomalattiafiglio}" 
                                                                data-validation="required"  name="permessomalattafiglio" min="0" max="8"
                                                                placeholder="ore malattia figlio" type="number" />
                                                    <div class="input-group-append">
                                                        <div class="input-group-text"><i class="fa fa-stethoscope bigicon"></i></div>
                                                    </div>
                                                </div>                       
                                            </div>  
                                        </div>                                        
                                        <div class="form-group row">
                                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                                            <div class="col-md-8">   
                                                <div id="errorFiglio" class="errorBlock"></div>                           
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-left:60px">
                                            <div class="col-md-8">    
                                                <div class="form-check">
                                                    <c:choose>
                                                        <c:when test="${Presenza.presenza.malattia != null && Presenza.presenza.malattia == 'S'}">
                                                            <input type="radio" class="radio" id="malattia" name="malattia"
                                                                   checked value="S" />    
                                                        </c:when>
                                                        <c:when test="${Presenza.presenza.malattia == null && Presenza.presenza.malattia != 'S'}">
                                                            <input type="radio" class="radio" id="malattia" name="malattia"
                                                                   value="S" />    
                                                        </c:when>
                                                    </c:choose>
                                                    <label for="malattia" class="radio-custom-label">Malattia</label>
                                                </div>
                                                <div class="form-check">
                                                    <c:choose>
                                                        <c:when test="${Presenza.presenza.malattia != null && Presenza.presenza.ferie == 'S'}">
                                                            <input type="radio" class="radio" id="ferie" name="ferie"
                                                                   checked value="S" />    
                                                        </c:when>
                                                        <c:when test="${Presenza.presenza.malattia == null && Presenza.presenza.malattia != 'S'}">
                                                            <input type="radio" class="radio" id="ferie" name="ferie"
                                                                   value="S" />    
                                                        </c:when>
                                                    </c:choose>
                                                    <label for="ferie" class="radio-custom-label">Ferie</label>
                                                </div>
                                                <div class="form-check">
                                                    <input name="reset" id="reset" class="radio" type="radio">
                                                    <label for="rest" class="radio-custom-label">Reset</label>
                                                </div>   
                                            </div>
                                        </div>                                      
                                        <div class="form-group">
                                            <div class="col-md-8">
                                                <button id="btnSalva" data-parsley-validate class="btn btn-dark btn-sm float-right submit_btn"><i class="fas fa-arrow-alt-circle-right"></i>Salva</button> 
                                            </div>
                                        </div> 
                                    </fieldset>
                                </form>
                            </div>
                        </div>                 
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../common/modalerror.jsp" />   
        <jsp:include page="../common/modalsuccess.jsp" />   
    </body>
</html>