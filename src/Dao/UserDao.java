package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Type;

import bean.CakeBean;
import bean.UserBean;

public class UserDao {
    
	/**
	 * 查询所有用户
	 */
	public List<UserBean> getAllUser() {
		List<UserBean> UserList = new ArrayList<UserBean>();
		Connection conn = DataBase.getConnection();

		PreparedStatement pstmt = null;
		String sql = "select user_id,user_name,user_password,user_email,user_address,user_telephone from user";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				UserBean userBean = new UserBean(
						rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("user_password"), 
						rs.getString("user_email"),
						rs.getInt("user_telephone"),
						rs.getString("user_address"));
				UserList.add(userBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UserList;
	}
	public int delete(int id) {
		Connection conn = DataBase.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement("delete from user where user_id=?");
			pstmt.setInt(1,id);
			int rs = pstmt.executeUpdate();
			return rs; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
}