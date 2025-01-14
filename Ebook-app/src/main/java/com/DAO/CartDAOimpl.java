package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookDtls;
import com.entity.Cart;

public class CartDAOimpl implements CartDAO{

	
	private Connection conn;
	public CartDAOimpl(Connection conn) {
		this.conn=conn;
	}
	
	public boolean addCart(Cart c) {
		
		boolean f = false;
		try {
			String sql = "insert into cart (bid,uid,book_name,author,price,total_price) values(?,?,?,?,?,?)";
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setInt(1, c.getBid());
			ps.setInt(2, c.getUserId());
			ps.setString(3, c.getBookName());
			ps.setString(4, c.getAuthor());
			ps.setDouble(5, c.getPrice());
			ps.setDouble(6, c.getTotal_price());
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	
	public List<Cart> getBookByUser(int userid) {
		List<Cart>  list = new ArrayList<Cart>();
		Cart c = null;
		double totalPrice=0.00;
		try {
			String sql = "select * from cart where uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs  = ps.executeQuery();
			while(rs.next()) {
				c=new Cart();
				c.setCid(rs.getInt(1));
				c.setBid(rs.getInt(2));
				c.setUserId(rs.getInt(3));
				c.setBookName(rs.getString(4));
				c.setAuthor(rs.getString(5));
				c.setPrice(rs.getDouble(6));
				totalPrice+=rs.getDouble(7);
				c.setTotal_price(totalPrice);
				list.add(c);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

		public boolean deleteBook(int bid,int uid) {
			boolean f = false;
			try {
			String sql = "delete from cart where bid=? and uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setInt(2, uid);
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return f;
			
			}
	
	
  

}
