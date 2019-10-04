package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
		
	private static String ip="127.0.0.1";
	private static String port="3306";
	private static String dataBase="cart";
	private static String encoding="UTF-8";
	private static String loginName="root";
	private static String password="";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		String url=String.format("jdbc:mysql://%s:%s/%s?characterEncoding=%s", ip,port,dataBase,encoding);
		return DriverManager.getConnection(url,loginName,password);
	}
}
