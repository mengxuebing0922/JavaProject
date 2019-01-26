package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.CakeBean;
import Dao.DataBase;

public class CakeDao {
	
	/**
	 * 查询所有蛋糕
	 */
	public List<CakeBean> getAllCake() {
		List<CakeBean> CakeList = new ArrayList<CakeBean>();
		Connection conn = DataBase.getConnection();

		PreparedStatement pstmt = null;
		String sql = "select cake_id,cake_name,cake_size,cake_price,cake_image_url,cake_type_id from cake";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CakeBean cakeBean = new CakeBean(
						rs.getInt("cake_id"), 
						rs.getString("cake_name"),
						rs.getString("cake_size"), 
						rs.getDouble("cake_price"),
						rs.getString("cake_image_url"),
						rs.getInt("cake_type_id"));
				CakeList.add(cakeBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CakeList;
	}
	

	/**
	 * 查询id
	 */
	
	public int SelectId() {
		Connection conn = DataBase.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("select * from cake order by cake_id desc limit 1");
			ResultSet rs;
			rs = pstmt.executeQuery();
			int id=0;
			while (rs.next()) {            	
            	id=rs.getInt("cake_id");
			} 
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}
	/**
	 * 添加商品
	 */
	public int insert(int cakeId,String cakeName,String cakeSize,Double cakePrice,String cakeImageUrl,int cakeTypeId) {
		Connection conn = DataBase.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into cake values(?,?,?,?,?,?)");
			pstmt.setInt(1,cakeId+1);
			pstmt.setString(2, cakeName);
			pstmt.setString(3, cakeSize);
			pstmt.setDouble(4,cakePrice);
			pstmt.setString(5,cakeImageUrl);
			pstmt.setInt(6,cakeTypeId);
			int rs = pstmt.executeUpdate();
			return rs; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	public int delete(int id) {
		Connection conn = DataBase.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement("delete from cake where cake_id=?");
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
