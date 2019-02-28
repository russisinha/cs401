<style>
.headerCon .loggedin{display: none; visibility: hidden}
table{position: fixed; top: 0; bottom: 0; left: 0; right: 0; width: 100%; height: 100%}
#loginContainer, #signupContainer {
	max-width: 500px; 
	margin: auto;
}
.loginBox.panel,
.signupBox.panel{
	margin: 0px;
}
#loginContainer .panel-title,
#signupContainer .panel-title{
	font-size: 25px;
}
#loginContainer .extrabottom,
#signupContainer .extrabottom{
	padding: 5px;
	font-size: 15px;
}
#signupContainer .seperator,
#loginContainer .seperator{height: 10px;}

.pagetitle {
	font-size: 150px;
	font-family: queen;
	margin: 10px;
    background: linear-gradient(to right, violet,indigo,blue,green,#caca1f,orange,red);
    -webkit-background-clip: text;
    background-clip: text;
    color: transparent;
    -webkit-text-fill-color: transparent;
}
</style>

<table>
	<tr>
		<td class="tab-content">
			<div class="pagetitle text-center">Welcome to coupon world</div>
			<div class="tab-pane fade in active clearfix" id="loginContainer">
				<div class="coupon_border">
					<div class="loginBox clearfix panel panel-info">
						<div class="panel-heading">
							<div class="panel-title">Log In</div>
						</div>
						<div class="panel-body">
							<input type="text" class="form-control input-lg loginid" placeholder="User ID" />
						    <div class="seperator"></div>
						    <input type="password" class="form-control input-lg password" placeholder="Password" />
						    <div class="errMsg"></div>
						    <div class="seperator"></div>
						    <button id="btnLogin" class="btn btn-info col-xs-12 btn-lg">Log In</button>
					    	<div class="extrabottom col-xs-12">Don't have an account? <a href="#signupContainer" data-toggle="tab">Sign up now.</a></div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="tab-pane fade clearfix" id="signupContainer">
				<div class="coupon_border">
					<div class="signupBox clearfix panel panel-success">
						<div class="panel-heading">
							<div class="panel-title">Sign Up</div>
						</div>
						<div class="panel-body">
							<input type="text" class="form-control input-lg loginid" placeholder="User ID" />
						    <div class="seperator"></div>
						    <input type="password" class="form-control input-lg password" placeholder="Password" />
						    <div class="seperator"></div>
						    <input type="text" class="form-control input-lg username" placeholder="Full name" />
						    <div class="errMsg"></div>
						    <div class="seperator"></div>
						    <button id="btnSignup" class="btn btn-success col-xs-12 btn-lg">Create Account</button>
						    <div class="extrabottom col-xs-12">Already have an account? <a href="#loginContainer" data-toggle="tab">Log In</a></div>
						</div>
					</div>
				</div>
			</div>
			
		</td>
	</tr>
</table>
<script>
$(document).ready(function(){
	$('#btnLogin').click(function(){
    	$('.loginBox .errMsg').html('')
		$.ajax({
			url: "/login/check",
			data: {'loginid': $('.loginBox .loginid').val(), 'password': $('.loginBox .password').val()},
		    contentType: "application/json; charset=utf-8",
		    success: function(result) {
		        if(result == 'success'){
		        	window.location = "user";
		        }
		        else{
		        	$('.loginBox .errMsg').html(result)
		        }
		    	console.log(result)
		        
		    },
		    error: function(err) {
		    	alert("error")
		    }
		});
	});
	
	$('#btnSignup').click(function(){
    	$('.signupBox .errMsg').html('')
		$.ajax({
			url: "/login/signup",
			data: {'loginid': $('.signupBox .loginid').val(), 'password': $('.signupBox .password').val(), 'name': $('.signupBox .username').val()},
		    contentType: "application/json; charset=utf-8",
		    success: function(result) {
		        if(result == 'success'){
		        	window.location = "user";
		        }
		        else{
		        	$('.signupBox .errMsg').html(result)
		        }
		    	console.log(result)
		        
		    },
		    error: function(err) {
		    	alert("error")
		    }
		});
	});
	
	$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		$('.errMsg').html('');
	})
});
</script>