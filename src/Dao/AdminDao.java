package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.AdminBean;
import bean.CakeBean;
import Dao.DataBase;

public class AdminDao {
	
	/**
	 * 查询用户名
	 */
	public String SelectUser(String userName) {
		Connection conn = DataBase.getConnection();		
		PreparedStatement pstmt = null;
		String sql = "select admin_name from admin where admin_name=?";
		String p=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			ResultSet rs= pstmt.executeQuery();
            while (rs.next()) {
            	p=rs.getString("admin_name");
			 } 
           return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	/**
	 * 查询密码
	 */
	public String Selectpassword(String password) {
		   
		Connection conn = DataBase.getConnection();		
		PreparedStatement pstmt = null;
		String sql = "select admin_password from admin where admin_password=?";
		String q=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			ResultSet rs;
			rs = pstmt.executeQuery();
            while (rs.next()) {            	
            	q=rs.getString("admin_password");
			 } 
           return q;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	/**
	 * 查询id
	 */
	
	public int SelectId() {
		Connection conn = DataBase.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("select * from admin order by admin_id desc limit 1");
			ResultSet rs = pstmt.executeQuery();
			int id=0;
			while (rs.next()) {            	
            	id=rs.getInt("admin_id");
			} 
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;	
		}
		
	}
	/**
	 * 添加管理员
	 */
	public int insert(int adminId,String adminName,String adminpassword,String adminrealName,String adminEmail) {
		Connection conn = DataBase.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into admin values(?,?,?,?,?)");
			pstmt.setInt(1,adminId+1);
			pstmt.setString(2,adminName);
			pstmt.setString(3,adminpassword);
			pstmt.setString(4,adminrealName);
			pstmt.setString(5,adminEmail);
			int rs = pstmt.executeUpdate();
			return rs; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	//忘记密码
	public String pickPwd(String tm) {
		Connection conn = DataBase.getConnection();
		PreparedStatement pstmt = null;
		try {
			String password = null;
			String sql = "select user_password from user where user_email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,tm);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				password = rs.getString("user_password");
			}
			return password;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
