package com.couponworld.Interface;

import java.text.ParseException;

import com.couponworld.Entities.LL_Node;
import com.couponworld.Entities.Linked_list;
import com.couponworld.Entities.user_entity;

public interface coupon_data_interface {
	public Linked_list coupons_getList(int userid);
	public Linked_list coupons_getList();
	public String coupons_json();
	public void set_List(Linked_list lst);
	public void savecoupntodb(user_entity user) throws ParseException;
	public Linked_list sort(Linked_list ll, String column, String order) throws ParseException;
	public int search(Linked_list ll, String column, String value);
	public void redeemcoupon(Linked_list ll, int cid);
	public void deletecoupon(int cid, int uid, Linked_list ll);
	public void buycoupon(int cid, Linked_list ll, Linked_list u_ll);
}
