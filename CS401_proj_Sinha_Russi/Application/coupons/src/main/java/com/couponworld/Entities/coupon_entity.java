package com.couponworld.Entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class coupon_entity {
	private int _cID;
	private String _name; //(max 20)
	private String _product_name; //(max 20)
	private int _price; //(currency)
	private int _discount; //(%)
	private float _finalprice; //(currency)
	private Date _expirydate;
	private int _daystoexpiry;
	private String _status; //(redeemed/unused)
	private boolean _taken;
	private boolean _saved = false;
	private String _type;
	
	
	public coupon_entity(String name, String prodname, int price, int discount, Date expirydate, String status, boolean taken) throws Exception {
		this._name = name;
		if(_name.length() > 20)
			throw new Exception("Coupon name cannot be more than 20 characters");
		this._product_name = prodname;
		if(_product_name.length() > 20)
			throw new Exception("Product name cannot be more than 20 characters");
		this._price = price;
		this._discount = discount;
		if(_name.length() > 20)
			throw new Exception("Discount should be between 1-99%");
		this._expirydate = expirydate;
		this._status = status;
		this._taken = taken;
		set_daystoexpiry();
		set_finalprice();
		if(_daystoexpiry <= 0)
			throw new Exception("Invalid date");
	}
	public coupon_entity() {
	}
	
	public boolean is_saved() {
		return _saved;
	}
	public void set_saved(boolean _saved) {
		this._saved = _saved;
	}
	
	public int get_cID() {
		return _cID;
	}
	public void set_cID(int _id) {
		this._cID = _id;
	}
	
	public String get_name() {
		return _name;
	}
	public void set_name(String _name) {
		this._name = _name;
	}
	
	public String get_product_name() {
		return _product_name;
	}
	public void set_product_name(String _product_name) {
		this._product_name = _product_name;
	}
	
	public int get_price() {
		return _price;
	}
	public void set_price(int _price) {
		this._price = _price;
		set_finalprice();
	}
	
	public int get_discount() {
		return _discount;
	}
	public void set_discount(int _discount) {
		this._discount = _discount;
		set_finalprice();
	}
	
	public float get_finalprice() {
		return _finalprice;
	}
	public void set_finalprice() {
		this._finalprice = (float) ((double)this._price - ((double)this._price * ((double)this._discount/100)));
	}
	
	public Date get_expirydate() {
		return _expirydate;
	}
	public void set_expirydate(Date _expirydate) {
		this._expirydate = _expirydate;
		set_daystoexpiry();
	}
	
	public int get_daystoexpiry() {
		return _daystoexpiry;
	}
	public void set_daystoexpiry() {
		Date dt = this._expirydate;
		Date dt2 = new Date();
	    long diff = dt.getTime() - dt2.getTime();
	    this._daystoexpiry = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public boolean is_taken() {
		return _taken;
	}
	public void set_taken(boolean _taken) {
		this._taken = _taken;
	}
	
	public String get_status() {
		return _status;
	}
	public void set_status(String string) {
		this._status = string;
	}
	
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	
	public Object getField(String var) {
		switch(var) {
		case "_name":{return _name;}
		case "_product_name":{return _product_name;}
		case "_price":{return _price;}
		case "_discount":{return _discount;}
		case "_finalprice":{return _finalprice;}
		case "_expirydate":{return _expirydate;}
		case "_daystoexpiry":{return _daystoexpiry;}
		case "_status":{return _status;}
		}
		return var;
	}
	
	
	@Override
	public String toString() {
		String status = _status;
		if (_daystoexpiry < 0)
			status = "expired";
		return "{\"_name\":\"" + _name + "\", \"_product_name\":\"" + _product_name + "\", \"_price\":\"" + _price + "\", \"_discount\":\"" + _discount + "\", \"_expirydate\":\"" + _expirydate + "\", \"_daystoexpiry\":\"" + _daystoexpiry + "\", \"_status\":\"" + status + "\", \"_taken\":\"" + _taken + "\",\"_cID\":\"" + _cID + "\", \"_finalprice\":\"" + _finalprice + "\",\"_saved\":" + _saved + ",\"_type\":\"" + _type + "\"}";
	}
	
}
