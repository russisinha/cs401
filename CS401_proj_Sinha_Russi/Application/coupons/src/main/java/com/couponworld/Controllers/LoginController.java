package com.couponworld.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.couponworld.Business.coupon_data;
import com.couponworld.Business.user_data;
import com.couponworld.Entities.Linked_list;
import com.couponworld.Entities.user_entity;
import com.couponworld.Interface.coupon_data_interface;
import com.couponworld.Interface.user_data_interface;

@Controller
@SessionAttributes("userdetails")
public class LoginController {
	
	@ModelAttribute("userdetails")
	public user_entity populate() {
	    return new user_entity();
	}
	
	@RequestMapping(value = "/")
	public String welcome(@ModelAttribute("userdetails") user_entity user) {
		if(user.get_userid() == 0)
			return "welcome";
		else
			return "redirect:user";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("userdetails") user_entity user) {
		if(user.get_userid() == 0)
			return "login";
		else
			return "redirect:user";
	}
	
	@RequestMapping(value = "/login/check", method = RequestMethod.GET)
	@ResponseBody
	public String logincheck(@RequestParam String loginid, @RequestParam String password, ModelMap model) {
		user_data_interface udt = new user_data();
		String msg;
		if(loginid == "" || password == "") {
			return "Please provide both fields.";
		}
		
		user_entity _user = udt.checkUser(loginid, password);
		if(_user == null)
			msg = "Invalid User ID or Password. Try again.";
		else {
			msg = "success";
			coupon_data_interface c = new coupon_data();
			
			Linked_list ll = c.coupons_getList(_user.get_userid());
			_user.set_list(ll);
			
			model.put("userdetails", _user);
		}
		return msg;
	}
	
	@RequestMapping(value = "/login/signup", method = RequestMethod.GET)
	@ResponseBody
	public String signup(@RequestParam String name, @RequestParam String loginid, @RequestParam String password, ModelMap model) {
		user_data_interface udt = new user_data();
		String msg = "success";
		if(name == "" || loginid == "" || password == "") {
			return "Please provide all fields.";
		}
		
		user_entity _user = udt.checkUser(loginid, password);
		if(_user == null) {
			_user = udt.saveUser(name, loginid, password);
			coupon_data_interface c = new coupon_data();
			
			Linked_list ll = c.coupons_getList(_user.get_userid());
			_user.set_list(ll);
			
			model.put("userdetails", _user);
		}
		else {
			msg = "User already exists.";
		}
		return msg;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(@ModelAttribute("userdetails") user_entity user, ModelMap model) {
		model.put("userdetails", new user_entity());
		return "redirect:login";
	}

	
}
