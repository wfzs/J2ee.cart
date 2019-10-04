package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Util.DBUtil;
import bean.Product;

public class ProductDAO {
	
	public int getTotal(){
		int total=0;
		try(Connection c=DBUtil.getConnection();Statement s=c.createStatement()){
			String sql="select count(*) from product";
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
	public Product getProduct(int id){
		Product product=null;
		String sql="select * from product where id=?";
		try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				product=new Product();
				product.setId(id);
				product.setName(rs.getString(2));
				product.setPrice(rs.getFloat(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	public List<Product> list(){
		return list(0,Short.MAX_VALUE);
	}
	public List<Product> list(int start,int count){
		List<Product> products=new ArrayList<Product>();
		String sql="select * from product order by id desc limit ?,?";
		try(Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement(sql)){
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Product product=new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getFloat(3));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
}
