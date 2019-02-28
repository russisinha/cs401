<div class="headerCon container-fluid">
	<div class="pull-right loggedin text-right">
		<div class="username">${userdetails.get_user_name() }</div>
		<div id="btnLogout">Log Out</div>
	</div>
</div>
<script>
$(document).ready(function(){
	$('#btnLogout').click(function(){
		window.location = "/logout";
	});
});
</script>