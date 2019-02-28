<style>
table{position: fixed; top: 0; bottom: 0; left: 0; right: 0; width: 100%; height: 100%}
.pagetitle {
	font-size: 150px;
	font-family: queen;
	margin: 50px;
    background: linear-gradient(to right, violet,indigo,blue,green,#caca1f,orange,red);
    -webkit-background-clip: text;
    background-clip: text;
    color: transparent;
    -webkit-text-fill-color: transparent;
}
#btnLogin{
	font-size: 30px;
}
</style>

<table>
	<tr>
		<td class="tab-content text-center">
			<div class="pagetitle">Welcome to coupon world</div>
			<div class="col-xs-push-3 col-xs-6">
				<button id="btnLogin" class="btn btn-info col-xs-12">Login/Signup</button>
			</div>
		</td>
	</tr>
</table>
<script>
$(document).ready(function(){
	$('#btnLogin').click(function(){
		window.location = "/login";
	});
	$('#btnBrowse').click(function(){
		alert("browse")
	});
});
</script>

