<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/users/userdetails.css" />" type="text/css" rel="stylesheet" />
<div id="userDetailsModal" class="modal fade">
    <div class="modal-dialog modal-userdetails">
        <div class="modal-content">
            <div class="modal-header">
                <div class="avatar"><i class="material-icons">&#xE7FD;</i></div>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">			
                <div class="bs-example">
                    <div class="list-group-user">
                        <a href="#" class="list-group-item active">
                            <span class="fa fa-user-circle"></span> UserName: <span id="username"></span>
                        </a>
                        <a href="#" class="list-group-item">
                            <span class="fa fa-at"></span> Mail: <span id="mail"></span>
                        </a>
                        <a href="#" class="list-group-item">
                            <span class="fa fa-object-group"></span> Ruoli: <span id="roles"></span>
                        </a>    
                        <a href="#" class="list-group-item">
                            <span class="fa fa-toggle-off" id="icondisabled"></span><span id="displayendisabled">Disabilitato</span>
                        </a>    
                    </div>
                </div>		                
            </div>
        </div>
    </div>
</div>     