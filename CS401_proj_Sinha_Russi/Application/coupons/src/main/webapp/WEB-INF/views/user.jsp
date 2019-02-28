<style>
.bodyContainer{
	border-radius: 10px;
	background-color: white;
	border: 1px solid grey;
	padding: 25px;
	min-height: 350px
}
.couponDisp .couponHolder{
	padding: 15px;
}
#newcoupons .btnHolder{
	margin-top: 40px;
}
#newcoupons .btnHolder .btnManual,
#newcoupons .btnHolder .btnImport{
	font-size: 25px;
	box-shadow: 0px 0px 10px grey;
	transition: all 0.1s linear;
	padding: 20px 40px;
}
#newcoupons .btnHolder .btnManual:hover,
#newcoupons .btnHolder .btnImport:hover{
	transform: scale(1.04);
	box-shadow: 8px 8px 10px grey;
}

.couponForm .input-group{
	margin: 10px 0;
}
.couponForm .input-group-addon{
	min-width: 130px;
	text-align: right;
}
.couponDisp .coupon.stitched {
   position: relative;
   padding: 20px;
   margin: 10px;
   font-size: 21px;
   font-weight: bold;
   line-height: 1.3em;
   border-radius: 10px;
   font-weight: normal;
}
.couponDisp .coupon.stitched.unused {
   background: #ff8c55;
   color: #fff;
   border: 2px dashed #fff;
   box-shadow: 0 0 0 4px #ff8c55, 2px 1px 6px 4px rgba(10, 10, 0, 0.5);
}
.couponDisp .coupon.stitched.redeemed {
	background: #81c875;
	color: #fff;
	border: 2px dashed #fff;
	box-shadow: 0 0 0 4px #81c875, 2px 1px 6px 4px rgba(10, 10, 0, 0.5)
}
.couponDisp .coupon.stitched.expired {
   background: #807f7f;
   color: lightgray;
   border: 2px dashed #fff;
   box-shadow: 0 0 0 4px #807f7f, 2px 1px 6px 4px rgba(10, 10, 0, 0.5);
}
.couponDisp .coupon .percent {
	position: absolute;
	right: 20px;
	bottom: 10px;
	font-size: 81px;
	font-style: italic;
	font-family: fantasy;
	color: rgba(255, 255, 255, 0.3);
	line-height: 1;
}
.couponDisp .coupon .cname {
	text-transform: uppercase;
	font-family: monospace;
	font-weight: bold;
	font-size: 35px;
	line-height: 0.8;
	word-break: break-word;
}
.couponDisp .coupon .price .old {
	text-decoration: line-through;
	text-decoration-color: darkslategrey;
	text-decoration-style: double;
	color: darkred;
	margin-right: 10px;
}
.couponDisp .coupon .price .new {
	color: #275527;
	font-weight: bold;
	font-size: 25px;
}
.couponDisp .coupon .expiry {
	font-size: 16px;
	font-weight: bold;
}
.couponDisp .coupon .expiry span {
	font-size: 21px;
}
.couponDisp .coupon.unused .expiry {
	color: #a16161;
}
.couponDisp .coupon.redeemed .expiry{
	color: transparent;
}
.couponDisp .coupon .copn_cover{
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    border-radius: 10px;
    transition: all 0.2s linear;
	background-color: rgba(71, 71, 71, 0.7);
}
.couponDisp .coupon .copn_cover table.status,
.couponDisp .coupon .copn_cover table.action{
	width: 100%;
	height: 100%;
}
.couponDisp .coupon.unused .copn_cover{
    opacity: 0;
    z-index: -1;
}
.couponDisp .coupon.unused:hover .copn_cover{
    opacity: 1;
    z-index: 5;
}
.couponDisp .coupon.unused .copn_cover table.status{
	display: none;
}
.couponDisp .coupon:not(.unused) .copn_cover table.action{
	display: none;
}
.couponDisp .coupon.redeemed .copn_cover,
.couponDisp .coupon.expired .copn_cover{
    opacity: 1;
	z-index: 5;
}
.couponDisp .coupon.redeemed:hover .copn_cover,
.couponDisp .coupon.expired:hover .copn_cover{
    opacity: 0;
    z-index: -1;
}
.couponDisp .coupon .copn_cover table.status span{
	font-size: 50px;
	text-transform: uppercase;
	line-height: 1;
	transform: rotate(-8deg);
	position: relative;
	display: inline-block;
}
.couponDisp .coupon.redeemed .copn_cover table.status span{
	color: #60eb6b;
	font-family: stamps2;
}
.couponDisp .coupon.expired .copn_cover table.status span{
	color: #eb6060;
	font-family: stamps2;
}
#mycoupons .couponDisp .coupon.new .copn_cover table.action button.btnDelete,
#mycoupons .couponDisp .coupon.unused:not(.new) .copn_cover table.action button.btnRedeem,
#browse .couponDisp .coupon .copn_cover table.action button.btnBuy{
	display: block;
	visibility: visible;
}
.couponDisp .coupon .copn_cover table.action button.btnRedeem,
.couponDisp .coupon .copn_cover table.action button.btnDelete,
.couponDisp .coupon .copn_cover table.action button.btnBuy{
	display: none;
	visibility: hidden;
}

