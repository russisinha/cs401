package com.couponworld.Controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.couponworld.Business.*;
import com.couponworld.Entities.*;
import com.couponworld.Interface.coupon_data_interface;
import com.couponworld.common.constants;

@Controller
@SessionAttributes("userdetails")
public class UserController {
	
	@ModelAttribute("userdetails")
	public user_entity populateLoans() {
	    return new user_entity();
	}
	
	@RequestMapping(value="/user")
	public String checkuser(@ModelAttribute("userdetails") user_entity user) {
		if(user.get_userid() == 0)
			return "redirect:login";
		else
			return "user";
	}
	
	@RequestMapping(value="/user/getUserCoupons")
	@ResponseBody
	public String coupons_getList(@ModelAttribute("userdetails") user_entity user, ModelMap model) {
		coupon_data_interface c = new coupon_data();
		c.set_List(user.get_list());
		String ll_json = c.coupons_json();
		
		return "{\"old\":" + ll_json + ",\"new\":"+user.is_new()+"}";
	}
	
	@RequestMapping(value="/user/addcouponstolist_import")
	@ResponseBody
	public String coupons_addtolist_import(@ModelAttribute("userdetails") user_entity user, @RequestParam int length,
			ModelMap model) {
		readfile_data rd = new readfile_data();
		
		Linked_list lt = null;
		try {
			lt = rd.readfile(length, constants.filepath);
			user.get_list().add(lt);
			user.set_new(true);
			
			//model.put("userdetails", user);
		} catch (Exception e) {
			return "{\"error\":\""+e.getMessage()+"\"}";
			//e.printStackTrace();
		}
		return coupons_getList(user, model);
	}
	
	@RequestMapping(value="/user/addcouponstolist_manual")
	@ResponseBody
	public String coupons_addtolist_manual(@ModelAttribute("userdetails") user_entity user, @RequestParam String coupon_name,
			@RequestParam String product_name, @RequestParam int price, @RequestParam int discount, 
			@RequestParam String expiry_date, ModelMap model) throws ParseException {
		
		Date expiry = constants.convertToDate(expiry_date);
		coupon_entity cn;
		try {
			cn = new coupon_entity(coupon_name, product_name, price, discount, expiry, "unused", true);
		} catch (Exception e) {
			return "{\"error\":\""+e.getMessage()+"\"}";
			//e.printStackTrace();
		}
		user.get_list().add(cn);
		user.set_new(true);
		//model.put("userdetails", user);
		
		return coupons_getList(user, model);
	}
	
	@RequestMapping(value="/user/savecoupntodb")
	@ResponseBody
	public String savecoupntodb(@ModelAttribute("userdetails") user_entity user, ModelMap model) throws ParseException {
		coupon_data_interface cp = new coupon_data();
		cp.set_List(user.get_list());
		System.out.println(1);
		cp.savecoupntodb(user);
		//user.get_list().add(cp.savecoupntodb(user));
		//user.set_list(ll);
		//model.put("userdetails", user);
		user.set_new(false);
		
		return "saved";
	}
	
	@RequestMapping(value="/user/couponsort")
	@ResponseBody
	public String sort(@ModelAttribute("userdetails") user_entity user, ModelMap model, String column, String order) {
		coupon_data_interface cd = new coupon_data();
		try {
			cd.sort(user.get_list(), column, order);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return coupons_getList(user, model);
	}
	
	@RequestMapping(value="/user/couponsearch")
	@ResponseBody
	public String search(@ModelAttribute("userdetails") user_entity user, ModelMap model, String column, String value) {
		coupon_data_interface cd = new coupon_data();
		String ll_json = null;
		//try {
		System.out.println(1111);
			int index = cd.search(user.get_list(), column, value);
			System.out.println(2222);
			Linked_list ll = new Linked_list();
			System.out.println(3333);
			try {
				ll.add(user.get_list().lln[index].getInfo());
			}
			catch(Exception e){
				return "{\"error\":\"Coupon not found.\"}";
			}
			cd.set_List(ll);
			ll_json = cd.coupons_json();
		//}
		//catch (Exception e) {
			//return "{\"error\":\"Coupon not found\"}";
		//}
		return "{\"old\":" + ll_json + ",\"new\":false}";
		//return coupons_getList(user, model);
	}
	
	@RequestMapping(value="/user/redeemcoupon")
	@ResponseBody
	public String redeemcoupon(@ModelAttribute("userdetails") user_entity user, ModelMap model, int cid) {
		coupon_data_interface cd = new coupon_data();
		cd.redeemcoupon(user.get_list(), cid);
		return coupons_getList(user, model);
	}
	
	@RequestMapping(value="/user/deletecoupon")
	@ResponseBody
	public String deletecoupon(@ModelAttribute("userdetails") user_entity user, ModelMap model, int cid) {
		coupon_data_interface cd = new coupon_data();
		cd.deletecoupon(cid, user.get_userid(), user.get_list());		
		return coupons_getList(user, model);
	}
	
	@RequestMapping(value="/user/buycoupon")
	@ResponseBody
	public String buycoupon(@ModelAttribute("userdetails") user_entity user, ModelMap model, int cid) {
		coupon_data_interface cd = new coupon_data();
		Linked_list ll = cd.coupons_getList();
		cd.buycoupon(cid, ll, user.get_list());	
		user.set_new(true);
		return coupons_getList(user, model);
	}
	
}
