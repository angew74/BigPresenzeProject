<%-- 
    Document   : modifica
    Created on : 23-feb-2019, 11.52.01
    Author     : Nick
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link href="<c:url value="/resources/css/presenze/modifica.css" />" type="text/css" rel="stylesheet" />
<script src="<c:url value="/resources/js/modifica.js" />" type="text/javascript"></script>
<link href="<c:url value="/resources/css/common/parsley.css" />" type="text/css" rel="stylesheet" />   
<div id="presenzaEditModal" role="dialog" class="modal fade">   
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <div class="avatar"><i class="material-icons">&#xE7FD;</i>Modifica Presenza</div>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">             
                <form name="presenzaEditForm" action="/PresenzeDelta/presenze/modifica" method="post">               
                    <fieldset> 
                        <div class="form-group row">
                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                            <div class="col-md-8">    
                                <div class="input-group">
                                    <input type="text" class="form-control" 
                                           id="username"  readonly  autocomplete="off" />
                                    <div class="input-group-append">
                                        <div class="input-group-text"><i class="fa fa-id-badge bigicon"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>                      
                        <input type="hidden" name="id" class="form-control" 
                               id="idgiorno"  />        
                        <div class="form-group row">
                            <span class="col-md-1 col-md-offset-2 text-center"></span>
                            <div class="col-md-8">    
                                <div class="input-group date" id="giornopicker" data-target-input="nearest">                                                 
                                    <input type="text" id="giorno" name="giorno" data-validation="required"
                                           required                                  
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
                                    <input type="text" name="oraentrata" placeholder="ora entrata" id="oraentrata" 
                                           required                                                                                                            
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
                                    <input type="text" name="orauscita" placeholder="ora uscita" id="orauscita" 
                                           data-parsley-errors-container="#errorOraUscita"                                                                  
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
                                    <input class="form-control" id="pausapranzo"      
                                           required
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
                                    <input class="form-control" id="orepermesso"                                                              
                                           data-parsley-errors-container="#errorOrePermesso"
                                           required
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
                                    <input class="form-control" id="congedoparentale"                                                              
                                           required
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
                                    <input class="form-control" id="permessomalattafiglio" 
                                           data-parsley-errors-container="errorFiglio"                                                               
                                           required
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
                                    <input type="radio" class="radio" id="malattia" 
                                           />                                                        
                                    <label for="malattia" class="radio-custom-label">Malattia</label>
                                </div>
                                <div class="form-check">                                                                                               
                                    <input type="radio" class="radio" id="ferie" 
                                            />   
                                    <label for="ferie" class="radio-custom-label">Ferie</label>
                                </div>
                                <div class="form-check">
                                    <input name="reset" id="reset" class="radio" type="radio">
                                    <label for="rest" class="radio-custom-label">Reset</label>
                                </div>   
                            </div>
                        </div>   
                        <div class="form-group" style="margin-left:60px">
                            <div class="col-md-8">                                                   
                                <div class="form-check">
                                    <sec:authorize access="!hasRole('ROLE_ADMIN')">   
                                        <input class="form-check-input" type="checkbox"                                              
                                           value="0"    id="verified" disabled>
                                        <label class="form-check-label" for="verified">
                                            Vistate
                                        </label> 
                                    </sec:authorize>
                                    <sec:authorize access="hasRole('ADMIN')">
                                        <input class="form-check-input" type="checkbox"                                             
                                          value="0" id="verified">
                                        <label class="form-check-label" for="verified">
                                            Vistate
                                        </label>
                                    </sec:authorize>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="userid" class="form-control" 
                               id="userid"  />        
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