#mycoupons .couponDisp .coupon.new .copn_cover table.action button.btnDelete,
#mycoupons .couponDisp .coupon.unused .copn_cover table.action button.btnRedeem,
#browse .couponDisp .coupon .copn_cover table.action button.btnBuy{
	margin-top: -30px;
	opacity: 0;
	font-size: 20px;
	transition: all 0.3s cubic-bezier(.87,.19,.64,.59);
	animation-name: slidedown;
}
#mycoupons .couponDisp .coupon.unused:hover .copn_cover table.action button.btnRedeem,
#mycoupons .couponDisp .coupon.new:hover .copn_cover table.action button.btnDelete,
#browse .couponDisp:hover .coupon .copn_cover table.action button.btnBuy{
	margin-top: 0px;
	opacity: 1;
}



.couponDisp .coupon:not(.new) .pointer{
	visibility: hidden;
	display: none;
}
.pointer {
    width: 60px;
    height: 40px;
    position: absolute;
    background: #5d76f1;
    top: -5px;
    right: -5px;
}
.pointer:before {
    content: "";
    position: absolute;
    left: -20px;
    bottom: 0;
    width: 0;
    height: 0;
    border-right: 20px solid #5d76f1;
    border-top: 20px solid transparent;
    border-bottom: 20px solid transparent;
}
.pointer .txt{
	position: absolute;
    top: 7px;
    left: 4px;
    font-weight: bold;
    font-family: stamps;
    color: #ff9999;
}

#mycoupons .extras{
	padding: 5px 0px;
	background: #45a7c6;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
}
#mycoupons .extras .filterSelect{
	overflow: hidden;
	height: 54px;
}
#mycoupons .extras .section{
	padding-top: 10px;
	padding-bottom: 10px;
}
#mycoupons .extras .sectionSearch{
	transition: all 0.3s linear
}
#mycoupons .extras.sortShow .sectionSearch{
	margin-top: -54px
}
#mycoupons .extras.sortShow .btnFilterSrt.btnactive,
#mycoupons .extras.sortShow .btnFilterSrch.btnactive{
	background-color: grey;
}
#mycoupons .extras.searchShow .sectionSearch{
	margin-top: 0px
}

