package com.couponworld.Interface;

import com.couponworld.Entities.user_entity;

public interface user_data_interface {
	public user_entity checkUser(String loginid, String password);
	public user_entity saveUser(String name, String loginid, String password);
}
