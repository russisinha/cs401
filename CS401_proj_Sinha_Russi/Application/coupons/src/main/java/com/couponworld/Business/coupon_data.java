package com.couponworld.Business;

import java.text.ParseException;

import com.couponworld.Database.coupons_db;
import com.couponworld.Entities.*;
import com.couponworld.Interface.coupon_data_interface;

public class coupon_data implements coupon_data_interface{
	private Linked_list list;
	public Linked_list coupons_getList(int userid){
		coupons_db c = new coupons_db();
		list = c.coupons_getList(userid);
		
		return list;
	}
	
	public Linked_list coupons_getList() {
		coupons_db c = new coupons_db();
		list = c.coupons_getList();
		
		return list;
	}
	
	public void set_List(Linked_list lst) {
		this.list = lst;
	}
	
	public String coupons_json() {
		List_iterator iter = list.list_iterator();
		String res = "[";
		while(iter.hasNext()) {
			coupon_entity ent = iter.next();
			res += ent;
			if(iter.hasNext()) {
				res += ",";
			}
		}
		res += "]";
		return res;
	}
	
	public void savecoupntodb(user_entity user) throws ParseException {
		coupons_db cd = new coupons_db();
		Linked_list ll = user.get_list();
		int num = ll.getFirst();
		
		while(num != -1) {
			coupon_entity c = ll.lln[num].getInfo();
			
			if(!c.is_saved()) {
				if(c.get_type() == "transfer")
					cd.savecoupntodb_transfer(c, user.get_userid());
				else
					cd.savecoupntodb(c, user.get_userid());
				c.set_saved(true);
			}
			num = ll.lln[num].getLink();
		}
	}
	
	public Linked_list sort(Linked_list ll, String column, String order) throws ParseException {
		int num = ll.getFirst();
		
		while(num != -1) {
			LL_Node node = ll.lln[num];
			int num1 = node.getLink();
			
			while(num1 != -1) {
				LL_Node node1 = ll.lln[num1];
				if(checkorder(node, node1, column, order)) {
					coupon_entity temp = node1.getInfo();
					node1.setInfo(node.getInfo());
					node.setInfo(temp);
				}
				num1 = node1.getLink();
			}
			//ll_sorted.sortadd(node, column);
			num = node.getLink();
		}
		return ll;
	}
	
	private boolean checkorder(LL_Node node1, LL_Node node2, String column, String order) throws ParseException {
		if(order == "asc")
			return (node1.comparevar(node2, column) > 0);
		else
			return (node1.comparevar(node2, column) <= 0);
	}
	
	public int search(Linked_list ll, String column, String value) {
		
		try {
			sort(ll, column, "asc");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int first = 0;
		int last = ll.size() - 1;
		try {
			double start, end;
			s_count = 0;
			System.out.println("Binary search");
			start = System.nanoTime();
			int s = binarysearch(ll, column, value, first, last);
			end = System.nanoTime() - start;
			System.out.println("index="+s);
			System.out.println("time="+end+"ns");
			System.out.println("count="+s_count);
			
			System.out.println("Linear search");
			start = System.nanoTime();
			int l = linearsearch(ll, column, value);
			end = System.nanoTime() - start;
			System.out.println("index="+l);
			System.out.println("time="+end+"ns");
			System.out.println("count="+l_count);
			return s;
		} catch (ParseException e) {
			
		}
		return -1;
		
	}
	
	static int s_count;
	private int binarysearch(Linked_list ll, String column, String value, int first, int last) throws ParseException {
		s_count++;
		int midpoint = (first + last)/2;
		if(first > last)
			return -1;
		else {
			if(ll.lln[midpoint].comparevar(value, column) == 0)
				return midpoint;
			else {
				if(ll.lln[midpoint].comparevar(value, column) < 0) {
					return binarysearch(ll, column, value, midpoint + 1, last);
				}
				else {
					return binarysearch(ll, column, value, first, midpoint - 1);
				}
			}
		}
	}
	
	static int l_count;
	private int linearsearch(Linked_list ll, String column, String value) throws ParseException {
		l_count = 0;
		for(int i = 0; i < ll.size(); i++) {
			l_count++;
			if(ll.lln[i].comparevar(value, column) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public void redeemcoupon(Linked_list ll, int cid) {
		int num = ll.getFirst();
		while(num != -1) {
			LL_Node node = ll.lln[num];
			if (node.getInfo().get_cID() == cid) {
				node.getInfo().set_status("redeemed");
				coupons_db cd = new coupons_db();
				cd.redeemcoupon(cid, "redeemed");
				return;
			}
			num = node.getLink();
		}
	}
	
	public void deletecoupon(int cid, int uid, Linked_list ll) {
		int num = ll.getFirst();
		LL_Node prev = null;
		while(num != -1) {
			LL_Node node = ll.lln[num];
			if (node.getInfo().get_cID() == cid) {
				//coupons_db cd = new coupons_db();
				//cd.deletecoupon(cid, uid);
				ll.removeAt(prev, node);
				return;
			}
			prev = node;
			num = node.getLink();
		}
	}
	
	public void buycoupon(int cid, Linked_list ll, Linked_list u_ll) {
		int num = ll.getFirst();
		LL_Node prev = null;
		while(num != -1) {
			LL_Node node = ll.lln[num];
			if (node.getInfo().get_cID() == cid) {
				//coupons_db cd = new coupons_db();
				//cd.deletecoupon(cid, uid);
				coupon_entity n = ll.removeAt(prev, node);
				n.set_saved(false);
				n.set_type("transfer");
				u_ll.add(n);
				return;
			}
			prev = node;
			num = node.getLink();
		}
	}
	
	
}
