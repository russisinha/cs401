package com.couponworld.Entities;

import java.text.ParseException;
import java.util.Date;

public class LL_Node {
	private coupon_entity info;
	private int link;
	
	public LL_Node(coupon_entity e) {
		this.setInfo(e);
		this.setLink(-1);
	}
	public LL_Node() {
		this.setInfo(null);
		this.setLink(-1);
	}

	public coupon_entity getInfo() {
		return info;
	}
	public void setInfo(coupon_entity info) {
		this.info = info;
	}
	
	public int getLink() {
		return link;
	}
	public void setLink(int link) {
		this.link = link;
	}
	
	public int comparevar(LL_Node node, String column) throws ParseException {
		return compare(column, this.getInfo().getField(column), node.getInfo().getField(column));
	}
	
	public int comparevar(String nodevalue, String column) throws ParseException {
		return compare(column, this.getInfo().getField(column), (Object) nodevalue);
	}
	
	private int compare(String fname, Object f1, Object f2) throws ParseException {
		
		String val1, val2;
		Date val3, val4;
		int val5, val6;
		float val7, val8;
		System.out.println("switch");

		switch(fname) {
			case "_name":
			case "_product_name":
			case "_status":{
				val1 = (String) f1; 
				val2 = (String) f2;
				return val1.compareTo(val2);
			}
			case "_finalprice":{
				val7 = (float) f1;
				val8 = (float) f2;
				int returnVal = 0;
				if(val7 > val8)
					returnVal = 1;
				else if(val7 < val8)
					returnVal = -1;
				return returnVal;
			}
			case "_price":
			case "_discount":{
				val5 = Integer.parseInt((String) f1);
				val6 = Integer.parseInt((String) f2);
				System.out.println(val5);
				System.out.println(val6);
				int returnVal = 0;
				if(val5 > val6)
					returnVal = 1;
				else if(val5 < val6)
					returnVal = -1;
				return returnVal;
			}
			case "_expirydate":{
				val3 = (Date) f1;
				val4 = (Date) f2;
				return val3.compareTo(val4);
			}
			default:{return 0;}
		}

	}
	
	
	@Override
	public String toString() {
		return info.toString();
	}
	
}
