<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <link href="<c:url value="/resources/css/users/userdetails.css" />" type="text/css" rel="stylesheet" />
 <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
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
            <span class="glyphicon glyphicon-user"></span> UserName: <span id="username"></span>
        </a>
        <a href="#" class="list-group-item">
            <span class="glyphicon glyphicon-envelope"></span> Mail: <span id="mail"></span>
        </a>
        <a href="#" class="list-group-item">
            <span class="glyphicon glyphicon-bishop"></span> Ruoli: <span id="roles"></span>
        </a>       
    </div>
</div>		                
			</div>
		</div>
	</div>
</div>     