</style>
<div class="bodyContainer container">
	<ul class="nav nav-tabs">
		<li class="active tab1"><a data-toggle="tab" href="#mycoupons">My Coupons</a></li>
		<li class="tab2"><a data-toggle="tab" href="#newcoupons">Add coupons</a></li>
		<li class="tab3"><a data-toggle="tab" href="#browse">Browse All</a></li>
		<li class="tab4 pull-right hidden" style="float: right;">
			<button class="btn btn-success" style="font-size: 18px;">Save changes to database</button>
		</li>
	</ul>
	
	<div class="tab-content">
		<div id="mycoupons" class="tab-pane fade in active">
			<div class="extras clearfix sortShow">
				<div class="col-xs-4 section">
					<span class="btn-group">
						<span class="btn btn-default btn-primary btnFilterSrt" add="sortShow">Sort</span>
						<span class="btn btn-default btnFilterSrch" add="searchShow">Search</span>
					</span>
				</div>
				<div class="col-xs-4 section">
					<select class="searchField form-control">
						<option value="_name">Name</option>
						<option value="_product_name">Product Name</option>
						<option value="_price">Price</option>
						<option value="_discount">Discount</option>
						<option value="_finalprice">Final Price</option>
						<option value="_expirydate">Expiry Date</option>
					</select>
				</div>
				<div class="col-xs-4 filterSelect">
					<div class="sectionSearch section">
						<div class="input-group">
							<input type="text" class="searchValue form-control" />
							<span class="input-group-btn">
								<button class="btnSearch btn">Search</button>
								<button class="btnReset btn">Reset</button>
							</span>
						</div>
					</div>
					<div class="sectionSort section">
						<div class="btn-group">
							<span class="btn btn-default btnasc" value="asc">
								<span class="glyphicon glyphicon-arrow-up"></span>
							</span>
							<span class="btn btn-default btndesc" value="desc">
								<span class="glyphicon glyphicon-arrow-down"></span>
							</span>
						</div>
					</div>
				</div>
			</div>
			<div id="couponList" class="row couponDisp">
			</div>
			<div id="couponList_new" class="row couponDisp">
			</div>
		</div>
		<div id="newcoupons" class="tab-pane fade">
			<div class="btnHolder text-center clearfix">
				<div class="col-xs-6">
					<button class="btn btn-info btnManual" data-toggle="modal" data-target=".couponManual">Add coupons manually</button>
				</div>
				<div class="col-xs-6">
					<button class="btn btn-danger btnImport" data-toggle="modal" data-target=".couponImport">Import coupons from file</button>
				</div>
			</div>
		</div>
		<div id="browse" class="tab-pane fade">
			<div id="couponList_others" class="row couponDisp">
			</div>
		</div>
	</div>
  
</div>

<div class="modal fade couponManual" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content panel panel-info">
		<div class="modal-header panel-heading">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button> 
			<h4 class="modal-title">Coupon Details</h4>
		</div>
		<div class="modal-body couponForm">
			<div class="input-group">
				<span class="input-group-addon">Coupon Name</span>
				<input type="text" maxlength="20" class="form-control" name="coupon_name" placeholder="Maximum 20 characters" />
			</div>
			<div class="input-group">
				<span class="input-group-addon">Product Name</span>
				<input type="text" maxlength="20" class="form-control" name="product_name" placeholder="Maximum 20 characters" />
			</div>
			<div class="input-group">
				<span class="input-group-addon">Price</span>
				<input type="number" min="1" class="form-control" name="price" placeholder="USD" />
			</div>
			<div class="input-group">
				<span class="input-group-addon">Discount</span>
				<input type="number" min="0" max="100" class="form-control" name="discount" placeholder="1 - 100" />
			</div>
			<div class="input-group">
				<span class="input-group-addon">Expiry Date</span>
				<input type="date" class="form-control" name="expiry_date" placeholder="MM/DD/YYYY" />
			</div>
			<div class="errMsg"></div>
		</div>
		<div class="modal-footer"> 
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> 
			<button type="button" class="btn btn-info btnAddToList">Save and add another</button> 
		</div>
    </div>
  </div>
</div>

