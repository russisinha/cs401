package com.couponworld.Interface;

import java.text.ParseException;

import com.couponworld.Entities.*;

public interface Linked_list_interface {
	public List_iterator list_iterator();
	public int getFirst();
	public void add(Linked_list list);
	public void add(coupon_entity e);
	public int size();
	public coupon_entity remove();
	public coupon_entity removeAt(LL_Node prev, LL_Node curr);
	public boolean is_full();
	public boolean is_empty();
	public void sortadd(LL_Node node, String column) throws ParseException;
}
