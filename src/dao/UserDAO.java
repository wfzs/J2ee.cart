package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Util.DBUtil;
import bean.User;

public class UserDAO {

	public int getTotal(){
		int total=0;
		String sql="select count(*) from user";
		try(Connection c=DBUtil.getConnection();Statement s=c.createStatement()){
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()){
				total=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	public User getUser(String name, String password){
		User result=null;
		String sql="select * from user where name=? and password=?";
		try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				result=new User();
				result.setId(rs.getInt(1));
				result.setName(name);
				result.setPassword(password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