<div class="modal fade couponImport" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content panel panel-danger">
		<div class="modal-header panel-heading"> 
			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button> 
			<h4 class="modal-title">Import Coupon</h4> 
		</div>
		<div class="modal-body couponForm"> 
			<div class="input-group">
				<span class="input-group-addon">Coupons Count</span>
				<input type="number" class="form-control" name="arrLength" placeholder="Number of coupons to be imported" />
			</div>
			
			<!-- <input id="myfile" type="file" accept=".txt" class="form-control" name="coupon_list" placeholder="Coupon Name" /> -->
			<div class="errMsg"></div>
		</div>
		<div class="modal-footer"> 
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button> 
			<button type="button" class="btn btn-danger btnAddToList">Add to list</button> 
		</div>
    </div>
  </div>
</div>


<div id="couponTemplate" class="hidden">
<div class="col-xs-4 couponHolder">
<div class="coupon stitched #status# #new_old#" cid="#coupon_id#">
<div class="cname">#couponName#</div>
<div>#productName#</div>
<div class="price"><span class="old">$#price#</span><span class="new">$#finalprice#</span></div>
<div class="percent">#discount#%</div>
<div class="expiry">#daysToExpire#</div>
<div class="copn_cover">
	<table class="status">
		<tr>
			<td align="center" valign="middle"><span>#status#</span></td>
		</tr>
	</table>
	<table class="action">
		<tr>
			<td align="center" valign="middle">
				<div>
					<button class="btn btn-info btnRedeem" cid="#coupon_id#">Redeem</button>
					<button class="btn btn-info btnDelete" cid="#coupon_id#">Delete</button>
					<button class="btn btn-info btnBuy" cid="#coupon_id#">Add to my list</button>
				</div>
			</td>
		</tr>
	</table>
</div>
<div class="pointer">
	<div class="txt">NEW</div>
</div>
</div>
</div>
</div>

<script>
var newcouponsadded = false;
var sortorder = 'asc';
$(document).ready(function(){
	getUserCoupons();
	getOtherCoupons();
	
	$('#mycoupons .extras .btnReset').click(function(){
		getUserCoupons();
		getOtherCoupons();
	});
	
	
	var dt = new Date();
	dt.setDate(dt.getDate() + 1);
	date = dt.getUTCFullYear() + '-' + (parseInt(dt.getMonth())+1) + '-' + dt.getDate();
	$('.couponManual .couponForm [name="expiry_date"]').attr('min', date)
	
	$('#mycoupons .extras .btnSearch').click(function(){
		$.ajax({
			url: "/user/couponsearch",
			data: {column: $('#mycoupons .extras .searchField').val(), 
				value: $('#mycoupons .extras .searchValue').val()},
		    contentType: "application/json; charset=utf-8",
		    success: function(result) {
		    	result = JSON.parse(result);
		    	if(!result.error){
		    		$('#couponList').html('')
			    	populateCoupons_user(result ,'couponList')
		    	}
		    	else{
		    		$('#couponList').html('<h2 class="errMsg text-center">'+result.error+'</h2>')
		    		console.log(result.error)
		    	}
		    },
		    error: function(err) {
		    	alert("error")
		    }
		});
		
	});
	
	$('.couponManual, .couponImport').on('hidden.bs.modal', function (e) {
		$(this).find('.couponForm .form-control').each(function(){
			this.value = "";
		})
		$(this).find('.couponForm .errMsg').html('')
	});
	
	$('.couponManual .btnAddToList').click(function(){
		var inputdata = {};
		inputdata.coupon_name = $('.couponManual .couponForm [name="coupon_name"]').val()
		inputdata.product_name = $('.couponManual .couponForm [name="product_name"]').val()
		inputdata.price = $('.couponManual .couponForm [name="price"]').val()
		inputdata.discount = $('.couponManual .couponForm [name="discount"]').val()
		inputdata.expiry_date = $('.couponManual .couponForm [name="expiry_date"]').val()
		
		$.ajax({
			url: "/user/addcouponstolist_manual",
			data: inputdata,
		    contentType: "application/json; charset=utf-8",
		    success: function(result) {
		    	result = JSON.parse(result);
		    	if(!result.error){
					//console.log(result)
					$('.couponManual .couponForm .form-control').each(function(){
						this.value = "";
					});
					$('.couponManual .couponForm .errMsg').html('')
			        populateCoupons_user(result ,'couponList')
		    	}
		    	else
					$('.couponManual .couponForm .errMsg').html(result.error)
		    		console.log(result.error)
		    },
		    error: function(err) {
		    	alert("error")
		    }
		});
	});
	
	$('.couponImport .btnAddToList').click(function(){
		//var file = $('.couponImport [name="coupon_list"]')[0].files[0]
		//var reader = new FileReader();
		//var inputdata;
		//reader.onload = function(progressEvent){
			//inputdata = this.result;
			$.ajax({
				url: "/user/addcouponstolist_import",
				data: {length: $('.couponImport .couponForm [name="arrLength"]').val()},
			    contentType: "application/json; charset=utf-8",
			    success: function(result) {
			    	result = JSON.parse(result);
			    	if(!result.error){
				    	//console.log(result)
				    	$('.couponImport').modal('hide')
				    	$('.nav-tabs .tab1 a').click();	
				    	populateCoupons_user(result, 'couponList')
			    	}
			    	else
						$('.couponImport .couponForm .errMsg').html(result.error)
			    		console.log(result.error)
		    	},
			    error: function(err) {
			    	alert("error")
			    }
			}); 

		//};
		//reader.readAsText(file);
	});
	
	$('#mycoupons .extras .btnFilterSrt	, #mycoupons .extras .btnFilterSrch').click(function(){
		var c_add = $(this).attr('add')
		$('#mycoupons .extras').removeClass('sortShow').removeClass('searchShow').addClass(c_add)
		$('.btnFilterSrt, .btnFilterSrch').removeClass('btn-primary')
		$(this).addClass('btn-primary')
	});
	
	$('.sectionSort .btnasc, .sectionSort .btndesc').click(function(){
		$('.sectionSort .btnasc, .sectionSort .btndesc').removeClass('btn-primary')
		$(this).addClass('btn-primary')
		sortorder = $(this).attr('value')
		sort()
	});
	
	$('.nav-tabs .tab4 button').click(function(){
		savetodb()
	});

});

