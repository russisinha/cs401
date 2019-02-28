<div>
list of coupons:
</div>
<div id="couponList" class="clearfix">
</div>

<div id="couponTemplate" class="hidden">
<div class="col-xs-4" style="border: 1px solid green" cid="#coupon_id#">
<div>#couponName#</div>
<div>#productName#</div>
<div>#price#</div>
<div>#discount#</div>
<div>#status#</div>
<div>expires in #daysToExpire# days</div>
</div>
</div>

<script>
$(document).ready(function(){
	$.ajax({
		url: "/coupons/getList",
		data: {},
	    contentType: "application/json; charset=utf-8",
	    success: function(result) {
	    	result = JSON.parse(result);
	        console.log(result)
	        for(var i=0; i<result.length; i++){
	        	$('#couponList').append(populateFields(result[i]));
	        }
	    },
	    error: function(err) {
	    	alert("error")
	    }
	});
});
function populateFields(res){
	var cTemplate = $('#couponTemplate').html();
	var cTemplate = cTemplate.replace('#coupon_id#', res._cID);
	var cTemplate = cTemplate.replace('#couponName#', res._name);
	var cTemplate = cTemplate.replace('#productName#', res._product_name);
	var cTemplate = cTemplate.replace('#price#', res._price);
	var cTemplate = cTemplate.replace('#discount#', res._discount);
	var cTemplate = cTemplate.replace('#status#', res._status);
	var cTemplate = cTemplate.replace('#daysToExpire#', res._daystoexpiry);
	return cTemplate;
}
</script>
