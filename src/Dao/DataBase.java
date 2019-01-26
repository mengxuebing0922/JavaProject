package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	/**
	 * 获取对数据库的连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//8.0
//		    Class.forName("com.mysql.jdbc.Driver");//5.*版本
			String url = "jdbc:mysql://localhost:3306/cakeshopprj?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8&useSSL=false";
			conn = DriverManager.getConnection(url,"root","980802");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
