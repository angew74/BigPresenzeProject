<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/users/useredit.css" />" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />  
<div id="userEditModal" class="modal fade">   
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <div class="avatar"><i class="material-icons">&#xE7FD;</i>Modifica utente</div>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="well well-sm">
                                <form class="form-horizontal" name="userEditForm" action="/PresenzeDelta/users/modify" method="post">               
                                    <fieldset>
                                    <div class="form-group row">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-id-badge bigicon"></i></span>
                                        <div class="col-md-8">                              
                                            <input type="text" name="id" class="form-control" id="iduseredit"  readonly  autocomplete="off" />
                                        </div>                     
                                    </div>
                                    <div class="form-group row">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                                        <div class="col-md-8">                          
                                            <input type="text" name="username"class="form-control" id="usernameedit" autocomplete="off" />
                                        </div>  
                                    </div>
                                    <div class="form-group row">
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-at bigicon"></i></span>
                                        <div class="col-md-8">    
                                            <input type="text" name="mailaziendale" class="form-control" id="mailedit" autocomplete="off" />
                                        </div>                         
                                    </div>
                                    <div class="form-group row">                          
                                        <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-object-group bigicon"></i></span>
                                        <div class="col-md-8">    
                                            <input type="text" name="authorities" class="form-control" id="rolesedit" autocomplete="off" />
                                        </div>                       
                                    </div>                                     
                                        <br />
                                    <div class="form-group">  
                                        <div class="form-check">
                                               <div class="col-md-8">    
                                            <input class="form-check-input" type="radio" name="enabled"  id="able" value="true" checked>
                                            <label class="form-check-label" for="abilitato"><span class="fa fa-toggle-on" id="icondisablededit"></span>
                                                Abilitato
                                            </label>
                                               </div>
                                        </div>
                                        <div class="form-check">
                                               <div class="col-md-8">    
                                            <input class="form-check-input" type="radio" name="enabled" id="disable" value="false">
                                            <label class="form-check-label" for="disabilitato"><span class="fa fa-toggle-off" id="icondisablededit"></span>
                                                Disabilitato
                                            </label>
                                               </div>
                                        </div>                                  
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-12 text-center">
                                            <button type="submit" id="submitEditUser" class="btn btn-success btn-sm float-right submit_btn">
                                                Modifica</button>
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
    </div>
</div>
