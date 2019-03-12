<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
    <head>
        <jsp:include page="../common/head.jsp" />   
        <link href="<c:url value="/resources/css/anagrafica/create.css" />" type="text/css" rel="stylesheet" />     
        <script src="<c:url value="/resources/js/create.js" />" type="text/javascript">
        </script>    
    </head>   
    <body>    
        <jsp:include  page="../common/menu.jsp"  />   
        <form name="anagraficaForm" action="/PresenzeDelta/anagrafica/add" method="post">     
            <div class="container h-100">
                <div class="d-flex justify-content-center">
                    <div class="card mt-7 col-md-7 animated bounceInDown myForm" style="margin-top:30px">
                        <div class="card-header">
                            <h4>Registrazione Anagrafica</h4>
                        </div>
                        <div class="card-body">                    
                            <div id="dynamic_container">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text br-15"><i class="fas fa-user-tag"></i></span>
                                    </div>
                                    <input type="text"
                                           data-parsley-errors-container="#errorUserName"
                                           id="username"
                                           placeholder="Username" required="true" name="username" class="form-control"/>
                                </div>
                                <div class="form-group row">
                                    <span class="col-md-1 col-md-offset-2 text-center"></span>
                                    <div class="col-md-8">   
                                        <div id="errorUserName" class="errorBlock"></div>                           
                                    </div>
                                </div>         

                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text br-15"><i class="fas fa-user-tag"></i></span>
                                    </div>
                                    <input type="text"
                                           data-parsley-errors-container="#errorIdUser"
                                           id="username"
                                           placeholder="User id" disabled="true" required="true" id="iduser" name="iduser" class="form-control"/>
                                </div>
                                <div class="form-group row">
                                    <span class="col-md-1 col-md-offset-2 text-center"></span>
                                    <div class="col-md-8">   
                                        <div id="errorIdUser" class="errorBlock"></div>                           
                                    </div>
                                </div>         

                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text br-15"><i class="fas fa-id-card-alt"></i></span>
                                    </div>
                                    <input type="text"
                                           data-parsley-errors-container="#errorNome"
                                           placeholder="Nome" required="true" name="nome" class="form-control"/>
                                </div>
                                <div class="form-group row">
                                    <span class="col-md-1 col-md-offset-2 text-center"></span>
                                    <div class="col-md-8">   
                                        <div id="errorNome" class="errorBlock"></div>                           
                                    </div>
                                </div>
                                <div class="input-group mt-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text br-15"><i class="fas fa-id-card-alt"></i></span>
                                    </div>
                                    <input type="text"
                                           data-parsley-errors-container="#errorCognome"
                                           placeholder="Cognome" required="true" name="cognome" class="form-control"/>
                                </div>
                                <div class="form-group row">
                                    <span class="col-md-1 col-md-offset-2 text-center"></span>
                                    <div class="col-md-8">   
                                        <div id="errorCognome" class="errorBlock"></div>                           
                                    </div>
                                </div>
                                <div class="input-group mt-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text br-15"><i class="fas fa-restroom"></i></span>
                                    </div>
                                    <input type="text" 
                                           data-parsley-errors-container="#errorSesso"
                                           placeholder="Sesso" name="sesso" class="form-control"/>
                                </div>
                                <div class="form-group row">
                                    <span class="col-md-1 col-md-offset-2 text-center"></span>
                                    <div class="col-md-8">   
                                        <div id="errorSesso" class="errorBlock"></div>                           
                                    </div>
                                </div>
                                <div class="input-group mt-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text br-15"><i class="fas fa-birthday-cake"></i></span>
                                    </div>
                                    <input type="text" 
                                           data-parsley-errors-container="#errorDataNascita"
                                           placeholder="Daat di Nascita" name="datanascita" class="form-control"/>
                                </div>
                                <div class="form-group row">
                                    <span class="col-md-1 col-md-offset-2 text-center"></span>
                                    <div class="col-md-8">   
                                        <div id="errorDataNascita" class="errorBlock"></div>                           
                                    </div>
                                </div>

                                <div class="input-group mt-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text br-15"><i class="fas fa-user-shield"></i></span>
                                    </div>
                                    <input type="text" placeholder="Codice Fiscale" 
                                           data-parsley-errors-container="#errorCodiceFiscale"
                                           name="codiscefiscale" class="form-control"/>
                                </div>
                                <div class="form-group row">
                                    <span class="col-md-1 col-md-offset-2 text-center"></span>
                                    <div class="col-md-8">   
                                        <div id="errorCodiceFiscale" class="errorBlock"></div>                           
                                    </div>
                                </div>
                                <div class="input-group mt-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text br-15"><i class="fas fa-map"></i></span>
                                    </div>
                                    <input type="text" 
                                           data-parsley-errors-container="#errorComuneNascita"
                                           placeholder="Comune Nascita" name="comunenascita" class="form-control"/>
                                </div>
                                <div class="form-group row">
                                    <span class="col-md-1 col-md-offset-2 text-center"></span>
                                    <div class="col-md-8">   
                                        <div id="errorComuneNascita" class="errorBlock"></div>                           
                                    </div>
                                </div>
                                <div class="input-group mt-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text br-15"><i class="fas fa-globe-europe"></i></span>
                                    </div>
                                    <input type="text" placeholder="Stato Nascita"
                                           data-parsley-errors-container="#errorStatoNascita"
                                           name="statonascita" class="form-control"/>
                                </div>
                                <div class="form-group row">
                                    <span class="col-md-1 col-md-offset-2 text-center"></span>
                                    <div class="col-md-8">   
                                        <div id="errorStatoNascita" class="errorBlock"></div>                           
                                    </div>
                                </div>
                                <div class="input-group mt-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text br-15"><i class="fab fa-font-awesome-flag"></i></span>
                                    </div>
                                    <input type="text" placeholder="Cittadinanza"
                                           data-parsley-errors-container="#errorCittadinanza"
                                           name="cittadinanza" class="form-control"/>
                                </div>
                                <div class="form-group row">
                                    <span class="col-md-1 col-md-offset-2 text-center"></span>
                                    <div class="col-md-8">   
                                        <div id="errorCittadinanza" class="errorBlock"></div>                           
                                    </div>
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