function sort(){
	$.ajax({
		url: "/user/couponsort",
		data: {column: $('#mycoupons .extras .searchField').val(), 
			order: sortorder},
	    contentType: "application/json; charset=utf-8",
	    success: function(result) {
	    	result = JSON.parse(result);
	    	//console.log(result)
	    	populateCoupons_user(result ,'couponList')
	    },
	    error: function(err) {
	    	alert("error")
	    }
	});
}

function savetodb(){
	$.ajax({
		url: "/user/savecoupntodb",
		data: {},
	    contentType: "application/json; charset=utf-8",
	    success: function(result) {
	    	getUserCoupons();
	    	getOtherCoupons();
	    },
	    error: function(err) {
	    	alert("error")
	    }
	});
}
function getUserCoupons(){
	$.ajax({
		url: "/user/getUserCoupons",
		data: {},
	    contentType: "application/json; charset=utf-8",
	    success: function(result) {
	    	result = JSON.parse(result);
			if(result.old.length == 0){
		    	$('#couponList').html('<h2 class="errMsg text-center">You do not have any coupons.<br/>Why don\'t you add some to your account.</h2>')
			}
			else{
		    	populateCoupons_user(result, 'couponList')
			}
	    },
	    error: function(err) {
	    	alert("error")
	    }
	});
}
function getOtherCoupons(){
	$.ajax({
		url: "/coupons/getList",
		data: {},
	    contentType: "application/json; charset=utf-8",
	    success: function(result) {
	    	result = JSON.parse(result);
	    	populateCoupons_others(result, 'couponList_others')
	    },
	    error: function(err) {
	    	alert("error")
	    }
	});
}

function populateCoupons_others(result, elmid){
	$('#'+elmid).html("");
	
    //console.log(result)
    for(var i=0; i<result.length; i++){
    	$('#'+elmid).append(populateFields(result[i]));
    }
    triggercouponclick(elmid)
}

