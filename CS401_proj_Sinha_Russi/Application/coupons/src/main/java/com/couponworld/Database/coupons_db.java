package com.couponworld.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.couponworld.Entities.*;
import com.couponworld.common.constants;

public class coupons_db {
	
	public Linked_list coupons_getList(int userid){
		return getcouponlist("SELECT couponList.* FROM couponList INNER JOIN user_coupon ON couponList.ID = user_coupon.couponid WHERE (((user_coupon.userid)=" + userid + "))");
	}
	
	public Linked_list coupons_getList(){
		return getcouponlist("select * from couponList where taken = False");
	}
	
	private Linked_list getcouponlist(String query) {
		Linked_list list = new Linked_list();
		try {
			Class.forName(constants.className);
			Connection conn = DriverManager.getConnection(constants.dbName);
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				coupon_entity cn = new coupon_entity();
				cn.set_cID(rs.getInt("ID"));
				cn.set_name(rs.getString("coupName"));
				cn.set_product_name(rs.getString("prodName"));
				cn.set_price(rs.getInt("price"));
				cn.set_discount(rs.getInt("discount"));
				cn.set_status(rs.getString("status"));
				cn.set_expirydate(rs.getDate("expiryDate"));
				cn.set_taken(rs.getBoolean("taken"));
				cn.set_saved(true);
				
				list.add(cn);
			}
			st.close();
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public void savecoupntodb(coupon_entity ce, int userid) {
		try {
			String query = "insert into couponList(coupName, prodName, price, discount, expiryDate, status, taken) values(?, ?, ?, ?, ?, ?, ?)";
			Class.forName(constants.className);
			Connection conn = DriverManager.getConnection(constants.dbName);
			PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, ce.get_name());
			st.setString(2, ce.get_product_name());
			st.setInt(3, ce.get_price());
			st.setInt(4, ce.get_discount());
			st.setDate(5, new java.sql.Date(ce.get_expirydate().getTime()));
			st.setString(6, ce.get_status());
			st.setBoolean(7, true);
			
			int affectedRows = st.executeUpdate();
	        if (affectedRows == 0) {
	            System.out.println("Creating user failed, no rows affected.");
	        }
	        ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
            	int coupon_id = (int) generatedKeys.getInt(1);
            	Statement st2=conn.createStatement();
            	st2.executeUpdate("insert into user_coupon(userid, couponid) values("+userid+","+coupon_id+")");
            	st2.close();
            }
            else {
            	System.out.println("Creating user failed, no ID obtained.");
            }
			st.close();
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void savecoupntodb_transfer(coupon_entity ce, int userid) {
		try {
			String query = "update couponList set taken=true where ID="+ ce.get_cID();
			String query2 = "insert into user_coupon(userid, couponid) values("+userid+","+ce.get_cID()+")";
			Class.forName(constants.className);
			Connection conn = DriverManager.getConnection(constants.dbName);
			
			Statement st=conn.createStatement();
			st.executeUpdate(query);
			st.close();
			
			Statement st2=conn.createStatement();
			st2.executeUpdate(query2);
			st2.close();
			
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void redeemcoupon(int cid, String status) {
		try {
			String query = "update couponList set status = '"+status+"' where ID="+cid;
			Class.forName(constants.className);
			Connection conn = DriverManager.getConnection(constants.dbName);
			Statement st=conn.createStatement();
			st.executeUpdate(query);
			
			st.close();
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletecoupon(int cid, int uid) {
		try {
			String query1 = "delete from user_coupon where userid="+uid+" and couponid="+cid;
			String query2 = "delete from couponList where couponid="+cid;
			Class.forName(constants.className);
			Connection conn = DriverManager.getConnection(constants.dbName);
			Statement st=conn.createStatement();
			st.executeUpdate(query1);
			st.close();
			
			Statement st2=conn.createStatement();
			st2.executeUpdate(query2);
			
			st2.close();
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
