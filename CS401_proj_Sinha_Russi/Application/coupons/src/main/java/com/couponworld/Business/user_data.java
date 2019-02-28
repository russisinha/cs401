package com.couponworld.Business;

import com.couponworld.Database.user_db;
import com.couponworld.Entities.user_entity;
import com.couponworld.Interface.user_data_interface;

public class user_data implements user_data_interface{
	public user_entity checkUser(String loginid, String password) {
		user_db ud = new user_db();
		user_entity user = ud.usercheck(loginid, password);
		return user;
	}

	public user_entity saveUser(String name, String loginid, String password) {
		user_db ud = new user_db();
		user_entity user = ud.usersave(name, loginid, password);
		return user;
	}
}
