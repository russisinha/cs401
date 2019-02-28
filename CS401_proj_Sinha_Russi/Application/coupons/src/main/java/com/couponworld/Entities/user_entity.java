package com.couponworld.Entities;

public class user_entity {
	private int _userid;
	private String _loginid;
	private String _password;
	private String _user_name;
	private int _age;
	private Linked_list _list;
	private boolean _new = false;
	
	public user_entity(){
		_list = new Linked_list();
	}
	
	public Linked_list get_list() {
		return _list;
	}
	public void set_list(Linked_list list) {
		this._list = list;
	}
	
	public int get_userid() {
		return _userid;
	}
	public void set_userid(int _userid) {
		this._userid = _userid;
	}
	
	public void set_loginid(String _loginid) {
		this._loginid = _loginid;
	}
	public String get_loginid() {
		return _loginid;
	}
	
	public String get_password() {
		return _password;
	}
	public void set_password(String _password) {
		this._password = _password;
	}
	
	public String get_user_name() {
		return _user_name;
	}
	public void set_user_name(String _user_name) {
		this._user_name = _user_name;
	}
	
	public int get_age() {
		return _age;
	}
	public void set_age(int _age) {
		this._age = _age;
	}
	
	public boolean is_new() {
		return _new;
	}
	public void set_new(boolean _new) {
		this._new = _new;
	}
	
}
