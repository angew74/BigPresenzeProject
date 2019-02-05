<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<html>
    <head>
        <jsp:include page="../common/head.jsp" />   
        <link href="<c:url value="/resources/css/presenze/inserimento.css" />" type="text/css" rel="stylesheet" />     
        <script type="text/javascript" src="<c:url value="/webjars/moment/2.22.2/js/moment.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/tempusdominus-bootstrap-4.min.js" />"></script>
        <link href="<c:url value="/resources/css/tempusdominus-bootstrap-4.min.css" />" type="text/css" rel="stylesheet" />     
        <script src="<c:url value="/resources/js/inserimento.js" />" type="text/javascript"></script>


    </head>   
    <body>    
        <jsp:include  page="../common/menu.jsp"  /> 
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="well well-sm">
                        <form class="form-horizontal" name="insertPForm" action="/PresenzeDelta/presenze/add" method="post">               
                            <fieldset>                                    
                                <sec:authorize access="(!(hasRole('USER'))">   
                                    <div class="form-group row">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-id-badge bigicon"></i></span>
                                        <div class="col-md-8">                              
                                            <input type="text" name="id" value="${Presenze.user.id}" class="form-control" id="iduseredit"  readonly  autocomplete="off" />
                                        </div>  
                                    </div>   
                                    <div class="form-group row">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                        <div class="col-md-8">                          
                                            <input type="text" class="form-control" id="usernameedit" autocomplete="off" />
                                        </div>  
                                    </div>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN')">
                                    <form:select path="Users">
                                        <form:option value="-" label="--Selezionare Utente"/>
                                        <form:options items="${Users}" itemValue="id" itemLabel="username"/>
                                    </form:select>
                                </sec:authorize>                                                            
                                <div class="form-group row">
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-at bigicon"></i></span>
                                    <div class="col-md-8">    
                                        <div class="input-group date" id="giornopicker" data-target-input="nearest">
                                            <input type="text" id="giorno" name="giorno" class="form-control datetimepicker-input" data-target="#giornopicker"/>
                                            <div class="input-group-append" data-target="#giornopicker" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                                            </div>
                                        </div>
                                    </div>                         
                                </div>
                                <div class="form-group row">                          
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-object-group bigicon"></i></span>
                                    <div class="col-md-8">    
                                        <div class="input-group date" id="oraentratapicker" data-target-input="nearest">
                                            <input type="text" name="oraentrata" placeholder="ora entrata" id="oraentrata" class="form-control datetimepicker-input" data-target="#oraentratapicker"/>
                                            <div class="input-group-append" data-target="#oraentratapicker" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="fa fa-clock-o"></i></div>
                                            </div>
                                        </div>
                                    </div>                       
                                </div>  
                                <div class="form-group row">                          
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-object-group bigicon"></i></span>
                                    <div class="col-md-8">    
                                        <div class="input-group date" id="orauscitapicker" data-target-input="nearest">
                                            <input type="text" name="orauscita" placeholder="ora uscita" id="orauscita" class="form-control datetimepicker-input" data-target="#oraentratapicker"/>
                                            <div class="input-group-append" data-target="#orauscitapicker" data-toggle="datetimepicker">
                                                <div class="input-group-text"><i class="fa fa-clock-o"></i></div>
                                            </div>
                                        </div>
                                    </div>                       
                                </div> 
                                <div class="form-group row">                          
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-object-group bigicon"></i></span>
                                    <div class="col-md-8">   
                                        <div class="col-10">
                                            <input class="form-control" id="pausapranzo" min="0" max="480" name="pausapranzo" placeholder="minuti pausa pranzo" type="number" value="60">
                                        </div>
                                    </div>                       
                                </div>  
                                <div class="form-group">  
                                    <div class="form-check">
                                        <div class="col-md-8">    
                                            <input class="form-check-input" type="radio"  name="ferie" id="ferie" value="true">
                                            <label class="form-check-label" for="Ferie"><span class="fa fa-toggle-on" id="icondisablededit"></span>
                                              Ferie
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-check">
                                        <div class="col-md-8">    
                                            <input class="form-check-input" type="radio"  name="malattia" id="malattia" value="true">
                                            <label class="form-check-label" for="Malattia"><span class="fa fa-toggle-off" id="icondisablededit"></span>
                                               Malattia
                                            </label>
                                        </div>
                                    </div>                                  
                                </div>
                                 <div class="form-group row">                          
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-object-group bigicon"></i></span>
                                    <div class="col-md-8">   
                                        <div class="col-10">
                                            <input class="form-control" id="orepermesso" name="orepermesso" min="0" max="8" placeholder="ore permesso" type="number" value="60">
                                        </div>
                                    </div>                       
                                </div>  
                                 <div class="form-group row">                          
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-object-group bigicon"></i></span>
                                    <div class="col-md-8">   
                                        <div class="col-10">
                                            <input class="form-control" id="congedoparentale" name="congedoparentale" min="0" max="8" placeholder="ore congedo parentale" type="number" value="60">
                                        </div>
                                    </div>                       
                                </div>  
                                <div class="form-group row">                          
                                    <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-object-group bigicon"></i></span>
                                    <div class="col-md-8">   
                                        <div class="col-10">
                                            <input class="form-control" id="permessomalattafiglio" name="permessomalattafiglio" min="0" max="8" placeholder="ore malattia figlio" type="number" value="60">
                                        </div>
                                    </div>                       
                                </div>  
                                <div class="form-group">
                                    <div class="col-md-12 text-center">
                                        <button type="submit" id="submitEditUser" class="btn btn-success btn-sm float-right submit_btn">
                                            Salva</button>
                                    </div>
                                </div> 
                            </fieldset>
                        </form>
                    </div>
                </div>                 
            </div>
        </div>
    </body>
</html>