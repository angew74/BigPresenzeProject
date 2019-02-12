<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/modalsuccess.css" />" type="text/css" rel="stylesheet" />  
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<div id="successModal" class="modal fade">
	<div class="modal-dialog modal-confirm modal-success">
		<div class="modal-content modal-success">
			<div class="modal-header modal-success">
				<div class="icon-box">
					<i class="material-icons">&#xE876;</i>
				</div>
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body text-center">
				<h4>Compliementi!!</h4>	
				<p id="messagesuccess"></p>                             
                                <button class="btn btn-success" data-dismiss="modal"><i class="material-icons">&#xE5C8;</i></button>
			</div>
		</div>
	</div>
</div>     