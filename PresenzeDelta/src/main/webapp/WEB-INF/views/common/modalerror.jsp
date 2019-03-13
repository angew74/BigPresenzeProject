<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <link href="<c:url value="/resources/css/modalerror.css" />" type="text/css" rel="stylesheet" />     
<!-- Modal HTML -->
<div id="errorModal" class="modal fade">
	<div class="modal-dialog modal-confirm">
		<div class="modal-content">
			<div class="modal-header">
				<div class="icon-box">
					<i class="material-icons">&#xE5CD;</i>
				</div>
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body text-center">
				<h4>Attenzione!</h4>	
				<p id="errorDisplay"></p>
				<button class="btn btn-success" data-dismiss="modal">Riprova ancora</button>
			</div>
		</div>
	</div>
</div>     