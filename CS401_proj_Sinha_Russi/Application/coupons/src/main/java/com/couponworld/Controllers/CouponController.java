package com.couponworld.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.couponworld.Business.*;
import com.couponworld.Entities.Linked_list;
import com.couponworld.Interface.coupon_data_interface;


@Controller
public class CouponController {
	
	@RequestMapping(value = "/coupons", method = RequestMethod.GET)
	public String couponlist() {
		return "couponlist";
	}
	
	@RequestMapping(value = "/coupons/getList", method = RequestMethod.GET)
	@ResponseBody
	public String coupons_getList() {
		coupon_data_interface c = new coupon_data();
		Linked_list ll = c.coupons_getList();
		String ll_json = c.coupons_json();
		return ll_json;
	}
	
}