function populateCoupons_user(result, elmid){
	if(result.new){
		newcouponsadded = true;
		$('.nav-tabs .tab4').removeClass('hidden')
	}
	else{
		newcouponsadded = false;
		$('.nav-tabs .tab4').addClass('hidden')
	}
	$('#'+elmid).html("");
	//$('#'+elmid+'_new').html("");
	
    //console.log(result)
    for(var i=0; i<result.old.length; i++){
    	$('#'+elmid).append(populateFields(result.old[i]));
    }
    //for(var i=0; i<result.new.length; i++){
    	//$('#'+elmid+'_new').append(populateFields(result.new[i]));
    	//$('#'+elmid).append(populateFields(result.new[i]));
    //}
    triggercouponclick(elmid)
    //triggercouponclick(elmid+'_new')
}
function triggercouponclick(elmid){
	$('#'+elmid+' .coupon .btnRedeem').unbind('click')
    $('#'+elmid+' .coupon .btnRedeem').click(function(){
    	$.ajax({
    		url: "/user/redeemcoupon",
    		data: {'cid': $(this).attr('cid')},
    	    contentType: "application/json; charset=utf-8",
    	    success: function(result) {
    	    	result = JSON.parse(result);
    	    	populateCoupons_user(result ,'couponList')
    	    },
    	    error: function(err) {
    	    	alert("error")
    	    }
    	});
		//alert($(this).attr('cid'));
    });
	$('#'+elmid+' .coupon .btnDelete').unbind('click')
    $('#'+elmid+' .coupon .btnDelete').click(function(){
    	$.ajax({
    		url: "/user/deletecoupon",
    		data: {'cid': $(this).attr('cid')},
    	    contentType: "application/json; charset=utf-8",
    	    success: function(result) {
    	    	result = JSON.parse(result);
    	    	populateCoupons_user(result ,'couponList')
    	    },
    	    error: function(err) {
    	    	alert("error")
    	    }
    	});
		//alert($(this).attr('cid'));
    });
	
	$('#'+elmid+' .coupon .btnBuy').unbind('click')
    $('#'+elmid+' .coupon .btnBuy').click(function(){
    	$(this).parents('.couponHolder').hide();
    	$.ajax({
    		url: "/user/buycoupon",
    		data: {'cid': $(this).attr('cid')},
    	    contentType: "application/json; charset=utf-8",
    	    success: function(result) {
    	    	result = JSON.parse(result);
    	    	populateCoupons_user(result ,'couponList')
    	    },
    	    error: function(err) {
    	    	alert("error")
    	    }
    	});
		//alert($(this).attr('cid'));
    });
	
}
function populateFields(res){
	var cTemplate = $('#couponTemplate').html();
	cTemplate = cTemplate.replace(/#coupon_id#/g, res._cID);
	cTemplate = cTemplate.replace(/#couponName#/g, res._name);
	cTemplate = cTemplate.replace(/#productName#/g, res._product_name);
	cTemplate = cTemplate.replace(/#price#/g, res._price);
	cTemplate = cTemplate.replace(/#discount#/g, res._discount);
	cTemplate = cTemplate.replace(/#status#/g, res._status);
	
	if((res._status == 'unused' && !res._saved))
		cTemplate = cTemplate.replace(/#new_old#/g, 'new');
	else
		cTemplate = cTemplate.replace(/#new_old#/g, '');
	
	if(res._daystoexpiry > 0)
		cTemplate = cTemplate.replace(/#daysToExpire#/g, 'expires in <span>' + res._daystoexpiry + '</span> days');
	else if(res._daystoexpiry == 0)
		cTemplate = cTemplate.replace(/#daysToExpire#/g, 'expires <span>today</span>');
	else{
		cTemplate = cTemplate.replace(/#daysToExpire#/g, 'expired <span>' + Math.abs(res._daystoexpiry) + '</span> days ago');
	}
	cTemplate = cTemplate.replace(/#finalprice#/g, res._finalprice);
	return cTemplate;
}
</script>
