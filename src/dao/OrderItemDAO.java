package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Util.DBUtil;
import bean.OrderItem;

public class OrderItemDAO {

	public void insert(OrderItem oi){
		String sql = "insert into orderitem values(null,?,?,?)";
		try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setInt(1,oi.getProduct().getId());
            ps.setInt(2,oi.getNum());
            ps.setInt(3,oi.getOrder().getId());
             
            ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
