package com.couponworld.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.couponworld.Entities.coupon_entity;
import com.couponworld.Entities.user_entity;
import com.couponworld.common.constants;

public class user_db {
	public user_entity usercheck(String loginid, String password) {
		user_entity user = null;
		try {
			Class.forName(constants.className);
			Connection conn = DriverManager.getConnection(constants.dbName);
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT user.ID, userdetails.username, userdetails.age FROM [user] INNER JOIN userdetails ON user.ID = userdetails.userid WHERE (((user.loginid)='" + loginid + "') AND ((user.password)='" + password + "'))");
			
			while(rs.next()) {
				user = new user_entity();
				user.set_userid(rs.getInt("ID"));
				user.set_user_name(rs.getString("username"));
				user.set_age(rs.getInt("age"));
				break;
			}
			st.close();
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return user;
	}
	
	public user_entity usersave(String name, String loginid, String password) {
		user_entity user = null;
		try {
			String query = "insert into user(loginid, password) values('"+loginid+"','"+password+"')";
			Class.forName(constants.className);
			Connection conn = DriverManager.getConnection(constants.dbName);
			PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			int affectedRows = st.executeUpdate();
	        if (affectedRows == 0) {
	            System.out.println("Creating user failed, no rows affected.");
	        }
	        ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
            	int id = (int) generatedKeys.getInt(1);
            	Statement st2=conn.createStatement();
            	st2.executeUpdate("insert into userdetails(username, userid) values('"+name+"',"+id+")");
            	st2.close();
            	user = usercheck(loginid, password);
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
		return user;
	}
	
	
}
